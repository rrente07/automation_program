# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Selenium WebDriver UI test automation project (Java 21, Maven, JUnit 5) targeting the practice site `https://www.qualitystream-practice.com/`. Uses the Page Object Model, ExtentReports for HTML reports, and SLF4J/Logback for logging. Some comments and test names are in Spanish (it originated as a course project).

## Commands

There is no Maven wrapper script checked in; use a local `mvn` (Jenkins uses Maven 3.9.9 + JDK 21).

```bash
mvn clean test                                   # run the regression suites
mvn test -Dtest=QSCreditCardTest                 # single class
mvn test -Dtest=QSCreditCardTest#areCreditCardsImagesPresent   # single method
mvn clean test -Dgroups="Action_Regression,CreditCards_Regression,AlertTest_Regression"  # the command Jenkins runs (see gotcha below)
```

**Tag filtering gotcha:** `pom.xml` hardcodes surefire `<groups>` to `Action_Regression, CreditCards_Regression, AlertTest_Regression, Products_Regression`. Only classes/methods carrying one of these `@Tag`s run under Maven — untagged classes (everything in `clase1/`, `clase2/`, most of `HomeTest`) are skipped even when targeted with `-Dtest`. Because the groups are set explicitly in the POM, a `-Dgroups` on the command line may not override them; edit the POM (or run from the IDE) to run untagged tests. Note that many unrelated classes reuse the `AlertTest_Regression` tag.

## Architecture

- **Driver lifecycle:** `config.WebDriverFactory.createDriver(BrowserType)` builds the driver and stores it in `config.DriverManager` (a `ThreadLocal<WebDriver>`). `test.BaseTest` creates one driver per test class in `@BeforeAll`, opens the home page, and quits in `@AfterAll` — so all tests in a class share one browser session and state carries over between test methods.
- **Headless detection:** Chrome runs headless (1920x1080, no-sandbox) only when the `JENKINS_HOME` env var is set; locally it starts maximized. Chrome downloads go to `<project>/downloads` (`config.Configuration.DOWNLOAD_PATH`). `BrowserType.CRHOME` (typo) is what `BaseTest` passes; it falls through to the Chrome default branch.
- **Page objects (`src/main/java/pages`):** all extend `BasePage`, which gets the driver from `DriverManager` (not from the constructor argument — page constructors accept a `WebDriver` but ignore it). `BasePage` wraps every interaction with explicit waits (10s `WebDriverWait`) and provides JS scroll/click, alert, window-switching and file-upload helpers. Locators are `By` fields named `*_Locator` declared in each page class. Prefer adding interactions to `BasePage` helpers over calling `driver.findElement` directly.
- **Tests (`src/test/java/test`):** extend `BaseTest`, instantiate page objects in a static `@BeforeAll`, and are annotated with `@ExtendWith(ExtentReportExtension.class)` plus a `@Tag`. Data-driven tests use `@CsvFileSource` with CSVs in `src/test/resources/files/` (header row skipped via `numLinesToSkip = 1`). `src/main/java/data` holds POJOs (`Product`, `Student`) used for comparisons.
- **Reporting (`src/test/java/listeners`):** `ExtentReportExtension` (JUnit `TestWatcher` + class callbacks) writes one Spark HTML report per test class to `reports/<ClassName>_<timestamp>.html`, and on failure takes a screenshot via `ExtentManager.captureScreenshot()` into `reports/`. The `reports/` folder is wiped once per JVM run (`clearReportsFolderOnce`). Jenkins publishes `reports/*.html` and `target/surefire-reports/*.xml`.
- `clase1/` and `clase2/` are standalone learning exercises (locator strategies, OOP examples), not part of the framework.

## Test package (`src/test/java/test`)

Each test class covers one area of the site, works through one or more page objects, and carries the tag that decides whether Maven runs it:

| Class | Tag | Page objects | Covers |
|---|---|---|---|
| `BaseTest` | — | — | Shared setup and teardown: opens Chrome on the home page and quits it after the class |
| `HomeTest` | only `verifyYtbIconHeader` is tagged `AlertTest_Regression` | `HomePage` | Header YouTube icon, the "bottoms" filter link, footer logo |
| `QSCreditCardTest` | `CreditCards_Regression` | `HomePage`, `QSCreditCardsPage` | Card images and card details, including a data-driven version that reads `files/creditCards.csv` |
| `CourseTest` | `AlertTest_Regression` | `HomePage`, `CoursePage` | File download and upload, adding courses for one student or for several (data-driven from `files/students.csv`) |
| `AlertTest` | `AlertTest_Regression` | `HomePage`, `AlertsPages`, `WebElementPage` | Alert box, confirm (accept and dismiss), prompt |
| `ActionTest` | `Action_Regression` | `HomePage`, `WebElementPage`, `ActionPages` | Keyboard chords, copy and paste, hover (Selenium `Actions`) |
| `WebElementTest` | `AlertTest_Regression` | `HomePage`, `WebElementPage` | Switching to a new window and a new tab, then back |
| `ProductsDetailPageTest` | `Products_Regression` | `HomePage`, `ProductsDetailPage` | Product title and price, add to cart, invalid quantity, size dropdown (`verifyProductCantBeAddedIfSizeNotSelected` is `@Disabled`) |
| `ProductDetailsVerificationTest` | `Products_Regression` | `HomePage`, `ProductsDetailPage` | Title and price on the product list match the product detail page (compared through the `data.Product` class) |

How the tests are written:
- Page objects are created in a `static @BeforeAll` named `initPage()` or `initPageObjects()`. JUnit runs it after `BaseTest.beforeAll()`, so the driver already exists. Navigation that every test in the class needs (for example, clicking the credit-cards link and entering the password) also goes in that method.
- Because the whole class shares one browser session, each test starts on whatever page the previous test left open. Tests that change pages either navigate back themselves or depend on the order the tests run in; no class sets `@TestMethodOrder`.
- Tests check results with `Assertions` and a failure message, and log through an SLF4J `Logger`.
- Jenkins passes a `-Dgroups` without `Products_Regression`, but because the POM sets `<groups>` explicitly that flag is probably ignored, so Jenkins likely runs the `Products_Regression` tests too.
- A new test class should extend `BaseTest`, add `@ExtendWith(ExtentReportExtension.class)` so it appears in the reports, and use a tag that is in the POM's `<groups>`. Without such a tag, `mvn test` skips it.

## User-story workflow (project skills)

Three skills in `.claude/skills/` take a user story from plan to push. Every artifact for a story lives in `.claude/<STORY-ID>/`.

1. `/test-plan [file|ID]` saves the story as `user-story.md` and writes `test-plan.md`, with test cases named `TC-<ID>-NN` and a decision for each case on whether it is automated or tested manually.
2. `/automate-tests <ID>` writes page objects and tests that follow the patterns above, runs them, and writes `automation-summary.md`, which lists the files it touched and maps each test case to a test method.
3. `/push-tests <ID>` first runs the `code-reviewer` subagent (`.claude/agents/code-reviewer.md`), saves its report as `code-review.md`, and stops if the report contains high-severity findings. It then creates a `test/<ID>-…` branch, commits only the files listed in the summary plus the story folder, and pushes. The user opens the PR and merges it.

## Gotchas

- The git repository root is the parent folder (`D:\Quality Assurance Automation Projects`), not this project. It also holds unrelated sibling projects, many untracked (`APIAutomationQS/`, `UI-automation-Playwright/`, …). Git paths are relative to the parent (`QualityAssuranceTest/...`), and you should never `git add -A` or `git add .` from the root; stage explicit paths.

- Logging is configured in `src/test/resources/logback-test.xml`: root level `debug`, written to the console and appended to `logs/test-log.log`.
- Screenshot and report-clearing paths use Windows `\\` separators; the Jenkins pipeline uses `bat` and runs from the parent repo directory with `dir('QualityAssuranceTest')`.
- `reports/`, `logs/`, `downloads/` are gitignored runtime output.

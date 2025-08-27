package data;

public class Product {
 private int index;
 private String title;
 private double price;

    public Product(int index, String title, double price) {
        this.index = index;
        this.title = title;
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

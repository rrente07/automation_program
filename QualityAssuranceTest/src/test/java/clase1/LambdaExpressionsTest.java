package clase1;

import org.junit.jupiter.api.Test;
import test.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressionsTest extends BaseTest {
/*
    Lambda Expressions en Java
    - Son funciones anónimas que se pueden usar para implementar interfaces funcionales.
    - Sintaxis:
    (parámetros) -> { cuerpo }
    Ejemplos:
    () -> System.out.println("Hola");
    (x, y) -> x + y;
    s -> s.toUpperCase();
    Se usan comúnmente con Streams para transformar, filtrar o procesar colecciones de forma concisa.
    */

    @Test
    void lamdaTest() {
        List<String> list = Arrays.asList("Java", "JavaScript", "Python", "C#");

        //Filter the elements of the list
        list.stream().forEach(System.out::println);
        list.stream().filter(name -> name.startsWith("J")).forEach(System.out::println);
        // n -> System.out::println (n)
//Dado una lista de Enteros use Stream y Lambda para imprimir solo los numeros pares

        List<Integer> number = Arrays.asList(1,2,3,4,5, 6);
        number.stream().filter(n -> n%2==0 ).forEach(System.out::println);
        System.out.println("Imprmir toda la lista de numeros" + number);

        //Dado una lista de Enteros usando Lambda y Stream contar los elementos mayor que 10.
        List<Integer> number2 = Arrays.asList(5,15, 20, 10);
       long count =  number2.stream().filter(n -> n>10).count();
        System.out.println("Greater than 10" + count);
        
    }

    @Test
    void orderTest() {
        List<Integer> number2 = Arrays.asList(2,9,0,5,3,1,7,4,8,6);
        //Imprimir la lista original

        System.out.println(number2);
        //Sorted List
        System.out.println(number2.stream().sorted().toList());
        //Values greater tha 4

        List<Integer> greatherthan4 = number2.stream().filter(n ->n>4).toList();
        System.out.println("Greater than 4 list" + greatherthan4);
         }
}




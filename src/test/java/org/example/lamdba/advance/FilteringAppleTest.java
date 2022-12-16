package org.example.lamdba.advance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static org.example.lamdba.advance.Apple.Color.GREEN;
import static org.example.lamdba.advance.Apple.Color.RED;
import static org.example.lamdba.advance.Book.Genre.*;
import static org.example.lamdba.advance.FilteringApple.filter;
import static org.example.lamdba.advance.FilteringApple.filterApples;
import static org.junit.jupiter.api.Assertions.*;

class FilteringAppleTest {
    @Test
    void test() {

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, GREEN));
        inventory.add(new Apple(155, GREEN));
        inventory.add(new Apple(120, RED));
        inventory.add(new Apple(90, GREEN));
        inventory.add(new Apple(110, RED));
        inventory.add(new Apple(50, RED));

        // 녹생 사과만 필터링
        //  List<Apple> list = FilteringApple.filterGreenApples(inventory);

        // 색깔을 지정
        //  List<Apple> list = FilteringApple.filterApplesByColor(inventory, RED);

        // 필터조건을 지정
        List<Apple> list =filterApples(inventory, apple -> apple.getWeight() > 100 && apple.getColor() ==RED);
        for (Apple apple : list) {
            System.out.println(apple);
        }

        // 범용 메서드 filter 사용
        List<Book> bookList = new ArrayList<>();
        bookList.addAll(
            Arrays.asList(
                new Book(10000, HISTORY)
                , new Book(20000, ESSAY)
                , new Book(15000, HISTORY)
                , new Book(14000, BIBLE)
                , new Book(17000, COMICS)
                , new Book(13000, COMICS)
            )
        );

        List<Book> books = filter(bookList, b-> b.getGenre() == COMICS);
        List<Apple> apples = filter(inventory, a -> a.getWeight() < 100);

        // 정수 리스트
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // (args) -> expr.instanceMethod(args)` => `expr::instanceMethod`
        numbers.forEach(i -> System.out.println(i));
        numbers.forEach(System.out::println);

        /*
        numbers.forEach(new Consumer<Integer>() { // foreach는 accept를 반복해서 불러온다
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

         */
        // 홀수만 필터링
        List<Integer> integers = filter(numbers, n -> n % 2 == 1);
        for (Integer n : integers) {
            System.out.println(n);
        }

        List<Integer> integerList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(integerList);
    }
    @Test
    void sortTest() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(80, GREEN));
        inventory.add(new Apple(155, GREEN));
        inventory.add(new Apple(120, RED));
        inventory.add(new Apple(90, GREEN));
        inventory.add(new Apple(110, RED));
        inventory.add(new Apple(50, RED));

        // 정렬
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        // 무게 오름차 정렬
        inventory.sort(comparing(apple -> apple.getWeight()));
        inventory.sort(comparing(Apple::getWeight));

        // 무게 내림차 정렬
        inventory.sort(comparing(Apple::getWeight).reversed());

        inventory.forEach(System.out::println);
    }
}
package com.SpringProject;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void streamPractice(){
        List<String> fruits = List.of("Apples", "Kiwi", "Mangoes", "Banana");

        Stream<String> stream = fruits.stream();

        stream.forEach((fruit) ->  {
            System.out.println(fruit);
        });

        /*stream has already been operated upon or closed - Can only be used ONCE
        stream.forEach((fruit) ->  {
            System.out.println(fruit);
        });*/

        System.out.println("SORTED STREAM");
        Stream<String> stream2 = fruits.stream();

        stream2.sorted().forEach((fruit) -> System.out.println(fruit));

        System.out.println("MAP STREAM");
        Stream<String> stream3 = fruits.stream();

        stream3.map(fruit -> fruit.length()).sorted().forEach((fruit) -> System.out.println(fruit));

        System.out.println("FILTER STREAM");
        Stream<String> stream4 = fruits.stream();

        stream4.filter(fruit -> fruit.length() < 5).sorted().map(fruit -> fruit.length()).forEach((fruit) -> System.out.println(fruit));

        List<Integer> fruitsList = fruits.stream().map(fruit -> fruit.length()).collect(Collectors.toList());
        System.out.println("The List of Fruits " +fruitsList);

        Set<Integer> fruitSet = fruits.stream().map(fruit -> fruit.length()).collect(Collectors.toSet());
        System.out.println("The Set of Fruits(duplicates removed) " +fruitSet);

        List<String> brands = List.of("Kia", "Hyundai", "Tata", "Mahindra");

        Map<Integer, String> brandMap = brands.stream().collect(Collectors.toMap(String::length, brand -> brand));
        System.out.println("The Map of Brands(key Value pair) " +brandMap);
    }
}

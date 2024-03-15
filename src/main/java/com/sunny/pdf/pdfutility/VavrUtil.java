package com.sunny.pdf.pdfutility;

import io.vavr.Function1;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.util.*;
import java.util.stream.Stream;

public class VavrUtil {

    public static void main(String[] args) {

        //tryContainer();

        /*Try<Integer> integers = Try.of(() -> 1 / 0);

        if (integers.isFailure()) {
            System.out.println("Failed!");
        }

        String optionNull = null;
        Option<String> integers1 = Option.of(optionNull);
        System.out.println(integers1.getOrElse("somethingelse"));

        Function1<Integer, Integer> square = (num) -> num * num;
        int y = square.apply(2000);
        System.out.println(y);

        Map<String, String> stringStringMap = Map.of("1", "Sunny", "2", "Prachi", "3", "Agastya");
        Map<String, String> stringStringMap2 = Map.of("4", "Sunny2", "5", "Prachi2", "6", "Agastya2");

        List<Map<String, String>> listOfMap = new ArrayList<>();
        listOfMap.add(stringStringMap);
        listOfMap.add(stringStringMap2);

        String first = listOfMap.stream()
                .peek(g -> System.out.println("g => " + g))
                .flatMap(e -> e.entrySet().stream()
                        .peek(g -> System.out.println("g2 => " + g))
                        .filter(f -> f.getKey().equals("3") && f.getValue().equals("Sunny4")))
                        .peek(g -> System.out.println("g3 => " + g))
                .map(Map.Entry::getValue)
                .peek(g -> System.out.println("g4 => " + g))
                .findFirst().orElse("Nothing found");


        System.out.println("details=>" + first);


        List<List<String>> listOfLists = List.of(List.of("sunny", "prachi", "agastya"));

        String name = listOfLists.stream()
                .flatMap(lst -> lst.stream()
                        .filter(e -> e.equals("sunny"))).findFirst().orElse("no name found");

        System.out.println("name=>" + name);*/
    }

    /*public static void tryContainer() {

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 0);

        Try<String> results = Try.of(divide());
        String recover = Try.of(
                divide()
                .onSuccess(e -> System.out.println("successful response " + e))
                .recover(e -> {
                    System.out.println(e.getMessage());
                    return e.getMessage();
                })
                .get());

        *//*if (recover.isSuccess()) {
            System.out.println("success Total sum::" + recover.get());
        } else {
            System.out.println("Total sum::" + recover.get());
        }*//*

    }*/

    private static String divide() {
        throw new RuntimeException("some exception happened!");
    }

    public int solution(int A, int B, int C) {
        // Implement your solution here
        Set<Integer> conformingIntegers = new HashSet<>();

        // Iterate through all possible 30-bit unsigned integers
        for (int i = 0; i < (1 << 30); i++) {
            if (conformsTo(i, A) || conformsTo(i, B) || conformsTo(i, C)) {
                conformingIntegers.add(i);
            }
        }

        return conformingIntegers.size();
    }

    private boolean conformsTo(int num, int mask) {
        return (num & mask) == mask;
    }

    public int solution(int[] A) {
        if (A.length <= 0) {
            return 0;
        }
            // Implement your solution here
            HashSet<Integer> set = new HashSet<>();

        // Add all positive integers from array A to the HashSet
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Iterate over positive integers starting from 1 until we find the smallest missing integer
        int smallestMissing = 1;
        while (set.contains(smallestMissing)) {
            smallestMissing++;
        }

        return smallestMissing;
    }


}
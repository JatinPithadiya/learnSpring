package com.learn.functional.programming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PlayWithOptional {

    

    public static void main(String[] args) {
        
        List<String> fruits = Arrays.asList("apply","banana","mango");

        Optional<String> optional = fruits.stream().filter(fruit -> fruit.startsWith("b")).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Optional<String> optional1 = Optional.of("banana"); //way to create optional object
        Optional<Object> optional2 = Optional.empty(); //Create empty optional
    }

}

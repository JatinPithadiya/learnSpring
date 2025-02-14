package com.learn.functional.programming;

import java.util.List;

public class FP01 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2,3,5,6,7,8,9,12,13,15,16);
        List<String> courses = List.of("Spring","Springboot","API","Microservices","AWS","PCF","Azure","Docker","Kubernetes");
       // printAllnumbers(numbers);
       // printEvenNumbers(numbers);
       //printOddNumbers(numbers);
       //printAllCourses(courses);
       //printAllCoursesWithSpring(courses);
       //printAllCoursesWith4letters(courses);
       //printSquareOfNumber(numbers);
       //printQubeOfOddNumber(numbers);
       printNumberOfChars(courses);
    }
                
    private static void printEvenNumbers(List<Integer> numbers) {
            numbers.stream().filter(number->number%2==0).forEach(System.out::println);
    }

    private static void printOddNumbers(List<Integer> numbers) {
            numbers.stream().filter(number->number%2!=0).forEach(System.out::println);
    }
        
    private static void printAllnumbers(List<Integer> numbers) {
         numbers.stream().forEach(System.out::println);       
    }

    private static void printAllCourses(List<String> courses) {
        courses.stream().forEach(System.out::println);       
   }

   private static void printAllCoursesWithSpring(List<String> courses) {
    courses.stream().
    filter(course->course.contains("Spring")).
    forEach(System.out::println);       
   }

   private static void printAllCoursesWith4letters(List<String> courses) {
    courses.stream().
    filter(course->course.length()>3).
    forEach(System.out::println);       
   }

   
   private static void printSquareOfNumber(List<Integer> numbers) {
    numbers.stream().
    filter(number->number%2==0).
    map(number -> number * number).
    forEach(System.out::println);       
   }

   
   private static void printQubeOfOddNumber(List<Integer> numbers) {
    numbers.stream().
    filter(number->number%2!=0).
    map(number -> number * number * number).
    forEach(System.out::println);       
   }

   private static void printNumberOfChars(List<String> courses) {
    courses.stream().
    map(course -> course.length()).
    forEach(System.out::println);       
   }
}

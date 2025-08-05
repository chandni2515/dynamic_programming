package Practise.Java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPractice2 {
    public static void main(String[] args) {

        //1. Given a sentence, find and print the frequency of each word.
        String str="Java is a programming language. Java is versatile";
        Map<String,Long> wordFreqMap = Arrays.stream(str.split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        Map<Character, Long> charFreqMap = str.toLowerCase()
                .replaceAll("\\s+", "")
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("wordFreqMap = " + wordFreqMap);
        System.out.println("charFreqMap = " + charFreqMap);
        
        //2. Given a list of integers, find out all the numbers starting with 1.


        //3. Given a list of names, group them by their first letter, and then count the number of names in each group.



        // 4. Find and print duplicate numbers in an array if it contains multiple duplicates?

        int[] arr = {2,4,2,3,1,5, 5,78,3,1,5};




        // 5. How are duplicates removed from a given array in Java?
//
        int[] arr2 = {2,4,2,3,1,78};



        //6. Given a list of words, filter and print the palindromes





        // 7. How do you merge two sorted arrays into a single sorted array?
        int[] array1 = {1, 3,32, 5, 7};
        int[] array2 = {2, 4, 6,62, 8};


        //8. Given two lists of strings, concatenate them and remove duplicates.

//        List<String> list1 = List.of("apple", "banana", "orange");
//        List<String> list2 = List.of("banana", "kiwi", "grape");



        // 9. Student Grade Classification - 70 and above pass



        //10. Given a list of strings, sort them according to increasing order of their length.

        List<String> fruits = Arrays.asList("Mango","pear" ,"Apple", "Banana", "Pineapple", "Kiwi");



        //12.Partition a list of numbers into two groups: even and odd, using a custom predicate.
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        //13. Find the squares of the first three even numbers in a list.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        // 14. Flatten a list of lists



    }
}

package Practise.DP_ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.Scanner;

public class Coderbyte {
    public static String WordSplit(String[] strArr) {
        String word = strArr[0];
        String[] dictionaryArray = strArr[1].split(",");
        List<String> dictionary = new ArrayList<>(Arrays.asList(dictionaryArray)); // Store in ArrayList

        for (int i = 1; i < word.length(); i++) {
            String first = word.substring(0, i);
            String second = word.substring(i);

            if (dictionary.contains(first) && dictionary.contains(second)) {
                return first + "," + second;
            }
        }

        return "not possible";
    }

    public static void main (String[] args) {
        // keep this function call here
        String[] arr1 = {"hellocat", "apple,bat,cat,goodbye,hello,yellow,why"};
        String[] arr2 = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        String[] arr3 = {"abcgefd", "ab,abc,abcg,b,c,cef,efd,g,ge,gef"};
        String[] arr4 = {"aaaaaa", "a,aa,aaa,aaaa,aaaaa,aaaaaa,b"};
        String[] arr5 = {"abcd", "a,b,c,d,ab,cd,abc,bcd,abcd"};
        String[] arr6 = {"abcdef", "a,b,c,d,e,f,ab,cd,ef,abc,def,abcd,bcde,cdef,abcdef"};
        String[] arr7 = {"ab", "a,b,c,d,e,f,ab,cd,ef,abc,def,abcd,bcde,cdef,abcdef"};
        String[] arr8 = {"hellocatbye", "apple,bat,cat,goodbye,hello,yellow,why,bye"};
        String[] arr9 = {"abcdefg", "a,b,c,d,e,f,g,ab,cd,ef,abc,def,abcd,bcde,cdef,abcdef,abcdefg"};
        String[] arr10 = {"ab", "a,b"};

        System.out.println(WordSplit(arr1));
        System.out.println(WordSplit(arr2));
        System.out.println(WordSplit(arr3));
        System.out.println(WordSplit(arr4));
        System.out.println(WordSplit(arr5));
        System.out.println(WordSplit(arr6));
        System.out.println(WordSplit(arr7));
        System.out.println(WordSplit(arr8));
        System.out.println(WordSplit(arr9));
        System.out.println(WordSplit(arr10));
    }
}

/**
 que: Have the function ArrayCouples(arr) take the arr parameter being passed which will be an array of an even number of positive integers, and determine if each pair of integers, [k, k+1], [k+2, k+3], etc. in the array has a corresponding reversed pair somewhere else in the array. For example: if arr is [4, 5, 1, 4, 5, 4, 4, 1] then your program should output the string yes because the first pair 4, 5 has the reversed pair 5, 4 in the array, and the next pair, 1, 4 has the reversed pair 4, 1 in the array as well. But if the array doesn't contain all pairs with their reversed pairs, then your program should output a string of the integer pairs that are incorrect, in the order that they appear in the array. For example: if arr is [6, 2, 2, 6, 5, 14, 14, 1] then your program should output the string 5,14,14,1 with only a comma separating the integers.
sample input:{2,1,1,2,3,3}, output-3,3 input:{5,4,6,7,7,6,4,5},output-yes


public class Main {
    public static String ArrayCouples(int[] arr) {
        Map<Integer, Integer> table = new HashMap<>();

        // traverse our array
        for (int x = 0; x < arr.length - 1; x += 2) {
            boolean found = false;

            // section to analyze our hash table
            for (Map.Entry<Integer, Integer> y : table.entrySet()) {
                // condition to check if pair has a reverse
                if ((y.getKey() == arr[x] && y.getValue() == arr[x + 1]) || (y.getKey() == arr[x + 1] && y.getValue() == arr[x])) {
                    // remove the stored pair from our table
                    table.remove(y.getKey());
                    found = true;
                    break;
                }
            }

            if (!found) {
                // adding to our table if the pair is new
                table.put(arr[x], arr[x + 1]);
            }
        }

        // checking result based on the hash table
        if (table.isEmpty()) {
            return "yes";
        }

        // converting to string
        StringBuilder convert = new StringBuilder();
        for (Map.Entry<Integer, Integer> x : table.entrySet()) {
            convert.append(x.getKey()).append(",").append(x.getValue()).append(",");
        }

        // Remove the last comma
        if (convert.length() > 0) {
            convert.setLength(convert.length() - 1);
        }

        return convert.toString();
    }

    public static void main(String[] args) {
        int[] A = { 4, 5, 1, 4, 5, 4, 4, 1 };
        int[] B = { 6, 2, 2, 6, 5, 14, 14, 1 };
        int[] C = { 2, 1, 1, 2, 3, 3 };
        int[] D = { 5, 4, 6, 7, 7, 6, 4, 5 };

        System.out.println(ArrayCouples(A)); // yes
        System.out.println(ArrayCouples(B)); // 5,14,14,1
        System.out.println(ArrayCouples(C)); // 3,3
        System.out.println(ArrayCouples(D)); // yes
    }
}

*/
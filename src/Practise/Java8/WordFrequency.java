package Practise.Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String str = "Java is a programming language. Java is versatile";

        // 1. Frequency of Characters:
//        Approach 1:
        System.out.println("Frequency of Characters: ");
        Map<Character, Long> charFreqMap = str.toLowerCase()
                .replaceAll("\\s+", "")
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("charFreqMap = " + charFreqMap);

//        Approach 2:
        HashMap<Character, Long> freq = new HashMap<>();
        str.toLowerCase().replaceAll("\\s+", "")
                .chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> freq.put(c, freq.getOrDefault(c, 0L) + 1));
        System.out.println("freq = " + freq);

//        2. Word Frequency Ignoring Punctuation
        System.out.println("\nWord Frequency Ignoring Punctuation ");
        Map<String, Long> freqMap = Arrays.stream(str.toLowerCase().replaceAll("[^a-z\\s]", "")
                        .split("\\s"))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("freqMap = " + freqMap);

//        3. Most Frequent Word:
        System.out.println("\nMost Frequent Word: ");
        Map.Entry<String, Long> maxElement = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println("maxElement = " + maxElement);

//        4. Sort Frequency Map by Count Descending:
        System.out.println("\nSort Frequency Map by Count Descending:");
        freqMap.entrySet().stream()
//                cleaner way:
//                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
//                traditional way:
                .sorted((s1, s2) -> Long.compare(s2.getValue(), s1.getValue()))
                .forEach(System.out::println);

//        5. Unique Words (Appearing Once):
        System.out.println("\nUnique Words (Appearing Once):");
        freqMap.entrySet().stream()
                .filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

//      6. Alphabetical Order of Word Frequency:
        System.out.println("\n6. Alphabetical Order of Word Frequency:");
        freqMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

//      7. Use TreeMap Directly for Sorted Collection:
        System.out.println("\nUse TreeMap Directly for Sorted Collection:");
        TreeMap<String, Long> sortedMap = new TreeMap<>(freqMap);
        sortedMap.entrySet().forEach(System.out::println);

//      8. Filter Words with Frequency > 1:
        System.out.println("\nFilter Words with Frequency > 1:");
        freqMap.entrySet().stream()
                .filter(s -> s.getValue() > 1)
                .forEach(System.out::println);

//      9. Group Words by Their Length:
        System.out.println("\nGroup Words by Their Length:");
        Map<Integer, List<String>> groupedWords = Arrays.stream(str.toLowerCase().split("\\s"))
                .collect(Collectors.groupingBy(String::length));
        groupedWords.entrySet().forEach(System.out::println);

//      10. Group Words by Their Frequency:
        System.out.println("\n10. Group Words by Their Frequency:");
        Map<Long, List<String>> groupedByFreq = freqMap.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        groupedByFreq.entrySet().forEach(System.out::println);
    }
}

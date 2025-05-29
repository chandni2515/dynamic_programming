package Practise.DP_ques;

import java.util.ArrayList;
import java.util.List;

public class SequenceGenerator {

    public static String[] findSequences(long n) {
        List<String> results = new ArrayList<>();

        // Check for sequences starting with p = 1, 2, ...
        for (long p = 1; p * p < n; p++) {
            long sum = 0;
            List<Long> sequence = new ArrayList<>();

            // Try adding successive squares to the sum
            for (long i = p; sum < n; i++) {
                sum += i * i;
                sequence.add(i);

                // If sum matches n, record the sequence
                if (sum == n) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sequence.size());  // Add the size of the sequence

                    // Append each number in the sequence using StringBuilder
                    for (long num : sequence) {
                        sb.append(" ").append(num);  // Append each number with a space
                    }

                    results.add(sb.toString());  // Add the formatted string to results
                    break;
                }
            }
        }

        // Sort sequences by the number of terms in descending order
        results.sort((a, b) -> Integer.compare(b.split(" ").length, a.split(" ").length));

        // Add the total number of sequences at the start
        List<String> finalResults = new ArrayList<>();
        finalResults.add(String.valueOf(results.size()));  // Total number of sequences
        finalResults.addAll(results);  // Add the sequences themselves

        // Convert the list to a String array
        return finalResults.toArray(new String[0]);
    }

    public static void main(String[] args) {
        long n = 2030;
        String[] sequences = findSequences(n);

        // Print the results
        for (String sequence : sequences) {
            System.out.println(sequence);  // Expected Output: ["2", "4 21 22 23 24", "3 25 26 27"]
        }
    }
}

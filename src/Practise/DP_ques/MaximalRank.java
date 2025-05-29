package Practise.DP_ques;

import java.util.ArrayList;
import java.util.List;

public class MaximalRank {

    /**
     * Given two arrays A and B representing roads between cities, and the total
     * number of cities N, this function calculates the maximum network rank.
     * The network rank of two directly connected cities is the total number of
     * roads connected to either of the two cities.
     *
     * @param A An array of integers representing one end of each road.
     * @param B An array of integers representing the other end of each road.
     * @param N The total number of cities.
     * @return The maximum network rank among all pairs of directly connected cities.
     */
    public int solution(int[] A, int[] B, int N) {
        List<List<Integer>> adjList = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            adjList.get(A[i]).add(B[i]);
            adjList.get(B[i]).add(A[i]);
        }
        // System.out.println(adjList);

        boolean[] visited = new boolean[N + 1];
        int maxNetworkRank = 0;

        for (int city = 1; city <= N; city++) {
            for (int adjCity : adjList.get(city)) {
                if (visited[adjCity]) {
                    continue;
                }
                maxNetworkRank = Math.max(maxNetworkRank, adjList.get(city).size() + adjList.get(adjCity).size() - 1);
            }
            visited[city] = true;
        }

        return maxNetworkRank;
    }

    public static void main(String[] args) {
        MaximalRank sol = new MaximalRank();

        // Example 1
        int[] A1 = {1, 2, 3, 3};
        int[] B1 = {2, 3, 1, 4};
        int N1 = 4;
        int result1 = sol.solution(A1, B1, N1);
        System.out.println("Example 1 Result (Max Network Rank): " + result1); // Expected output: 3

        // Example based on the second original example (assuming we need max network rank)
        int[] A2 = {1, 2, 4, 5};
        int[] B2 = {2, 3, 5, 6};
        int N2 = 6;
        int result2 = sol.solution(A2, B2, N2);
        System.out.println("Example 2 Result (Max Network Rank): " + result2); // Expected output: 2
    }
}
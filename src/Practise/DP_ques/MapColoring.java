package Practise.DP_ques;

import java.util.*;

public class MapColoring {
    private Map<Integer, List<Integer>> graph;
    private Set<String> blackSegments;

    public MapColoring(String[] input) {
        graph = new HashMap<>();
        blackSegments = new HashSet<>();

        // Parse the input
        String[] firstLine = input[0].split(",");
        int n = Integer.parseInt(firstLine[0]); // number of segments
        int m = Integer.parseInt(firstLine[1]); // number of operations

        // Build the graph from the input segments
        for (int i = 1; i < n; i++) {
            if (i < input.length) {
                String[] parts = input[i].split(",");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                graph.putIfAbsent(u, new ArrayList<>());
                graph.putIfAbsent(v, new ArrayList<>());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
        }

        List<String> results = new ArrayList<>();

        // Perform operations
        for (int i = n; i < n + m; i++) {
            if (i < input.length) {
                String[] parts = input[i].split(",");
                int operationType = Integer.parseInt(parts[0]);
                int a = Integer.parseInt(parts[1]);
                int b = Integer.parseInt(parts[2]);

                if (operationType == 1) {
                    performOperation1(a, b);
                } else if (operationType == 2) {
                    int count = performOperation2(a, b);
                    results.add(String.valueOf(count)); // Store the count as a string
                }
            }
        }

        // Convert results to String[]
        String[] output = results.toArray(new String[0]);
        System.out.println(Arrays.toString(output)); // Print the output for verification
    }

    public void performOperation1(int a, int b) {
        List<Integer> path = findPath(a, b);
        if (path != null) {
            // Change all segments on the path to black
            for (int i = 0; i < path.size() - 1; i++) {
                int u = path.get(i);
                int v = path.get(i + 1);
                String segment = u < v ? u + "," + v : v + "," + u;
                blackSegments.add(segment);
            }
        }
    }

    public int performOperation2(int a, int b) {
        List<Integer> path = findPath(a, b);
        if (path != null) {
            // Count the number of segments that are black
            int count = 0;
            for (int i = 0; i < path.size() - 1; i++) {
                int u = path.get(i);
                int v = path.get(i + 1);
                String segment = u < v ? u + "," + v : v + "," + u;
                if (blackSegments.contains(segment)) {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

    private List<Integer> findPath(int start, int end) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        if (dfs(start, end, visited, path)) {
            return path;
        }
        return null;
    }

    private boolean dfs(int current, int end, Set<Integer> visited, List<Integer> path) {
        visited.add(current);
        path.add(current);

        if (current == end) {
            return true;
        }

        for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, end, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        String[] input = {
                "8,5", //  8 segments, 5 operations
                "1,2",
                "1,3",
                "2,3",
                "2,4",
                "4,6",
                "4,5",
                "6,7",
                "6,8",
                "1,1,6", // Operation 1: color path from 1 to 6
                "1,2,5", // Operation 2: count black segments from 2 to 5
                "2,1,8", // Operation 2: count black segments from 1 to 8
                "1,3,7", // Operation 1: color path from 3 to 7
                "2,4,8"  // Operation 2: count black segments from 4 to 8
        };
        new MapColoring(input);
    }
}
package Practise.DP_ques;

import java.util.*;

public class RedBlackTree {

    static class Edge {
        int to, id;
        Edge(int to, int id) { this.to = to; this.id = id; }
    }

    static final int LOG = 17;
    static Map<Integer, List<Edge>> tree = new HashMap<>();
    static Map<Integer, Integer[]> up = new HashMap<>();
    static Map<Integer, Integer> depth = new HashMap<>();
    static Map<Integer, Integer> parentEdge = new HashMap<>();
    static Set<Integer> allNodes = new HashSet<>();
    static boolean[] black;

    public static int[] solution(String[] input) {
        int n = Integer.parseInt(input[0].split(" ")[0]);
        int m = Integer.parseInt(input[0].split(" ")[1]);

        black = new boolean[n]; // n nodes → n-1 edges → edge IDs 0 to n-2

        Set<Integer> validNodes = new HashSet<>();
        int edgeId = 0;

        // Parse edges
        for (int i = 1; i < n; i++) {
            String[] parts = input[i].split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);

            tree.computeIfAbsent(u, x -> new ArrayList<>()).add(new Edge(v, edgeId));
            tree.computeIfAbsent(v, x -> new ArrayList<>()).add(new Edge(u, edgeId));

            allNodes.add(u);
            allNodes.add(v);
            validNodes.add(u);
            validNodes.add(v);
            edgeId++;
        }

        // Pick a root and initialize
        int root = allNodes.iterator().next();
        dfs(root, root, -1);

        List<Integer> result = new ArrayList<>();

        // Process queries
        for (int i = n; i < input.length; i++) {
            String[] q = input[i].split(" ");
            int type = Integer.parseInt(q[0]);
            int a = Integer.parseInt(q[1]);
            int b = Integer.parseInt(q[2]);

            // Skip queries on unknown/unreachable nodes
            if (!depth.containsKey(a) || !depth.containsKey(b)) {
                result.add(0);
                continue;
            }

            if (type == 1) {
                resetPath(a, b);
                paintPath(a, b);
            } else {
                result.add(countBlackEdges(a, b));
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    static void dfs(int node, int parent, int edgeId) {
        Integer[] anc = new Integer[LOG];
        anc[0] = parent;
        up.put(node, anc);
        parentEdge.put(node, edgeId);
        depth.put(node, parent == node ? 0 : depth.get(parent) + 1);

        for (int i = 1; i < LOG; i++) {
            Integer prev = anc[i - 1];
            anc[i] = (prev != null && up.containsKey(prev)) ? up.get(prev)[i - 1] : null;
        }

        for (Edge e : tree.getOrDefault(node, Collections.emptyList())) {
            if (e.to != parent) {
                dfs(e.to, node, e.id);
            }
        }
    }

    static int lca(int a, int b) {
        if (depth.get(a) < depth.get(b)) {
            int t = a; a = b; b = t;
        }

        for (int i = LOG - 1; i >= 0; i--) {
            Integer anc = up.get(a)[i];
            if (anc != null && depth.get(anc) >= depth.get(b)) {
                a = anc;
            }
        }

        if (a == b) return a;

        for (int i = LOG - 1; i >= 0; i--) {
            Integer ua = up.get(a)[i], ub = up.get(b)[i];
            if (ua != null && ub != null && !ua.equals(ub)) {
                a = ua;
                b = ub;
            }
        }

        return up.get(a)[0];
    }

    static void resetPath(int a, int b) {
        Set<Integer> seen = new HashSet<>();
        for (int node : getPathNodes(a, b)) {
            for (Edge e : tree.getOrDefault(node, Collections.emptyList())) {
                if (seen.add(e.id)) black[e.id] = false;
            }
        }
    }

    static void paintPath(int a, int b) {
        for (int id : getPathEdges(a, b)) black[id] = true;
    }

    static int countBlackEdges(int a, int b) {
        int count = 0;
        for (int id : getPathEdges(a, b)) {
            if (black[id]) count++;
        }
        return count;
    }

    static List<Integer> getPathNodes(int a, int b) {
        List<Integer> path = new ArrayList<>(), tail = new ArrayList<>();
        int l = lca(a, b);
        while (a != l) { path.add(a); a = up.get(a)[0]; }
        while (b != l) { tail.add(b); b = up.get(b)[0]; }
        path.add(l);
        Collections.reverse(tail);
        path.addAll(tail);
        return path;
    }

    static List<Integer> getPathEdges(int a, int b) {
        List<Integer> edges = new ArrayList<>();
        int l = lca(a, b);
        while (a != l) { edges.add(parentEdge.get(a)); a = up.get(a)[0]; }
        while (b != l) { edges.add(parentEdge.get(b)); b = up.get(b)[0]; }
        return edges;
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int[] result = tree.solution(new String[]{"8 5", "1 2", "1 3", "3 4", "4 5","4 6", "2 8", "2 9", "1 1 6", "1 2 4", "2 1 6", "1 1 5", "2 2 6"});
        System.out.println("result: " + Arrays.toString(result));
    }
}


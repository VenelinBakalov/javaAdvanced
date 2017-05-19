package BFS;

import java.util.*;

/**
 * Created by Venelin on 19.5.2017 г..
 */
@SuppressWarnings("unchecked")
public class Main {

    private static String[] nodeNames = { "Ruse", "Sofia", "Pleven", "Varna", "Bourgas", "Stara Zagora", "Plovdiv" };
    private static List<Integer>[] childNodes = new List[] {
            Arrays.asList(3, 6),
            Arrays.asList(2, 3, 4, 5, 6),
            Arrays.asList(1, 4, 5),
            Arrays.asList(0, 1, 5),
            Arrays.asList(1, 2, 6),
            Arrays.asList(1, 2, 3),
            Arrays.asList(0, 1, 4)
    };

    public static void main(String[] args) {
        // Start BFS from node 4 - Bourgas
        traverseBFS(4);

    }

    // Iterative DFS is ABSOLUTELY the same but with Stack
    public static void traverseBFS(int node) {
        Deque<Integer> nodes = new ArrayDeque<>();
        boolean[] visited = new boolean[childNodes.length];

        // Enqueue the start node to the queue
        visited[node] = true;
        nodes.add(node);

        // BFS
        while (nodes.size() > 0) {
            int currentNode = nodes.poll();
            System.out.println(currentNode + " -> " + nodeNames[currentNode]);

            (childNodes[currentNode]).stream().filter(childNode -> !visited[childNode]).forEach(childNode -> {
                nodes.add(childNode);
                visited[childNode] = true;
            });

//            for (Integer childNode : childNodes[currentNode]) {
//                if (! visited[childNode]) {
//                    nodes.add(childNode);
//                    visited[childNode] = true;
//                }
//            }
        }
    }
}

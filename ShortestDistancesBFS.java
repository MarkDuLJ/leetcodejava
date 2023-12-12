import java.util.*;

public class ShortestDistancesBFS {
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('B', 'C'));
        graph.put('B', Arrays.asList('A', 'C', 'E'));
        graph.put('C', Arrays.asList('A', 'B', 'D', 'E'));
        graph.put('D', Arrays.asList('C', 'F', 'G'));
        graph.put('E', Arrays.asList('B', 'C', 'F'));
        graph.put('F', Arrays.asList('D', 'E', 'G'));
        graph.put('G', Arrays.asList('D', 'F'));

        Map<Character, Integer> distances = bfs(graph, 'A');

        for (Map.Entry<Character, Integer> entry : distances.entrySet()) {
            System.out.println("Shortest distance from A to " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<Character, Integer> bfs(Map<Character, List<Character>> graph, char start) {
        Map<Character, Integer> distances = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            char current = queue.poll();

            for (char neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!distances.containsKey(neighbor)) {
                    distances.put(neighbor, distances.get(current) + 1);
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }
}


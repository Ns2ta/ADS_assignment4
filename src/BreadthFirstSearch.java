import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {

    public BreadthFirstSearch(UnweightedGraph<T> graph, Vertex<T> source) {
        super(source);
        traverse(graph, source);
    }

    private void traverse(UnweightedGraph<T> graph, Vertex<T> root) {
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        visited.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            for (Vertex<T> neighbor : graph.adjacencyList(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    prev.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}

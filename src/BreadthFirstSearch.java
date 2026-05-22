import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(UnweightedGraph<T> graph, T source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(UnweightedGraph<T> graph, T current) {
        visitedVertices.add(current);

        Queue<T> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            T v = queue.remove();

            for (T vertex : graph.adjacencyList(v)) {
                if (!visitedVertices.contains(vertex)) {
                    visitedVertices.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
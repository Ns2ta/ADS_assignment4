public class DepthFirstSearch<T> extends Search<T> {

    public DepthFirstSearch(UnweightedGraph<T> graph, Vertex<T> source) {
        super(source);
        explore(graph, source);
    }

    private void explore(UnweightedGraph<T> graph, Vertex<T> node) {
        visited.add(node);
        for (Vertex<T> neighbor : graph.adjacencyList(node)) {
            if (!visited.contains(neighbor)) {
                prev.put(neighbor, node);
                explore(graph, neighbor);
            }
        }
    }
}

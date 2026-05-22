public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(UnweightedGraph<T> graph, T source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(UnweightedGraph<T> graph, T current) {
        visitedVertices.add(current);

        for (T V : graph.adjacencyList(current)) {
            if (!visitedVertices.contains(V)) {
                edgeTo.put(V, current);
                dfs(graph, V);
            }
        }
    }
}
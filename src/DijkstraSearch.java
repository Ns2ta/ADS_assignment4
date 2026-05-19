import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Set<Vertex<T>> unsettledNodes;
    private final Map<Vertex<T>, Double> distances;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<T> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex<T> neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex<T> node, Vertex<T> target) {
        for (Edge<T> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }

        throw new RuntimeException("Not found!");
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;
        for (Vertex<T> vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;
                continue;
            }

            if (getShortestDistance(vertex) < getShortestDistance(minimum))
                minimum = vertex;
        }

        return minimum;
    }

    private double getShortestDistance(Vertex<T> destination) {
        Double d = distances.get(destination);

        return (d == null ? Double.MAX_VALUE : d);
    }
}

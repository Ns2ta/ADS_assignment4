import java.util.*;

public class DijkstraSearch<T> extends Search<T> {

    private final Set<T> unvisitedNodes;
    private final Map<T, Double> shortestDistance;
    private final WeightedGraph<T> graphRef;

    public DijkstraSearch(WeightedGraph<T> graphRef, T startVertex) {
        super(startVertex);

        this.graphRef = graphRef;
        this.shortestDistance = new HashMap<>();
        this.unvisitedNodes = new HashSet<>();

        runDijkstra();
    }

    private void runDijkstra() {
        shortestDistance.put(startVertex, 0.0);
        unvisitedNodes.add(startVertex);

        while (!unvisitedNodes.isEmpty()) {

            T currentNode = extractMinDistanceNode(unvisitedNodes);

            visitedVertices.add(currentNode);
            unvisitedNodes.remove(currentNode);

            for (Vertex<T> adjacent : graphRef.adjacencyList(currentNode)) {

                T neighborNode = adjacent.getData();

                double alternativePath = getDistance(currentNode) + graphRef.getVertex(currentNode).getWeightedAdjacentVertex(adjacent);

                if (getDistance(neighborNode) > alternativePath) {
                    shortestDistance.put(neighborNode, alternativePath);
                    edgeTo.put(neighborNode, currentNode);
                    unvisitedNodes.add(neighborNode);
                }
            }
        }
    }

    private T extractMinDistanceNode(Set<T> nodes) {
        T bestNode = null;

        for (T node : nodes) {
            if (bestNode == null || getDistance(node) < getDistance(bestNode)) bestNode = node;
        }

        return bestNode;
    }

    private double getDistance(T node) {
        Double value = shortestDistance.get(node);
        return (value == null) ? Double.MAX_VALUE : value;
    }
}
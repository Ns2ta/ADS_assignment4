import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<T> extends Search<T> {
    private final Map<Vertex<T>, Double> dist;
    private final Set<Vertex<T>> pending;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        dist = new HashMap<>();
        pending = new HashSet<>();
        this.graph = graph;
        run();
    }

    private void run() {
        dist.put(start, 0.0);
        pending.add(start);

        while (!pending.isEmpty()) {
            Vertex<T> u = pickMinimum(pending);
            visited.add(u);
            pending.remove(u);

            for (Vertex<T> neighbor : graph.adjacencyList(u)) {
                double candidate = shortestDist(u) + edgeWeight(u, neighbor);
                if (candidate < shortestDist(neighbor)) {
                    dist.put(neighbor, candidate);
                    prev.put(neighbor, u);
                    pending.add(neighbor);
                }
            }
        }
    }

    private double edgeWeight(Vertex<T> u, Vertex<T> v) {
        for (Edge<T> e : graph.getEdges(u)) {
            if (e.getDest().equals(v)) return e.getWeight();
        }
        throw new RuntimeException("Not found!");
    }

    private Vertex<T> pickMinimum(Set<Vertex<T>> nodes) {
        Vertex<T> best = null;
        for (Vertex<T> n : nodes) {
            if (best == null || shortestDist(n) < shortestDist(best))
                best = n;
        }
        return best;
    }

    private double shortestDist(Vertex<T> v) {
        Double d = dist.get(v);
        return d == null ? Double.MAX_VALUE : d;
    }
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {
    private final boolean bidirectional;
    private final Map<Vertex<T>, List<Edge<T>>> adjacency = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean bidirectional) {
        this.bidirectional = bidirectional;
    }

    public void addVertex(Vertex<T> v) {
        if (hasVertex(v)) return;
        adjacency.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex<T> u, Vertex<T> v, double weight) {
        if (!hasVertex(u)) addVertex(u);
        if (!hasVertex(v)) addVertex(v);
        if (hasEdge(u, v) || u.equals(v)) return;

        adjacency.get(u).add(new Edge<>(u, v, weight));
        if (bidirectional) adjacency.get(v).add(new Edge<>(v, u, weight));
    }

    public int getVerticesCount() {
        return adjacency.size();
    }

    public int getEdgesCount() {
        int total = 0;
        for (Vertex<T> v : adjacency.keySet())
            total += adjacency.get(v).size();
        return bidirectional ? total / 2 : total;
    }

    public boolean hasVertex(Vertex<T> v) {
        return adjacency.containsKey(v);
    }

    public boolean hasEdge(Vertex<T> u, Vertex<T> v) {
        return hasVertex(u) && adjacency.get(u).contains(new Edge<>(u, v));
    }

    public List<Vertex<T>> adjacencyList(Vertex<T> v) {
        if (!hasVertex(v)) return null;
        List<Vertex<T>> result = new LinkedList<>();
        for (Edge<T> e : adjacency.get(v))
            result.add(e.getDest());
        return result;
    }

    public Iterable<Edge<T>> getEdges(Vertex<T> v) {
        if (!hasVertex(v)) return null;
        return adjacency.get(v);
    }
}

import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> map = new HashMap<>();

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public WeightedGraph() {
        this(true);
    }

    public boolean hasVertex(T V) {
        return map.containsKey(V);
    }

    public boolean hasEdge(T source, T dest) {
        if(!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public void addVertex(T V) {
        if(hasVertex(V)) return;

        map.put(V, new Vertex<>(V));
    }

    public Vertex<T> getVertex(T V) {
        return map.get(V);
    }

    public List<Vertex<T>> adjacencyList(T V) {
        if(!hasVertex(V)) return null;
        return map.get(V).adjacencyListVertices();
    }

    public void addEdge(T source, T dest, double weight) {
        if(!hasVertex(source)) addVertex(source);

        if(!hasVertex(dest)) addVertex(dest);

        if(hasEdge(source, dest) || source.equals(dest)) return;

        map.get(source).addWeightedAdjacentVertex(map.get(dest), weight);

        if (undirected) map.get(dest).addWeightedAdjacentVertex(map.get(source), weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T V : map.keySet()) {
            count = count + map.get(V).NeighbourVerticesSize();
        }

        if(undirected) count = count / 2;

        return count;
    }

    public Iterable<T> vertices() {
        return map.keySet();
    }
}
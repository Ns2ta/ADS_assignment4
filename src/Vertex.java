import java.util.*;
public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data) {
        this.data = data;
        this.adjacentVertices = new LinkedHashMap<>();
    }

    public boolean contains(T item) {
        return adjacentVertices.containsKey(new Vertex<>(item));
    }

    public void addUnweightedAdjacentVertex (Vertex<T> V) {
        adjacentVertices.put(V, 1.0);
    }

    public T getData() {
        return data;
    }

    public int NeighbourVerticesSize() {
        return adjacentVertices.size();
    }

    public void addWeightedAdjacentVertex (Vertex<T> V, double weight) {
        adjacentVertices.put(V, weight);
    }

    public double getWeightedAdjacentVertex (Vertex<T> V) {
        return adjacentVertices.getOrDefault(V, Double.MAX_VALUE);
    }

    public List<T> adjacencyList() {
        List<T> list = new LinkedList<>();

        for (Vertex<T> item : adjacentVertices.keySet()) {
            list.add(item.data);
        }

        return list;
    }

    public List<Vertex<T>> adjacencyListVertices() {
        return new LinkedList<>(adjacentVertices.keySet());
    }

    @Override
    public boolean equals(Object O) {
        if (this == O) return true;
        if(!(O instanceof Vertex<?> vertex)) return false;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

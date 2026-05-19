import java.util.Objects;

public class Edge<T> {
    private Vertex<T> source;
    private Vertex<T> dest;
    private Double weight;

    public Edge(Vertex<T> source, Vertex<T> dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(Vertex<T> source, Vertex<T> dest) {
        this.source = source;
        this.dest = dest;
    }

    public void setSource(Vertex<T> source) {
        this.source = source;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public void setDest(Vertex<T> dest) {
        this.dest = dest;
    }

    public Vertex<T> getDest() {
        return dest;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> otherEdge = (Edge<?>) o;

        return Objects.equals(this.source, otherEdge.source) &&
                Objects.equals(this.dest, otherEdge.dest);
    }
}

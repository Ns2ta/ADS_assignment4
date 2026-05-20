import java.util.Objects;

public class Edge<T> {
    private Vertex<T> from;
    private Vertex<T> to;
    private Double cost;

    public Edge(Vertex<T> from, Vertex<T> to, Double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public Edge(Vertex<T> from, Vertex<T> to) {
        this.from = from;
        this.to = to;
    }

    public Vertex<T> getSource() { return from; }
    public void setSource(Vertex<T> from) { this.from = from; }

    public Vertex<T> getDest() { return to; }
    public void setDest(Vertex<T> to) { this.to = to; }

    public Double getWeight() { return cost; }
    public void setWeight(Double cost) { this.cost = cost; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge<?> e = (Edge<?>) obj;
        return Objects.equals(from, e.from) && Objects.equals(to, e.to);
    }
}

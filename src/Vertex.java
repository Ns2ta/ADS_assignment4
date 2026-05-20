import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<T> {
    T label;
    Map<Vertex<T>, Double> neighbors;

    public Vertex(T label) {
        this.label = label;
        neighbors = new HashMap<>();
    }

    public T getData() {
        return label;
    }

    public void setData(T newLabel) {
        this.label = newLabel;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return neighbors;
    }

    public void addAdjacentVertex(Vertex<T> target, double w) {
        neighbors.put(target, w);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Vertex<?> other = (Vertex<?>) obj;
        return Objects.equals(label, other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label.toString();
    }
}

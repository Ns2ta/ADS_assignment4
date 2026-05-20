import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Search<T> {
    protected Set<Vertex<T>> visited;
    protected Map<Vertex<T>, Vertex<T>> prev;
    protected final Vertex<T> start;

    public Search(Vertex<T> start) {
        this.start = start;
        visited = new HashSet<>();
        prev = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> target) {
        return visited.contains(target);
    }

    public Iterable<Vertex<T>> pathTo(Vertex<T> target) {
        if (!hasPathTo(target)) return null;

        LinkedList<Vertex<T>> path = new LinkedList<>();
        Vertex<T> node = target;
        while (!node.equals(start)) {
            path.push(node);
            node = prev.get(node);
        }
        path.push(start);
        return path;
    }
}

import java.util.*;

public class Search<T> {
    protected Set<T> visitedVertices;
    protected Map<T, T> edgeTo;
    protected final T startVertex;

    public Search(T startVertex) {
        this.startVertex = startVertex;

        edgeTo = new HashMap<>();

        visitedVertices = new HashSet<>();
    }

    public boolean hasPathTo(T V) {
        return visitedVertices.contains(V);
    }

    public Iterable<T> pathTo(T dest) {
        if (!hasPathTo(dest)) {
            return null;
        }

        LinkedList<T> route = new LinkedList<>();

        T current = dest;

        while (!current.equals(startVertex)) {
            route.push(current);
            current = edgeTo.get(current);
        }

        route.push(startVertex);

        return route;
    }
}
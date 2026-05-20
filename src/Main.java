public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, almaty);
        printPath(djk, kyzylorda);

        System.out.println("--------------------------------");

        UnweightedGraph<String> graph = new UnweightedGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, almaty);
        printPath(dfs, kyzylorda);

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, almaty);
        printPath(bfs, kyzylorda);
    }

    private static void fillWithoutWeights(UnweightedGraph<String> g) {
        Vertex<String> almaty    = new Vertex<>("Almaty");
        Vertex<String> astana    = new Vertex<>("Astana");
        Vertex<String> shymkent  = new Vertex<>("Shymkent");
        Vertex<String> atyrau    = new Vertex<>("Atyrau");
        Vertex<String> kostanay  = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        g.addEdge(almaty, astana);
        g.addEdge(shymkent, atyrau);
        g.addEdge(atyrau, astana);
        g.addEdge(almaty, shymkent);
        g.addEdge(shymkent, astana);
        g.addEdge(astana, kostanay);
        g.addEdge(shymkent, kyzylorda);
    }

    private static void fillWithWeights(WeightedGraph<String> g) {
        Vertex<String> almaty    = new Vertex<>("Almaty");
        Vertex<String> astana    = new Vertex<>("Astana");
        Vertex<String> shymkent  = new Vertex<>("Shymkent");
        Vertex<String> atyrau    = new Vertex<>("Atyrau");
        Vertex<String> kostanay  = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        g.addEdge(almaty, astana, 2.1);
        g.addEdge(shymkent, atyrau, 7.8);
        g.addEdge(atyrau, astana, 7.1);
        g.addEdge(almaty, shymkent, 7.2);
        g.addEdge(shymkent, astana, 3.9);
        g.addEdge(astana, kostanay, 3.5);
        g.addEdge(shymkent, kyzylorda, 5.4);
    }

    private static void printPath(Search<String> search, Vertex<String> destination) {
        for (Vertex<String> v : search.pathTo(destination)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}

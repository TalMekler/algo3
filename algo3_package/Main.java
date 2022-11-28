package algo3_package;

import java.util.ArrayList;

public class Main {

    public static void main(String argv[]) {

        Graph graph = new Graph(new ArrayList<Vertex>(), new ArrayList<Edge>());
        Graph graphPrim;

        graph.addEdge(new Edge(new Vertex("A"), new Vertex("B"), 3));
        graph.addEdge(new Edge(new Vertex("A"), new Vertex("C"), 2));
        graph.addEdge(new Edge(new Vertex("D"), new Vertex("A"), 4));
        graph.addEdge(new Edge(new Vertex("C"), new Vertex("D"), 2));
        graph.addEdge(new Edge(new Vertex("C"), new Vertex("E"), 8));
        graph.addEdge(new Edge(new Vertex("D"), new Vertex("E"), 5));
        graph.print();

        System.out.println("\n--- Using prim alg ---");
        graphPrim = graph.prim();
        graphPrim.print();

        System.out.println("\nDone!");
    }
}

package algo3_package;

import java.util.ArrayList;

public class Main {

    public static void main(String argv[]) {

        Graph graph = new Graph(new ArrayList<Vertex>(), new ArrayList<Edge>());
        graph.addEdge(new Edge(new Vertex("A"), new Vertex("B"), 3));
        graph.addEdge(new Edge(new Vertex("A"), new Vertex("C"), 2));
        graph.addEdge(new Edge(new Vertex("D"), new Vertex("A"), 4));
        graph.addEdge(new Edge(new Vertex("C"), new Vertex("D"), 2));
        graph.print();
        System.out.println("--- Using prim alg ---");
        graph.prim().print();

        System.out.println("Done!");
    }
}

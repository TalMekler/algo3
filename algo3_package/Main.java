package algo3_package;

public class Main {
    public static void main(String argv[]) {

        Graph graph = new Graph();
        graph.makeRandomGraph(); // make the graph (random weights)
        Graph graphPrim;
        graph.print();
        System.out.println("\n--- Using prim alg ---");
        graphPrim = graph.prim();
        graphPrim.print();

        graphPrim.addEdge(new Edge(new Vertex("D"), new Vertex("F"), 1));
        System.out.println("Last edge: " + graphPrim.getEdges().get(graphPrim.getEdges().size() - 1));
        graphPrim.print();

        graphPrim.getVertexByKey("F").printPath();


        System.out.println("\nDone!");
    }
}

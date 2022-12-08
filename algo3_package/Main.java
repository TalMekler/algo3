package algo3_package;

public class Main {
    public static void main(String[] argv) {

        Graph graph = new Graph();
        graph.makeRandomGraph(); // make the graph (random weights)
        Graph graphPrim;
        graph.print();
        System.out.println("\n--- Using prim alg ---");
        graphPrim = graph.prim();
        graphPrim.print();

        graphPrim.addEdge(new Edge(new Vertex("H"), new Vertex("G"), 1));
        System.out.println("First shared vertex between H and G is: " + graphPrim.getVertexByKey("H").firstSharedVertexInPath(graphPrim.getVertexByKey("G")));
//        System.out.println("Last edge: " + graphPrim.getEdges().get(graphPrim.getEdges().size() - 1));
//        graphPrim.print();

        graphPrim.getVertexByKey("D").printPath();


        System.out.println("\nDone!");
    }
}

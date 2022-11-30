package algo3_package;

import java.util.ArrayList;

public class Main {

    public static void main(String argv[]) {

        Graph graph = new Graph();
        graph.makeRandomGraph(); // make the graph (random weights)

        Graph graphPrim;

        graph.print();

        System.out.println("\n--- Using prim alg ---");
        graphPrim = graph.prim();
        graphPrim.print();

        System.out.println("\nDone!");
    }
}

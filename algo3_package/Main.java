package algo3_package;

import java.util.ArrayList;

public class Main {
    public static boolean isExist(ArrayList<Edge> edgeArr, Edge e) {
        for(Edge ed : edgeArr)
            if(ed.equals(e))
                return true;
        return false;
    }
    public static void main(String argv[]) {

//        Graph graph = new Graph();
//        graph.makeRandomGraph(); // make the graph (random weights)
//        Graph graphPrim;
//        graph.print();
//        System.out.println("\n--- Using prim alg ---");
//        graphPrim = graph.prim();
//        graphPrim.print();
        ArrayList<Vertex> vertexes = new ArrayList<>();
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        Vertex v5 = new Vertex("E");
        Vertex v6 = new Vertex("F");
        Vertex v7 = new Vertex("G");
        Vertex v8 = new Vertex("H");
        Vertex v9 = new Vertex("I");

        vertexes.add(v1);
        vertexes.add(v2);
        vertexes.add(v3);
        vertexes.add(v4);
        vertexes.add(v5);
        vertexes.add(v6);
        vertexes.add(v7);
        vertexes.add(v8);
        vertexes.add(v9);

        v1.addNeighbor(v2, 5);
        v1.addNeighbor(v3, 1);
        v2.addNeighbor(v5, 6);
        v2.addNeighbor(v9, 7);
        v3.addNeighbor(v4, 4);
        v3.addNeighbor(v5, 2);
        v4.addNeighbor(v5, 3);
        v6.addNeighbor(v8, 10);
        v6.addNeighbor(v9, 9);
        v7.addNeighbor(v9, 8);

        Edge e;
        ArrayList<Edge> edges = new ArrayList<>();
        for(Vertex v : vertexes) {
            for (int i = 0; i < v.getNeighbors().size(); i++) {
                e = v.getEdgeToNeighbor(v.getNeighborByIndex(i).getKey());
                if(!isExist(edges, e))
                    edges.add(e);
            }
        }

        for(Edge ed : edges)
            System.out.print(ed + ", ");


        System.out.println("\nDone!");
    }
}

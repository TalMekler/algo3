package algo3_package;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static java.lang.Double.POSITIVE_INFINITY;

public class Graph {
    public ArrayList<Vertex> vertexes;
    private ArrayList<Edge> edges;

    public Graph() {
        this.vertexes = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
    }

    public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public void makeRandomGraph() {

        for (int i = 0; i< 20; i++){
            System.out.println(i + " -> " + (char)(i + 'A'));
            String k = "" + (char)(i + 'A');
            vertexes.add(new Vertex(k));
        }
//
//        vertexes.get(0).addNeighbor(vertexes.get(1) , 1);
//        vertexes.get(0).addNeighbor(vertexes.get(2) , 2);
//        vertexes.get(0).addNeighbor(vertexes.get(13) , 3);
//        vertexes.get(0).addNeighbor(vertexes.get(18) , 4);
//        vertexes.get(0).addNeighbor(vertexes.get(14) , 5);
//        vertexes.get(0).addNeighbor(vertexes.get(19) , 6);
//
//        vertexes.get(1).addNeighbor(vertexes.get(14) , 7);
//        vertexes.get(1).addNeighbor(vertexes.get(13) , 8);
//        vertexes.get(1).addNeighbor(vertexes.get(15) , 9);
//        vertexes.get(1).addNeighbor(vertexes.get(3) , 10);
//
//        vertexes.get(2).addNeighbor(vertexes.get(13) , 1);
//        vertexes.get(2).addNeighbor(vertexes.get(4) , 2);
//        vertexes.get(2).addNeighbor(vertexes.get(5) , 3);
//
//        vertexes.get(3).addNeighbor(vertexes.get(13) , 4);
//        vertexes.get(3).addNeighbor(vertexes.get(12) , 5);
//        vertexes.get(3).addNeighbor(vertexes.get(6) , 6);
//        vertexes.get(3).addNeighbor(vertexes.get(5) , 7);
//        vertexes.get(3).addNeighbor(vertexes.get(4) , 8);
//
//        vertexes.get(4).addNeighbor(vertexes.get(6) , 9);
//        vertexes.get(4).addNeighbor(vertexes.get(7) , 10);
//        vertexes.get(4).addNeighbor(vertexes.get(8) , 1);
//
//        vertexes.get(5).addNeighbor(vertexes.get(7) , 2);
//        vertexes.get(5).addNeighbor(vertexes.get(8) , 3);
//
//        vertexes.get(6).addNeighbor(vertexes.get(12) , 4);
//        vertexes.get(6).addNeighbor(vertexes.get(11) , 5);
//        vertexes.get(6).addNeighbor(vertexes.get(10) , 6);
//        vertexes.get(6).addNeighbor(vertexes.get(9) , 7);
//        vertexes.get(6).addNeighbor(vertexes.get(8) , 8);
//
//        vertexes.get(8).addNeighbor(vertexes.get(9) , 9);
//
//        vertexes.get(9).addNeighbor(vertexes.get(12) , 10);
//        vertexes.get(9).addNeighbor(vertexes.get(10) , 1);
//
//        vertexes.get(10).addNeighbor(vertexes.get(12) , 2);
//        vertexes.get(10).addNeighbor(vertexes.get(11) , 3);
//        vertexes.get(10).addNeighbor(vertexes.get(16) , 4);
//
//        vertexes.get(11).addNeighbor(vertexes.get(16) , 5);
//        vertexes.get(11).addNeighbor(vertexes.get(17) , 6);
//        vertexes.get(11).addNeighbor(vertexes.get(15) , 7);
//        vertexes.get(11).addNeighbor(vertexes.get(13) , 8);
//        vertexes.get(11).addNeighbor(vertexes.get(12) , 9);
//
//        vertexes.get(12).addNeighbor(vertexes.get(13) , 10);
//
//        vertexes.get(13).addNeighbor(vertexes.get(14) , 1);
//        vertexes.get(13).addNeighbor(vertexes.get(15) , 2 );
//
//        vertexes.get(14).addNeighbor(vertexes.get(15) , 3);
//        vertexes.get(14).addNeighbor(vertexes.get(18) , 4);
//
//        vertexes.get(15).addNeighbor(vertexes.get(19) , 5);
//
//        vertexes.get(16).addNeighbor(vertexes.get(18) , 6);
//        vertexes.get(16).addNeighbor(vertexes.get(16) , 7);
//
//        vertexes.get(17).addNeighbor(vertexes.get(18) , 8);
//        vertexes.get(17).addNeighbor(vertexes.get(19) , 9);
//
//        vertexes.get(18).addNeighbor(vertexes.get(19) , 10);
//
//        for(int i = 0; i< vertexes.size(); i++) {
//            for(Edge e : vertexes.get(i).edges)
//                addEdge(e);
//        }


        // Lior's graph
        vertexes.get(0).addNeighbor(vertexes.get(2) , 1);
        vertexes.get(0).addNeighbor(vertexes.get(1) , 5);
        vertexes.get(1).addNeighbor(vertexes.get(4) , 6);
        vertexes.get(1).addNeighbor(vertexes.get(8) , 7);
        vertexes.get(2).addNeighbor(vertexes.get(3) , 4);
        vertexes.get(2).addNeighbor(vertexes.get(4) , 2);
        vertexes.get(3).addNeighbor(vertexes.get(4) , 3);
        vertexes.get(5).addNeighbor(vertexes.get(7) , 10);
        vertexes.get(5).addNeighbor(vertexes.get(8) , 9);
        vertexes.get(6).addNeighbor(vertexes.get(8) , 8);

        for(int i = 0; i< vertexes.size(); i++) {
            for(Edge e : vertexes.get(i).edges)
                addEdge(e);
        }
    }

    public void addVertex(Vertex vertex) {
        if(vertexExist(vertex, vertexes))
            return;
        this.vertexes.add(vertex);
    }
    public Vertex getVertexByKey(String key) {
        for(Vertex v : this.vertexes)
            if(v.getKey().equals(key))
                return v;
        return null;
    }
    public void addEdge(Edge edge) {
        if(edgeExist(edge))
            return;
        addVertex(edge.getSource());
        addVertex(edge.getDestination());

        getVertexByKey(edge.getSource().getKey()).addNeighbor(getVertexByKey(edge.getDestination().getKey()), edge.getWeight());

        edge.getSource().addNeighbor(edge.getDestination() , edge.getWeight());

        edges.add(edge);
    }

    private boolean edgeExist(Edge e) {
        for (Edge edge : this.edges) {
            if (edge.equals(e))
                return true;
        }
        return false;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    private boolean vertexExist(Vertex vertex, ArrayList<Vertex> vertexes) {
        for (Vertex v : vertexes) {
            if (v.getKey().equals(vertex.getKey()))
                return true;
        }
        return false;
    }


    public Graph prim() {
        Graph graphTag = new Graph();
        ArrayList<Edge> edgesCopy = new ArrayList<>();
        Edge minEdge;

        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();

        for (Edge e : this.edges) {
            edgesCopy.add(new Edge(e));
            edgesCopy.get(edgesCopy.size() - 1).setWeight((int)POSITIVE_INFINITY);
        }

        graphTag.addVertex(this.vertexes.get(0));
//        edgesCopy.addAll(graphTag.vertexes.get(0).edges);
        heap.addAll(updateWeightForVertexEdge(graphTag.vertexes.get(0), edgesCopy));


        //TODO: left this and remove the first 'heap'
//        for(Edge e : edgesCopy)
//            heap.add(e);

        while (heap.size() > 0) {
            minEdge = heap.remove();

            if (!(vertexExist(minEdge.getSource(), graphTag.vertexes) && vertexExist(minEdge.getDestination(), graphTag.vertexes))) { // one of the vertexes not exist
                if (!(vertexExist(minEdge.getSource(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getSource());
                    minEdge.getSource().setPi(minEdge.getDestination());
                    heap.addAll(updateWeightForVertexEdge(minEdge.getSource(), edgesCopy));
                    edgesCopy.remove(minEdge);
                }
                if (!(vertexExist(minEdge.getDestination(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getDestination());
                    minEdge.getDestination().setPi(minEdge.getSource());
                    heap.addAll(updateWeightForVertexEdge(minEdge.getDestination(), edgesCopy));
                    edgesCopy.remove(minEdge);
                }
                graphTag.addEdge(minEdge);
                heap.addAll(updateWeightForVertexEdge(minEdge.getDestination(), edgesCopy));

            }

        }

        return graphTag;
    }

    private ArrayList<Edge> updateWeightForVertexEdge(Vertex v, ArrayList<Edge> edges) {
        ArrayList<Edge> retArr = new ArrayList<>();
        for (Edge e : edges) {
            if (e.getSource().getKey().equals(v.getKey()) || e.getDestination().getKey().equals(v.getKey())) {
                e.setWeight(getEdgeWeightByKey(e.getKey()));
                retArr.add(e);
            }
        }
        return retArr;
    }

    private int getEdgeWeightByKey(int key) {
        for (Edge e : this.edges)
            if (e.getKey() == key)
                return e.getWeight();

        return 0;
    }

    public void print() {
        System.out.println("Vertexes (" + this.vertexes.size() + "): ");
        int cnt = 1;
        for (Vertex v : this.vertexes) {
            System.out.print(v.getKey());
            if (cnt % 10 == 0)
                System.out.println();
            else if (v.getKey() != this.vertexes.get(this.vertexes.size() - 1).getKey())
                System.out.print(", ");
            cnt++;
        }

        if (this.vertexes.size() > 0)
            System.out.println();

        cnt = 1;
        System.out.println("Edges (" + this.edges.size() + "): ");
        for (Edge e : edges) {
            System.out.print(e.getSource().getKey() + "-" + e.getWeight() + "-" + e.getDestination().getKey());
            if (cnt % 10 == 0)
                System.out.println();
            else if (e.getKey() != this.edges.get(this.edges.size() - 1).getKey())
                System.out.print(", ");

            cnt++;
        }

        System.out.println();
    }
}

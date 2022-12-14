package algo3_package;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Double.NEGATIVE_INFINITY;
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
            vertexes.add(new Vertex("" + (char)(i + 'A')));
        }

        vertexes.get(0).addNeighbor(vertexes.get(1) , 1);
        vertexes.get(0).addNeighbor(vertexes.get(2) , 2);
        vertexes.get(0).addNeighbor(vertexes.get(13) , 3);
        vertexes.get(0).addNeighbor(vertexes.get(18) , 4);
        vertexes.get(0).addNeighbor(vertexes.get(14) , 5);
        vertexes.get(0).addNeighbor(vertexes.get(19) , 6);

        vertexes.get(1).addNeighbor(vertexes.get(14) , 7);
        vertexes.get(1).addNeighbor(vertexes.get(13) , 8);
        vertexes.get(1).addNeighbor(vertexes.get(15) , 9);
        vertexes.get(1).addNeighbor(vertexes.get(3) , 10);

        vertexes.get(2).addNeighbor(vertexes.get(13) , 1);
        vertexes.get(2).addNeighbor(vertexes.get(4) , 2);
        vertexes.get(2).addNeighbor(vertexes.get(5) , 3);

        vertexes.get(3).addNeighbor(vertexes.get(13) , 4);
        vertexes.get(3).addNeighbor(vertexes.get(12) , 5);
        vertexes.get(3).addNeighbor(vertexes.get(6) , 6);
        vertexes.get(3).addNeighbor(vertexes.get(5) , 7);
        vertexes.get(3).addNeighbor(vertexes.get(4) , 8);

        vertexes.get(4).addNeighbor(vertexes.get(6) , 9);
        vertexes.get(4).addNeighbor(vertexes.get(7) , 10);
        vertexes.get(4).addNeighbor(vertexes.get(8) , 1);

        vertexes.get(5).addNeighbor(vertexes.get(7) , 2);
        vertexes.get(5).addNeighbor(vertexes.get(8) , 3);

        vertexes.get(6).addNeighbor(vertexes.get(12) , 4);
        vertexes.get(6).addNeighbor(vertexes.get(11) , 5);
        vertexes.get(6).addNeighbor(vertexes.get(10) , 6);
        vertexes.get(6).addNeighbor(vertexes.get(9) , 7);
        vertexes.get(6).addNeighbor(vertexes.get(8) , 8);

        vertexes.get(8).addNeighbor(vertexes.get(9) , 9);

        vertexes.get(9).addNeighbor(vertexes.get(12) , 10);
        vertexes.get(9).addNeighbor(vertexes.get(10) , 1);

        vertexes.get(10).addNeighbor(vertexes.get(12) , 2);
        vertexes.get(10).addNeighbor(vertexes.get(11) , 3);
        vertexes.get(10).addNeighbor(vertexes.get(16) , 4);

        vertexes.get(11).addNeighbor(vertexes.get(16) , 5);
        vertexes.get(11).addNeighbor(vertexes.get(17) , 6);
        vertexes.get(11).addNeighbor(vertexes.get(15) , 7);
        vertexes.get(11).addNeighbor(vertexes.get(13) , 8);
        vertexes.get(11).addNeighbor(vertexes.get(12) , 9);

        vertexes.get(12).addNeighbor(vertexes.get(13) , 10);

        vertexes.get(13).addNeighbor(vertexes.get(14) , 1);
        vertexes.get(13).addNeighbor(vertexes.get(15) , 2 );

        vertexes.get(14).addNeighbor(vertexes.get(15) , 3);
        vertexes.get(14).addNeighbor(vertexes.get(18) , 4);

        vertexes.get(15).addNeighbor(vertexes.get(19) , 5);

        vertexes.get(16).addNeighbor(vertexes.get(18) , 6);
        vertexes.get(16).addNeighbor(vertexes.get(16) , 7);

        vertexes.get(17).addNeighbor(vertexes.get(18) , 8);
        vertexes.get(17).addNeighbor(vertexes.get(19) , 9);

        vertexes.get(18).addNeighbor(vertexes.get(19) , 10);

        for(int i = 0; i< vertexes.size(); i++) {
            for(Edge e : vertexes.get(i).edges)
                addEdge(e);
        }


        // Lior's graph
//        vertexes.get(0).addNeighbor(vertexes.get(2) , 1);
//        vertexes.get(0).addNeighbor(vertexes.get(1) , 5);
//        vertexes.get(1).addNeighbor(vertexes.get(4) , 6);
//        vertexes.get(1).addNeighbor(vertexes.get(8) , 7);
//        vertexes.get(2).addNeighbor(vertexes.get(3) , 4);
//        vertexes.get(2).addNeighbor(vertexes.get(4) , 2);
//        vertexes.get(3).addNeighbor(vertexes.get(4) , 3);
//        vertexes.get(5).addNeighbor(vertexes.get(7) , 10);
//        vertexes.get(5).addNeighbor(vertexes.get(8) , 9);
//        vertexes.get(6).addNeighbor(vertexes.get(8) , 8);
//
//        for(int i = 0; i< vertexes.size(); i++) {
//            for(Edge e : vertexes.get(i).edges)
//                addEdge(e);
//        }
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
        edges.add(edge);
    }

    public void removeEdge(Edge e) {
        Edge edgeToRemove = null;
        for (Edge edge : edges) {
            if (e.equals(edge)) {
                edgeToRemove = edge;
                break;
            }
        }
        edges.remove(edgeToRemove);
        fixPI();
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
        Edge minEdge;

        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();

        graphTag.addVertex(this.vertexes.get(0));
        heap.addAll(graphTag.vertexes.get(0).edges);


        while (heap.size() > 0) {
            minEdge = heap.remove();

            if (!(vertexExist(minEdge.getSource(), graphTag.vertexes) && vertexExist(minEdge.getDestination(), graphTag.vertexes))) { // one of the vertexes not exist
                if (!(vertexExist(minEdge.getSource(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getSource());
                    minEdge.getSource().setPi(minEdge.getDestination());
                    heap.addAll(minEdge.getSource().edges);
                }
                if (!(vertexExist(minEdge.getDestination(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getDestination());
                    minEdge.getDestination().setPi(minEdge.getSource());
                    heap.addAll(minEdge.getDestination().edges);
                }
                graphTag.addEdge(minEdge);
            }
        }

        for(Vertex v : graphTag.vertexes)
            v.removeNeighbors();
        for (Edge e : graphTag.edges)
            e.getSource().addNeighbor(e.getDestination(), e.getWeight());

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

    public Edge maxEdgeInPath(Vertex from, Vertex to) {
        int maxWeight = (int)NEGATIVE_INFINITY;
        Edge maxEdge = null;
        Vertex currentVertex = from;
        if(to != null) {
            while (!currentVertex.equals(to) && currentVertex.getPi() != null) {
                if (currentVertex.getEdgeToNeighbor(currentVertex.getPi().getKey()).getWeight() > maxWeight) {
                    maxEdge = currentVertex.getEdgeToNeighbor(currentVertex.getPi().getKey());
                    maxWeight = maxEdge.getWeight();
                }
                currentVertex = currentVertex.getPi();
            }
        }
        else{
            while (currentVertex.getPi() != null) {
                if (currentVertex.getEdgeToNeighbor(currentVertex.getPi().getKey()).getWeight() > maxWeight) {
                    maxEdge = currentVertex.getEdgeToNeighbor(currentVertex.getPi().getKey());
                    maxWeight = maxEdge.getWeight();
                }
                currentVertex = currentVertex.getPi();
            }
        }

        return maxEdge;
    }

    private void fixPI() {
        LinkedList<Vertex> vQueue = new LinkedList<Vertex>();
        vQueue.add(vertexes.get(0));
        Vertex currentVertex;

        HashMap<String, Vertex> updated = new HashMap<>();
        updated.put(vertexes.get(0).getKey(), vertexes.get(0));

        while (!vQueue.isEmpty()) {
            currentVertex = vQueue.remove();
            for(Vertex n : currentVertex.getNeighbors()){
                if(!updated.containsKey(n.getKey())) {
                    n.setPi(currentVertex);
                    vQueue.add(n);
                    updated.put(n.getKey(), n);
                }
            }
        }
    }

    public void print() {
        System.out.println("Vertexes (" + this.vertexes.size() + "): ");
        int cnt = 1;
        for (Vertex v : this.vertexes) {
            System.out.print(v);
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
            System.out.print(e.getSource() + "-" + e.getWeight() + "-" + e.getDestination());
            if (cnt % 10 == 0)
                System.out.println();
            else if (e.getKey() != this.edges.get(this.edges.size() - 1).getKey())
                System.out.print(", ");

            cnt++;
        }

        System.out.println();
    }
}

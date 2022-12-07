package algo3_package;

import java.util.*;

public class Vertex {
    private final String key;
    private final ArrayList<Vertex> neighbors;
    ArrayList<Edge> edges;
    private Vertex pi;
//    private int color; // 0 - white, 1 - gray, 2 - black

    public boolean equals(Vertex other) {
        return key == other.key;
    }
    public Vertex (String key) {
        this.key = key;
        this.neighbors = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
        this.pi = null;
//        this.color = 0;
    }

    public String getKey() {
        return key;
    }

    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }


    public Edge getEdgeToNeighbor(String neighborKey){
        for (Edge e : edges)
            if(e.getDestination().getKey().equals(neighborKey))
                return e;
        return null;
    }

    private boolean neighborExist(Vertex newNeighbor) {
        for(Vertex v : neighbors)
            if(v.equals(newNeighbor))
                return true;
        return false;
    }
    public void addNeighbor(Vertex neighbor, int edgeWeight) {
        if(neighborExist(neighbor))
            return;

        this.neighbors.add(neighbor);
        this.edges.add(new Edge(this, neighbor, edgeWeight));

        neighbor.neighbors.add(this);
        neighbor.edges.add(new Edge(neighbor, this, edgeWeight));
    }
    public Vertex getPi() {
        return pi;
    }

    public void setPi(Vertex pi) {
        this.pi = pi;
    }

    public void printPath() {
        Vertex currentVertex = this;
        System.out.print("Path from " + currentVertex.getKey() +" to the start: ");
        while(currentVertex.getPi() != null) {
            System.out.print(currentVertex.getEdgeToNeighbor(currentVertex.getPi().getKey()) + ", ");
            currentVertex = currentVertex.getPi();
        }
    }

    public boolean isVertexInThePath(Vertex v) {
        Vertex currentVertex = this;
        while (currentVertex.getPi() != null){
            if(currentVertex.getPi().equals(v))
                return true;
            currentVertex = currentVertex.getPi();
        }
        return false;
    }
}

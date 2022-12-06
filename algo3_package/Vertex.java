package algo3_package;

import java.util.*;

public class Vertex {
    private final String key;
    private final ArrayList<Vertex> neighbors;
    private final ArrayList<Integer> edgesWeight;
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
        this.edgesWeight = new ArrayList<Integer>();
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
        int index = 0;
        for(Vertex neighbor : this.neighbors){
            if(neighbor.key == neighborKey)
                return new Edge(this, neighbor, this.edgesWeight.get(index));
            index++;
        }
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
        this.edgesWeight.add(edgeWeight);
        this.edges.add(new Edge(this, neighbor, edgeWeight));

        neighbor.neighbors.add(this);
        neighbor.edgesWeight.add(edgeWeight);
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
        while(currentVertex.getPi() != null) {
            System.out.println(currentVertex.getEdgeToNeighbor(currentVertex.getPi().getKey()));
            currentVertex = currentVertex.getPi();
        }
    }
}

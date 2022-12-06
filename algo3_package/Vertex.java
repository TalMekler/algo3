package algo3_package;

import java.util.*;

public class Vertex {
    private final String key;
    private final ArrayList<Vertex> neighbors;
    private final ArrayList<Integer> edgesWeight;
    ArrayList<Edge> edges;
    private Vertex pi;
    private int color; // 0 - white, 1 - gray, 2 - black

    public boolean equals(Vertex other) {
        return key == other.key;
    }
    public Vertex (String key) {
        this.key = key;
        this.neighbors = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
        this.edgesWeight = new ArrayList<Integer>();
        this.pi = null;
        this.color = 0;
    }

    public String getKey() {
        return key;
    }

    public ArrayList<Vertex> getNeighbors() {
        return neighbors;
    }

    public Vertex getNeighborByIndex(int index) {
        if (index < 0 || index >= neighbors.size())
            return null;
        return neighbors.get(index);
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

    public int getMinWeightIndex() {
        int minIndex = 0, minWeigth = edgesWeight.get(0);
        for (int i = 1; i < edgesWeight.size(); i++){
            if (edgesWeight.get(i) < minWeigth) {
                minWeigth = edgesWeight.get(i);
                minIndex = i;
            }
        }
        return minIndex;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(key, vertex.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}

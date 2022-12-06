package algo3_package;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    private int key;
    private Vertex source;
    private Vertex destination;
    private int weight;

    static int keyCounter = 0;

    public boolean equals(Edge other) {
        return ((source.equals(other.source) && destination.equals(other.destination)) ||
                (source.equals(other.destination) && destination.equals(other.source))) ;
    }

    public Edge(Vertex source, Vertex destination, int weight) {
        this.key = keyCounter++;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public Edge(Edge e) {
        this.source = e.source;
        this.destination = e.destination;
        this.weight = e.weight;
        this.key = e.key;
    }

    @Override
    public String toString() {
        return source.getKey() + "-" + weight + "-" + destination.getKey();
    }

    @Override public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int w) {
        this.weight = w;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getKey(){
        return this.key;
    }
}

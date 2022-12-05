package algo3_package;

public class Edge {
    private int key;
    private Vertex source;
    private Vertex destination;
    private int weight;

    static int keyCounter = 0;

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

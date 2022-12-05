package algo3_package;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static java.lang.Double.POSITIVE_INFINITY;

public class Graph {
    private ArrayList<Vertex> vertexes;
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
//        for (int i = 0; i < 50; i++) {
//            addRandomEdge();
//        }

        this.addEdge(new Edge(new Vertex("A"), new Vertex("B"), 1));
        this.addEdge(new Edge(new Vertex("A"), new Vertex("C"), 2));
        this.addEdge(new Edge(new Vertex("A"), new Vertex("N"), 3));
        this.addEdge(new Edge(new Vertex("A"), new Vertex("S"), 4));
        this.addEdge(new Edge(new Vertex("A"), new Vertex("O"), 5));
        this.addEdge(new Edge(new Vertex("A"), new Vertex("T"), 6));

        this.addEdge(new Edge(new Vertex("B"), new Vertex("O"), 7));
        this.addEdge(new Edge(new Vertex("B"), new Vertex("N"), 8));
        this.addEdge(new Edge(new Vertex("B"), new Vertex("P"), 9));
        this.addEdge(new Edge(new Vertex("B"), new Vertex("D"), 10));

        this.addEdge(new Edge(new Vertex("C"), new Vertex("N"), 1));
        this.addEdge(new Edge(new Vertex("C"), new Vertex("E"), 2));
        this.addEdge(new Edge(new Vertex("C"), new Vertex("F"), 3));

        this.addEdge(new Edge(new Vertex("D"), new Vertex("N"), 4));
        this.addEdge(new Edge(new Vertex("D"), new Vertex("M"), 5));
        this.addEdge(new Edge(new Vertex("D"), new Vertex("G"), 6));
        this.addEdge(new Edge(new Vertex("D"), new Vertex("F"), 7));
        this.addEdge(new Edge(new Vertex("D"), new Vertex("E"), 8));

        this.addEdge(new Edge(new Vertex("E"), new Vertex("G"), 9));
        this.addEdge(new Edge(new Vertex("E"), new Vertex("H"), 10));
        this.addEdge(new Edge(new Vertex("E"), new Vertex("I"), 1));

        this.addEdge(new Edge(new Vertex("F"), new Vertex("H"), 2));
        this.addEdge(new Edge(new Vertex("F"), new Vertex("I"), 3));

        this.addEdge(new Edge(new Vertex("G"), new Vertex("M"), 4));
        this.addEdge(new Edge(new Vertex("G"), new Vertex("L"), 5));
        this.addEdge(new Edge(new Vertex("G"), new Vertex("K"), 6));
        this.addEdge(new Edge(new Vertex("G"), new Vertex("J"), 7));
        this.addEdge(new Edge(new Vertex("G"), new Vertex("I"), 8));

        this.addEdge(new Edge(new Vertex("I"), new Vertex("J"), 9));

        this.addEdge(new Edge(new Vertex("J"), new Vertex("M"), 10));
        this.addEdge(new Edge(new Vertex("J"), new Vertex("K"), 1));

        this.addEdge(new Edge(new Vertex("K"), new Vertex("M"), 2));
        this.addEdge(new Edge(new Vertex("K"), new Vertex("L"), 3));
        this.addEdge(new Edge(new Vertex("K"), new Vertex("Q"), 4));

        this.addEdge(new Edge(new Vertex("L"), new Vertex("Q"), 5));
        this.addEdge(new Edge(new Vertex("L"), new Vertex("R"), 6));
        this.addEdge(new Edge(new Vertex("L"), new Vertex("P"), 7));
        this.addEdge(new Edge(new Vertex("L"), new Vertex("N"), 8));
        this.addEdge(new Edge(new Vertex("L"), new Vertex("M"), 9));

        this.addEdge(new Edge(new Vertex("M"), new Vertex("N"), 10));

        this.addEdge(new Edge(new Vertex("N"), new Vertex("O"), 1));
        this.addEdge(new Edge(new Vertex("N"), new Vertex("P"), 2));

        this.addEdge(new Edge(new Vertex("O"), new Vertex("P"), 3));
        this.addEdge(new Edge(new Vertex("O"), new Vertex("S"), 4));

        this.addEdge(new Edge(new Vertex("P"), new Vertex("T"), 5));

        this.addEdge(new Edge(new Vertex("Q"), new Vertex("S"), 6));
        this.addEdge(new Edge(new Vertex("Q"), new Vertex("Q"), 7));

        this.addEdge(new Edge(new Vertex("R"), new Vertex("S"), 8));
        this.addEdge(new Edge(new Vertex("R"), new Vertex("T"), 9));

        this.addEdge(new Edge(new Vertex("S"), new Vertex("T"), 10));

//        for (Edge e : this.getEdges())
//            e.setWeight((int) (Math.random() * 50)); // init random weight to the graph edges

//        // Lior's graph
//        this.addEdge(new Edge(new Vertex("1"), new Vertex("3"), 1));
//        this.addEdge(new Edge(new Vertex("1"), new Vertex("2"), 5));
//        this.addEdge(new Edge(new Vertex("2"), new Vertex("5"), 6));
//        this.addEdge(new Edge(new Vertex("2"), new Vertex("9"), 7));
//        this.addEdge(new Edge(new Vertex("3"), new Vertex("4"), 4));
//        this.addEdge(new Edge(new Vertex("3"), new Vertex("5"), 2));
//        this.addEdge(new Edge(new Vertex("4"), new Vertex("5"), 3));
//        this.addEdge(new Edge(new Vertex("6"), new Vertex("8"), 10));
//        this.addEdge(new Edge(new Vertex("6"), new Vertex("9"), 9));
//        this.addEdge(new Edge(new Vertex("7"), new Vertex("9"), 8));
    }

    public void addVertex(Vertex vertex) {
        this.vertexes.add(vertex);
    }

    public void addEdge(Edge edge) {
        if (!vertexExist(edge.getSource(), this.vertexes))
            vertexes.add(edge.getSource());

        if (!vertexExist(edge.getDestination(), this.vertexes))
            vertexes.add(edge.getDestination());

        this.edges.add(edge);
    }

    public void addRandomEdge() {
        String key1 = new String();
        String key2 = new String();
        char key1Char, key2Char;
        Edge e;

        while (true) {
            key1 = "";
            key2 = "";
            do {
                key1Char = (char) ((int) (Math.random() * 26) + 'A');
                key2Char = (char) ((int) (Math.random() * 26) + 'A');
            } while (key1Char == key2Char);
            key1 += key1Char;
            key2 += key2Char;

            e = new Edge(new Vertex(key1), new Vertex(key2), (int) (Math.random() * 50));
            if (!edgeExist(e)) {
                addEdge(e);
                System.out.println("Edge added: " + e.getSource().getKey() + "-" + e.getWeight() + "-" + e.getDestination().getKey());
                return;
            }
        }

    }

    private boolean edgeExist(Edge e) {
        for (Edge edge : this.edges) {
            if ((edge.getSource().getKey() == e.getSource().getKey() && edge.getDestination().getKey() == e.getDestination().getKey()) ||
                    (edge.getSource().getKey() == e.getDestination().getKey() && edge.getDestination().getKey() == e.getSource().getKey()))
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
        Graph graphTag = new Graph(new ArrayList<Vertex>(), new ArrayList<Edge>());
        ArrayList<Edge> edgesCopy = new ArrayList<>();
        Edge minEdge;

        //TODO: left this and remove the first 'heap'
        PriorityQueue<Edge> heap = new PriorityQueue<Edge>();

        for (Edge e : this.edges) {
            edgesCopy.add(new Edge(e));
            edgesCopy.get(edgesCopy.size() - 1).setWeight((int)POSITIVE_INFINITY);
        }
        graphTag.addVertex(this.vertexes.get(0));
        heap.addAll(updateWeightForVertexEdge(graphTag.vertexes.get(0), edgesCopy));

        //TODO: left this and remove the first 'heap'
//        for(Edge e : edgesCopy)
//            heap.add(e);

        while (heap.size() > 0) {
            minEdge = heap.remove();

            if (!(vertexExist(minEdge.getSource(), graphTag.vertexes) && vertexExist(minEdge.getDestination(), graphTag.vertexes))) { // one of the vertexes not exist
                if (!(vertexExist(minEdge.getSource(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getSource());
                    heap.addAll(updateWeightForVertexEdge(minEdge.getSource(), edgesCopy));
                }
                if (!(vertexExist(minEdge.getDestination(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getDestination());
                    heap.addAll(updateWeightForVertexEdge(minEdge.getDestination(), edgesCopy));
                }
                graphTag.addEdge(minEdge);

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

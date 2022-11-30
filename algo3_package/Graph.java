package algo3_package;

import java.util.ArrayList;

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
        for (int i = 0; i < 50; i++) {
            addRandomEdge();
        }

//        this.addEdge(new Edge(new Vertex("A"), new Vertex("B"), 0));
//        this.addEdge(new Edge(new Vertex("A"), new Vertex("C"), 0));
//        this.addEdge(new Edge(new Vertex("A"), new Vertex("N"), 0));
//        this.addEdge(new Edge(new Vertex("A"), new Vertex("S"), 0));
//        this.addEdge(new Edge(new Vertex("A"), new Vertex("O"), 0));
//        this.addEdge(new Edge(new Vertex("A"), new Vertex("T"), 0));
//
//        this.addEdge(new Edge(new Vertex("B"), new Vertex("O"), 0));
//        this.addEdge(new Edge(new Vertex("B"), new Vertex("N"), 0));
//        this.addEdge(new Edge(new Vertex("B"), new Vertex("P"), 0));
//        this.addEdge(new Edge(new Vertex("B"), new Vertex("D"), 8));
//
//        this.addEdge(new Edge(new Vertex("C"), new Vertex("N"), 0));
//        this.addEdge(new Edge(new Vertex("C"), new Vertex("E"), 0));
//        this.addEdge(new Edge(new Vertex("C"), new Vertex("F"), 0));
//
//        this.addEdge(new Edge(new Vertex("D"), new Vertex("N"), 0));
//        this.addEdge(new Edge(new Vertex("D"), new Vertex("M"), 0));
//        this.addEdge(new Edge(new Vertex("D"), new Vertex("G"), 0));
//        this.addEdge(new Edge(new Vertex("D"), new Vertex("F"), 0));
//        this.addEdge(new Edge(new Vertex("D"), new Vertex("E"), 0));
//
//        this.addEdge(new Edge(new Vertex("E"), new Vertex("G"), 0));
//        this.addEdge(new Edge(new Vertex("E"), new Vertex("H"), 0));
//        this.addEdge(new Edge(new Vertex("E"), new Vertex("I"), 0));
//
//        this.addEdge(new Edge(new Vertex("F"), new Vertex("H"), 0));
//        this.addEdge(new Edge(new Vertex("F"), new Vertex("I"), 0));
//
//        this.addEdge(new Edge(new Vertex("G"), new Vertex("M"), 0));
//        this.addEdge(new Edge(new Vertex("G"), new Vertex("L"), 0));
//        this.addEdge(new Edge(new Vertex("G"), new Vertex("K"), 0));
//        this.addEdge(new Edge(new Vertex("G"), new Vertex("J"), 0));
//        this.addEdge(new Edge(new Vertex("G"), new Vertex("I"), 0));
//
//        this.addEdge(new Edge(new Vertex("I"), new Vertex("J"), 0));
//
//        this.addEdge(new Edge(new Vertex("J"), new Vertex("M"), 0));
//        this.addEdge(new Edge(new Vertex("J"), new Vertex("K"), 0));
//
//        this.addEdge(new Edge(new Vertex("K"), new Vertex("M"), 0));
//        this.addEdge(new Edge(new Vertex("K"), new Vertex("L"), 0));
//        this.addEdge(new Edge(new Vertex("K"), new Vertex("Q"), 0));
//
//        this.addEdge(new Edge(new Vertex("L"), new Vertex("Q"), 0));
//        this.addEdge(new Edge(new Vertex("L"), new Vertex("R"), 0));
//        this.addEdge(new Edge(new Vertex("L"), new Vertex("P"), 0));
//        this.addEdge(new Edge(new Vertex("L"), new Vertex("N"), 0));
//        this.addEdge(new Edge(new Vertex("L"), new Vertex("M"), 0));
//
//        this.addEdge(new Edge(new Vertex("M"), new Vertex("N"), 0));
//
//        this.addEdge(new Edge(new Vertex("N"), new Vertex("O"), 0));
//        this.addEdge(new Edge(new Vertex("N"), new Vertex("P"), 0));
//
//        this.addEdge(new Edge(new Vertex("O"), new Vertex("P"), 0));
//        this.addEdge(new Edge(new Vertex("O"), new Vertex("S"), 0));
//
//        this.addEdge(new Edge(new Vertex("P"), new Vertex("T"), 0));
//
//        this.addEdge(new Edge(new Vertex("Q"), new Vertex("S"), 0));
//        this.addEdge(new Edge(new Vertex("Q"), new Vertex("Q"), 0));
//
//        this.addEdge(new Edge(new Vertex("R"), new Vertex("S"), 0));
//        this.addEdge(new Edge(new Vertex("R"), new Vertex("T"), 0));
//
//        this.addEdge(new Edge(new Vertex("S"), new Vertex("T"), 0));

//        for (Edge e : this.getEdges())
//            e.setWeight((int) (Math.random() * 50)); // init random weight to the graph edges
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

        SortedArrayList heap = new SortedArrayList();
        Edge minEdge;

        for (Edge e : this.edges) {
            edgesCopy.add(new Edge(e));
            edgesCopy.get(edgesCopy.size() - 1).setWeight(POSITIVE_INFINITY);
        }
        graphTag.addVertex(this.vertexes.get(0));
        updateWeightForVertexEdge(graphTag.vertexes.get(0), edgesCopy);
        for (Edge e : edgesCopy)
            heap.add(e); // add all edges to the heap

        while (heap.sortedEdges.size() > 0) {
            minEdge = heap.remove();
            if (!(vertexExist(minEdge.getSource(), graphTag.vertexes) && vertexExist(minEdge.getDestination(), graphTag.vertexes))) { // one of the vertexes not exist
                if (!(vertexExist(minEdge.getSource(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getSource());
                    updateWeightForVertexEdge(minEdge.getSource(), edgesCopy);
                    heap.updateWeight(edgesCopy);
                }
                if (!(vertexExist(minEdge.getDestination(), graphTag.vertexes))) {
                    graphTag.addVertex(minEdge.getDestination());
                    updateWeightForVertexEdge(minEdge.getDestination(), edgesCopy);
                    heap.updateWeight(edgesCopy);
                }
                graphTag.addEdge(minEdge);
            }

        }

        return graphTag;
    }

    private void updateWeightForVertexEdge(Vertex v, ArrayList<Edge> edges) {

        for (Edge e : edges) {
            if (e.getSource().getKey().equals(v.getKey()) || e.getDestination().getKey().equals(v.getKey()))
                e.setWeight(getEdgeWeightByKey(e.getKey()));
        }

    }

    private double getEdgeWeightByKey(int key) {
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

package algo3_package;

import java.util.ArrayList;

import static java.lang.Double.POSITIVE_INFINITY;

public class Graph {
    private ArrayList<Vertex> vertexes;
    private ArrayList<Edge> edges;

    public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
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
            edgesCopy.get(edgesCopy.size()-1).setWeight(POSITIVE_INFINITY);
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
        System.out.println("Vertexes: ");
        for (Vertex v : this.vertexes) {
            System.out.print(v.getKey());
            if(v.getKey() != this.vertexes.get(this.vertexes.size()-1).getKey())
                System.out.print(", ");
        }

        if(this.vertexes.size() > 0)
            System.out.println();

        System.out.println("Edges: ");
        for (Edge e : edges) {
            System.out.print(e.getSource().getKey() + "-" + e.getWeight() + "-" + e.getDestination().getKey());
            if(e.getKey() != this.edges.get(this.edges.size()-1).getKey())
                System.out.print(", ");
        }

        System.out.println();
    }
}

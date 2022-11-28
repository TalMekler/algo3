import java.util.ArrayList;

import static java.lang.Double.POSITIVE_INFINITY;

public class Graph {
    private ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();

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

        System.arraycopy(this.edges, 0, edgesCopy, 0, edges.size());
        for (Edge e : edgesCopy)
            e.setWeight((int) POSITIVE_INFINITY);
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

    private int getEdgeWeightByKey(int key) {
        for (Edge e : this.edges)
            if (e.getKey() == key)
                return e.getWeight();

        return 0;
    }

    public void print() {
        for (Edge e : edges) {
            System.out.println(e.getSource().getKey() + "-" + e.getWeight() + "-" + e.getDestination().getKey());
        }
    }
}

package algo3_package;

import java.util.ArrayList;

public class SortedArrayList {

    public ArrayList<Edge> sortedEdges = new ArrayList<>();

    public SortedArrayList() {}

    private void sortArray() {
        for (int i = 0; i < sortedEdges.size(); i++) {
            for (int j = 0; j < sortedEdges.size(); j++) {
                if (sortedEdges.get(j).getWeight() <= sortedEdges.get(i).getWeight()) {
                    swap(sortedEdges.get(i), sortedEdges.get(j));
                }
            }
        }
    }

    private void swap(Edge e1, Edge e2) {
        Edge temp = new Edge(e1);
        e1.setSource(e2.getSource());
        e1.setDestination(e2.getDestination());
        e1.setWeight(e2.getWeight());
        e1.setKey(e2.getKey());

        e2.setSource(temp.getSource());
        e2.setDestination(temp.getDestination());
        e2.setWeight(temp.getWeight());
        e2.setKey(temp.getKey());
    }

    public void add(Edge e) {
        sortedEdges.add((e));
        sortArray();
    }

    public Edge remove() {
        Edge e = sortedEdges.get(sortedEdges.size()-1);
        sortedEdges.remove(sortedEdges.size()-1);
        return e;
    }

    public void updateWeight(ArrayList<Edge> edges) {
        for(Edge e : edges) {
            for(Edge se : sortedEdges) {
                if(se.getKey() == e.getKey())
                    se.setWeight(e.getWeight());
            }
        }
        sortArray();
    }

}

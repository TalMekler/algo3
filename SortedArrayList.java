import java.util.ArrayList;

public class SortedArrayList {

    public ArrayList<Edge> sortedEdges = new ArrayList<>();

    public SortedArrayList() {}

    private void swap(Edge e1, Edge e2) {
        e1.setSource(e2.getSource());
        e1.setDestination(e2.getDestination());
        e1.setKey(e2.getKey());
        e1.setWeight(e2.getWeight());
    }

    private void sortArray() {
        Edge temp;
        for (int i = 0; i < sortedEdges.size(); i++) {
            for (int j = 0; j < sortedEdges.size(); j++) {
                if (sortedEdges.get(i).getWeight() <= sortedEdges.get(j).getWeight()) {
                    temp = sortedEdges.get(i);
                    swap(sortedEdges.get(i), sortedEdges.get(j));
                    swap(sortedEdges.get(j), temp);
                }
            }
        }
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

package algo3_package;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Heap {

    PriorityQueue<Edge> heap;

    public Heap() {
        heap = new PriorityQueue<>();
    }
    public Heap(ArrayList<Edge> edges){
        heap = new PriorityQueue<>();
        for(Edge e : edges)
            heap.add(e);
    }

    public void addEdge(Edge e){
        heap.add(e);
    }



}

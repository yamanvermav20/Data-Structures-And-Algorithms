import java.util.*;
public class heaps {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(2); //O(log n)
        pq.add(6); //O(log n)
        pq.add(1); //O(log n)
        pq.add(2); //O(log n)

        while(!pq.isEmpty()){
            System.out.print(pq.peek());
            pq.poll();
        }
    }
}

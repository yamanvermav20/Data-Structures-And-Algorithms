import java.util.*;

public class Main{
    public int resolve(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : arr) pq.offer(i);

        while(pq.size() > 1){
            int value = pq.poll();
            int value2 = pq.poll();

            if(value == value2) continue;
            if(value > value2) pq.offer(value);
            if(value2 > value) pq.offer(value2);
        }

        return pq.poll();
    }
    public static void main(String[] args) {
        
    }
}
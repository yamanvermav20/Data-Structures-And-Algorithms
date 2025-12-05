import java.util.PriorityQueue;

public class kthLargest {
    public static void kthLargest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);

            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            System.out.println
        }

    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 3, 22, 34};
        int k = 4;

        kthLargest(arr k);

    }
}

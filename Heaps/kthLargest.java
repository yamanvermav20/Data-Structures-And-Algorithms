import java.util.PriorityQueue;

public class kthLargest {
    public static void kthLargest(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);


        }

    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 3, 22, 34};

        kthLargest(arr k);

    }
}

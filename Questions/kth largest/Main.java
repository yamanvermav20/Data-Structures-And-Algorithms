import java.util.*;

public class Main{
    public static int kthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll(); // remove smallest
            }
        }

        return pq.peek();
    }
    public static void main(String[] args){
            int[] nums = {1, 2, 3, 3, 4};
            System.out.println(kthLargest(nums, 3));

    }
}
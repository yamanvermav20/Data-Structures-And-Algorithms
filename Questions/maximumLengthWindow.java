import java.util.*;
public class maximumLengthWindow {
    //max length window with sum equals = k;
    public static int maxLength(int[] arr, int k){
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(sum == k){
                maxLen = i + 1;
            }
            if(map.containsKey(sum - k)){
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }
            map.putIfAbsent(sum, i);
        }

        return maxLen;
    }
    public static void print(int[] prefix){
        for(int i : prefix){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        // int[] arr = {-1, 4, 3, -3, 2, 2, -4, -5};
        int[] arr = {1, -1, 1, -1};
        int k = 0;
        // print(arr);
        System.out.println(maxLength(arr, k));
    }
}

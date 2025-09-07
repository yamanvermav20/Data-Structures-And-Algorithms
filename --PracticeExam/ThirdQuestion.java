//package APC_EXAM_01_08_2025;
import java.util.*;
public class ThirdQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while(testcases-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(twoSum(arr, n, k));
        }
    }
    public static int twoSum(int[] arr, int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int complement = k - arr[i];
            if(map.containsKey(complement)){
                count++;
                map.put(complement, map.get(complement) - 1);
                if(map.get(complement) == 0){
                    map.remove(complement);
                }
            }
            else map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
    // public static int twoSum(int[] arr, int n, int k){ // my code in exam wrong may contains duplicate
    //     HashSet<Integer> set = new HashSet<>();
    //     int count = 0;
    //     for(int i = 0; i < arr.length; i++){
    //         if(set.contains(k - arr[i])){
    //             count++;
    //         }
    //         set.add(arr[i]);
    //     }
    //     return count;
    // }
}

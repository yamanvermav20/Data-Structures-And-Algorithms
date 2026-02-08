import java.util.*;
public class countNubmerofNiceSubarray {
    public static int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0) nums[i] = 0;
            else nums[i] = 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.print(numberOfSubarrays(nums, k));
    }
}
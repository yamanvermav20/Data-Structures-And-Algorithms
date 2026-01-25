public class subarrayScorelessthanK {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, count = 0;
        int start = 0, end = 0;
        while(end < nums.length){
            sum += nums[end];
            while(sum * (end  - start + 1) >= k){
                sum -= nums[start];
                start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}

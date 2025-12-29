public class Target_Sum_Subset {
    public static boolean targetSumSubset(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static boolean targetSumSubsetOptimized(int[] nums, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        int sum = 3;
        System.out.println(targetSumSubset(nums, sum));
    }
}

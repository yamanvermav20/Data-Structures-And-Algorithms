public class UnboundedKnapsack {
    public static int UnboundedKnapsackdp(int[] val, int[] wt, int W, int n){
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j <= W; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i - 1] <= j){
                    int include = val[i - 1] + dp[i][j - wt[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args){
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for(int i = 0; i <= val.length; i++){
            for(int j = 0; j <= W; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(UnboundedKnapsackdp(val, wt, W, val.length));

    }   
}

import java.util.*;
public class CoinChangedp {
    public static void coinChangeways(int[] coins, int sum, int n){
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                //include
                if(coins[i - 1] <= j){
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }   
        }
        print(dp);
        System.out.println(dp[n][sum]);
    }
    public static void coinChange(int[] coins, int sum, int n){
        int[][] dp = new int[n + 1][sum + 1];

        for(int[] i : dp){
            Arrays.fill(i, sum + 1);
        }

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                //include
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }   
        }
        print(dp);
        System.out.println(dp[n][sum]);
    }
    public static void print(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        // int[] coins = {2, 5, 3, 6};
        // int sum = 10;
        int[] coins = {1, 2, 5};
        int sum = 11;
        // coinChangeways(coins, sum, coins.length);
        coinChange(coins, sum, coins.length);
    }
}

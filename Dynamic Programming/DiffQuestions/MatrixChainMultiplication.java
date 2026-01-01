import java.util.*;
public class MatrixChainMultiplication {
    public static int MCM(int[] arr, int start, int end, int[][] dp){
        if(start == end){
            return 0;
        }

        if(dp[start][end] != -1) return dp[start][end];

        int ans = Integer.MAX_VALUE;

        for(int k = start; k < end; k++){
            int cost1 = MCM(arr, start, k, dp); // Astart .... Ak => arr[start - 1] x arr[k]
            int cost2 = MCM(arr, k + 1, end, dp); // Ak + 1 .... Aend => arr[k] x arr[j]
            int cost3 = arr[start - 1] * arr[k] * arr[end];
            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        dp[start][end] = ans;
        return dp[start][end];
    }

    public static int mcmTab(int[] arr){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //intialization
        for(int i = 0; i < n; i++){
            dp[i][i] = 0;
        }

        //bottom-up (filling diagnolly)
        for(int len = 2; len <= n - 1; len++){ 
            for(int i = 1; i <= n - len; i++){ // row
                int j = i + len - 1;  //col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k <= j - 1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }

        print(dp);
        return dp[1][n - 1];
    }
    public static void print(int[][] dp){
        for(int[] i : dp){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.err.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3}; // n = 5;
        int n = arr.length;

        int[][] dp = new int[n][n];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        System.out.println(MCM(arr, 1, n - 1, dp));
        System.out.println(mcmTab(arr));
    }    
}

public class UniquePath {
    //tabulation
    // public static int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for(int i = 0; i < m; i++){
    //         dp[i][0] = 1;
    //     }
    //     for(int j = 0; j < n; j++){
    //         dp[0][j] = 1;
    //     }
    //     for(int i = 1; i < m; i++){
    //         for(int j = 1; j < n; j++){
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }  
    public int path(int i, int j, int[][] dp){
        if(i == 0 || j == 0) return 1;

        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int left = path(i - 1, j, dp);
        int right = path(i, j - 1, dp);
        
        dp[i][j] = left + right;
        return dp[i][j];

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return path(m - 1, n - 1, dp);
    }  
    public static void main(String args[]){
        
    }
}

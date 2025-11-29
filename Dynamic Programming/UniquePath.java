public class UniquePath {
    //tabulation Code
    public static int uniquePathsMemo(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }  

    //memoization Code
    public static int path(int i, int j, int[][] dp){
        if(i == 0 || j == 0) return 1;

        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        int left = path(i - 1, j, dp);
        int right = path(i, j - 1, dp);
        
        dp[i][j] = left + right;
        return dp[i][j];

    }
    public static int uniquePathsTab(int m, int n) {
        int[][] dp = new int[m][n];
        return path(m - 1, n - 1, dp);
    }  
    public static void main(String args[]){
        int m = 3;
        int n = 7;

        // Test Tabulation
        int tabResult = uniquePathsTab(m, n);
        System.out.println("Tabulation Result: " + tabResult);

        // Test Memoization
        int memoResult = uniquePathsMemo(m, n);
        System.out.println("Memoization Result: " + memoResult);
    }
}

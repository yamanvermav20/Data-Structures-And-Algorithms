import java.util.*;

public class Question4{
    static int[][][] dp;
    public static int solve(int[][] grid1, int[][] grid2, int i, int j, int grid, int cost){
        if (i == grid1.length - 1 && j == grid1[0].length - 1) {
            return (grid == 1) ? grid1[i][j] : grid2[i][j];
        }

        if (i >= grid1.length || j >= grid1[0].length) {
            return Integer.MIN_VALUE; 
        }

        if(dp[i][j][grid] != -1){
            return dp[i][j][grid];
        }

        if(grid == 1){
            int right1 = grid1[i][j] + solve(grid1, grid2, i + 1, j, grid, cost);
            int down1 = grid1[i][j] + solve(grid1, grid2, i, j + 1, grid, cost);
            int right2 = grid2[i][j] + solve(grid1, grid2, i + 1, j, 2, cost) - cost;
            int down2 = grid2[i][j] + solve(grid1, grid2, i, j + 1, 2, cost) - cost;

            return dp[i][j][grid] = Math.max(Math.max(right1, down1), Math.max(right2, down2));
        }
        else{
            int right1 = grid2[i][j] + solve(grid1, grid2, i + 1, j, grid, cost);
            int down1 = grid2[i][j] + solve(grid1, grid2, i, j + 1, grid, cost);
            int right2 = grid1[i][j] + solve(grid1, grid2, i + 1, j, 1, cost) - cost;
            int down2 = grid1[i][j] + solve(grid1, grid2, i, j + 1, 1, cost) - cost;

            return dp[i][j][grid] = Math.max(Math.max(right1, down1), Math.max(right2, down2));
        }
    }

    public static int pathTabulation(int[][] grid1, int[][] grid2, int cost) {
    int n = grid1.length;
    int m = grid1[0].length;
    
    // dp[grid_type][row][col] 
    // 0 = Grid 1, 1 = Grid 2
    int[][][] dp = new int[2][n][m];

    // --- STEP 1: INITIALIZE BASE CASE (Starting Point) ---
    // At (0,0), you just pick up the value. No moves made yet.
    dp[0][0][0] = grid1[0][0];
    dp[1][0][0] = grid2[0][0];

    // --- STEP 2: FILL THE TABLE ---
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // Skip (0,0) because we already initialized it
            if (i == 0 && j == 0) continue;

            for (int g = 0; g < 2; g++) {
                int currentVal = (g == 0) ? grid1[i][j] : grid2[i][j];
                
                int fromTop = Integer.MIN_VALUE / 2;
                int fromLeft = Integer.MIN_VALUE / 2;

                // Option 1: Look Up
                if (i > 0) {
                    // Best of (Stay on same grid) OR (Switch from other grid - cost)
                    fromTop = Math.max(dp[g][i-1][j], dp[1-g][i-1][j] - cost);
                }

                // Option 2: Look Left
                if (j > 0) {
                    // Best of (Stay on same grid) OR (Switch from other grid - cost)
                    fromLeft = Math.max(dp[g][i][j-1], dp[1-g][i][j-1] - cost);
                }

                // Fill the cell
                dp[g][i][j] = currentVal + Math.max(fromTop, fromLeft);
            }
        }
    }

    // --- STEP 3: RETURN THE FINAL RESULT ---
    // The answer is the highest value sitting in the bottom-right corner
    return Math.max(dp[0][n-1][m-1], dp[1][n-1][m-1]);
}

    //only allow to move right or down
    public static int path(int[][] grid1, int[][] grid2, int cost){
        return Math.max(solve(grid1, grid2, 0, 0,1, cost), solve(grid1, grid2, 0, 0,2, cost));
    }

    public static void main(String[] args){
        int[][] grid1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        int[][] grid2 = {
            {2, 4, 6, 8},
            {1, 3, 5, 7},
            {9, 8, 7, 6}
        };

        int cost = 0;

        dp = new int[grid1.length][grid1[0].length][3];
        
        for(int[][] i : dp){
            for(int[] j : i) Arrays.fill(j, -1);
        }

        System.out.println(path(grid1, grid2, cost));
    }
}
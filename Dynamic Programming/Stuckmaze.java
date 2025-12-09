public class Stuckmaze {

    public static int canReach(int[][] maze, int sr, int sc, int dr, int dc, int[][] dp) {
        dp[sr][sc] = 1;
        for(int i = sr; i >= dr; i--){
            for(int j = sc; j <= dc; j++){
                if(maze[i][j] == 0) continue;
                if(i < maze.length - 1){
                    dp[i][j] += dp[i + 1][j];
                }
                if(j > 0){
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[dr][dc];
    }

    public static void main(String[] args) {

        int[][] maze = {
            {1, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 0, 1}
        };

        int sr = 2, sc = 1;   
        int dr = 1, dc = 3;   

        int[][] dp = new int[maze.length][maze[0].length];

        int result = canReach(maze, sr, sc, dr, dc, dp);
        System.out.println(result);
        
    }
}

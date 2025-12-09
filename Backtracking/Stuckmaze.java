public class Stuckmaze {

    public static int dfs(int[][] maze, int sr, int sc, int dr, int dc){
        if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 0 ) return 0;

        if(sr == dr && sc == dc){
            return 1;
        }
        
        maze[sr][sc] = 0;
        int left = dfs(maze, sr - 1, sc, dr, dc);
        int right = dfs(maze, sr, sc + 1, dr, dc);
        maze[sr][sc] = 1;

        return left + right;
    }
    public static int canReach(int[][] maze, int sr, int sc, int dr, int dc) {
        int ways = dfs(maze, sr, sc, dr, dc);
        return ways;
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


        int result = canReach(maze, sr, sc, dr, dc);


        System.out.println(result);
        
    }
}

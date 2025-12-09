public class Stuckmaze {

    public static int dfs(int[][] maze, int sr, int sc, int dr, int dc, boolean[][] visited){
        if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 0 || visited[sr][sc]) return 0;

        if(sr == dr && sc == dc){
            return 1;
        }
        
        visited[sr][sc] = true;
        int left = dfs(maze, sr - 1, sc, dr, dc, visited);
        int right = dfs(maze, sr, sc + 1, dr, dc, visited);
        visited[sr][sc]= false;

        return left + right;
    }
    public static int canReach(int[][] maze, int sr, int sc, int dr, int dc, boolean[][] visited) {
        int ways = dfs(maze, sr, sc, dr, dc, visited);
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

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        int result = canReach(maze, sr, sc, dr, dc, visited);


        System.out.println(result);
        
    }
}

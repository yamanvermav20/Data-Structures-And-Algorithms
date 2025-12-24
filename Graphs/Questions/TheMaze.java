public class TheMaze {
    static boolean[][] visited;
    public static boolean dfs(int[][] maze, int row, int col, int desti, int destj){
        if(visited[row][col]) return false;

        if(row == desti && col == destj){
            return true;
        }

        visited[row][col] = true;
        int c = col;
        while (c + 1 < maze[0].length && maze[row][c + 1] == 0) {
            c++;
        }
        if(c != col && dfs(maze, row, c, desti, destj)) return true;

        int r = row;
        while (r + 1 < maze.length && maze[r + 1][col] == 0) {
            r++;
        }
        if(r != row && dfs(maze, r, col, desti, destj)) return true;

        c = col;
        while (c > 0 && maze[row][c - 1] == 0) {
            c--;
        }
        if(c != col && dfs(maze, row, c, desti, destj)) return true;
       
        r = row;
        while (r > 0 && maze[r - 1][col] == 0) {
            r--;
        }
        if(r != row && dfs(maze, r, col, desti, destj)) return true;

        return false;
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination[0], destination[1]);
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,1,0},
            {1,1,0,1,1},
            {0,0,0,0,0}
        };

        int[] start = {0,4};
        int[] destination = {4,4};

        System.out.println(hasPath(maze, start, destination));
    }

}

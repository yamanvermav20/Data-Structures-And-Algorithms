import java.util.ArrayList;
import java.util.List;

public class ratinamaze {
    public static void backtrack(int[][] maze, boolean[][] visited, int n, List<String> result, String str, int row, int col){
        if(row >= n || col >= n || row < 0 || col < 0 || visited[row][col] || maze[row][col] == 0) return;
        
        if(row == n - 1 && col == n - 1){
            result.add(str);
            return;
        }

        visited[row][col] = true;
        backtrack(maze, visited, n, result, str + 'D', row + 1, col);    //down
        backtrack(maze, visited, n, result, str + 'R', row, col + 1);    //right
        backtrack(maze, visited, n, result, str + 'L', row, col - 1);    //left
        backtrack(maze, visited, n, result, str + 'U', row - 1, col);    //up
        visited[row][col] = false;
    }
    public static List<String> findPaths(int[][] maze, int n) {
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        backtrack(maze, visited, n, result, "", 0, 0);
        return result;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 0},
            {1, 1, 0},
            {1, 1, 1}
        };
        int n = 3;

        List<String> result = findPaths(maze, n);
        for (String path : result) {
            System.out.print(path + " ");
        }
    }
}

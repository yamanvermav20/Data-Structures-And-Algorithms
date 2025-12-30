//Done this by using dijkstra
import java.util.*;
public class TheMaze2 {
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair other){
            return this.dist - other.dist;
        }
    }
    public static int hasPath(int[][] maze, int[] start, int[] destination){
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        int[][] dist = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[start[0]][start[1]] = 0;
        queue.offer(new Pair(start[0], start[1], 0));

        int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;
            
            if(r == destination[0] && c == destination[1]){
                return d;
            }

            if (d > dist[r][c]) continue;

            for(int[] i : dir){
                int nr = r, nc = c, steps = 0;

                while(nr + i[0] >= 0 && nr + i[0] < maze.length && nc + i[1] >= 0 && nc + i[1] < maze[0].length && maze[nr + i[0]][nc + i[1]] == 0){
                    nr += i[0];
                    nc += i[1];
                    steps++;
                }
                if(dist[r][c] + steps < dist[nr][nc]){
                    dist[nr][nc] = dist[r][c] + steps;
                    queue.offer(new Pair(nr, nc, dist[nr][nc]));
                }
            }
        }

        return -1;


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

// There is a ball in a maze with empty spaces (0) and walls (1).
// The ball can roll up, down, left, or right, but it will not stop rolling until it hits a wall.

// When the ball hits a wall, it stops in the cell just before the wall.

// You are given:

// A 2D grid maze of size m x n

// A starting position start = [sx, sy]

// A destination position destination = [dx, dy]

// Your task

// Return true if the ball can stop exactly at the destination cell.
// Otherwise, return false.

// 📌 Important Rules

// The ball cannot stop mid-way; it only stops when it hits a wall

// The destination must be a stopping point, not a cell the ball just rolls through

// You may pass through the destination, but if you don’t stop there, it does not count
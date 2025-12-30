//Done this by using dijkstra
import java.util.*;

public class TheMaze3 {
    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int dist;
        String path;

        Pair(int row, int col, int dist, String path){
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.path = path;
        }

        @Override
        public int compareTo(Pair other){
             if (this.dist != other.dist)
                return this.dist - other.dist;
                return this.path.compareTo(other.path);
        }
    }
    public static String hasPath(int[][] maze, int[] start, int[] destination){
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        int[][] dist = new int[maze.length][maze[0].length];
        String[][] bestPath = new String[maze.length][maze[0].length];
        
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(bestPath[i], "");
        }
        
       int[][] dir = {
            {1, 0},   // d
            {0, -1},  // l
            {0, 1},   // r
            {-1, 0}   // u
        };
        char[] dirChar = {'d', 'l', 'r', 'u'};

        queue.offer(new Pair(start[0], start[1], 0, ""));
        dist[start[0]][start[1]] = 0;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;
            String path = curr.path;
            
            if(r == destination[0] && c == destination[1]){
                return path;
            }

            if (d > dist[r][c]) continue;

            for(int i = 0; i < 4; i++){
                int nr = r, nc = c, steps = 0;

                while(nr + dir[i][0] >= 0 && nr + dir[i][0] < maze.length && nc + dir[i][1] >= 0 && nc + dir[i][1] < maze[0].length && maze[nr + dir[i][0]][nc + dir[i][1]] == 0){
                    nr += dir[i][0];
                    nc += dir[i][1];
                    steps++;
                }
                String newPath = path + dirChar[i];
                int newDist = d + steps;

                if (newDist < dist[nr][nc] ||
                   (newDist == dist[nr][nc] &&
                    (bestPath[nr][nc].isEmpty() ||
                     newPath.compareTo(bestPath[nr][nc]) < 0))) {

                    dist[nr][nc] = newDist;
                    bestPath[nr][nc] = newPath;
                    queue.offer(new Pair(nr, nc, newDist, newPath));
                }
                
            }
        }

        return "impossible";


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



import java.util.ArrayList;

public class HasPath {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    //O(V + E);
    public static boolean dfs(ArrayList<Edge>[] graph, boolean[] visited, int src, int dest){
        if(src == dest) return true;

        visited[src] = true;
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && dfs(graph, visited, e.dest, dest)) return true;
        }
        return false;
    }
    public static void main(String[] args){
        /*
            1 ---- 3
            /      | \
           0       |  5 --- 6
            \      |  /
             2 ----4 

         */
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] visited = new boolean[V];
        
        boolean hasPath = dfs(graph, visited, 0, 6);
        System.out.println(hasPath);
    }
}

import java.util.*;
import java.util.Stack;

public class TopSortBFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 5));
    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for(int i = 0; i < graph.length; i++){
            int v = i;
            for(int j = 0; j < graph[v].size(); j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " "); //topological sort print

            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }

        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        /* 

        1 -------> 3
       / \           \
      /   \            \
     0     -----> 4 -----> 5
      \
       \
        --------> 2

        */
        int V = 6;   
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        topSort(graph);

        // for(int i = 0; i < graph.length; i++) {
        //     System.out.print("Vertex " + i + " -> ");
        //     for(Edge e : graph[i]) {
        //         System.out.print(
        //             "(" + e.src + " -> " + e.dest + ") "
        //         );
        //     }
        //     System.out.println();
        // }
    }
}

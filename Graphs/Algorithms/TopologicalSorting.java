//Directed Acyclic Graph(DAG) Directed graph with no Cycles
//Topological Sorting is used only for DAGs
//Definition:
//  It is a linear order of vertices such that every directed  edge u -> v,
//  the vertex u comes before v in the order
// Topological Sort :=


import java.util.*;

public class TopologicalSorting {
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

    public static void topSort(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                topSortUtil(graph, i, visited, stack); //modified dfs
            }
        }

        while(!stack.isEmpty()){
            System.err.println(stack.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack){
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSortUtil(graph, e.dest, visited, stack);
            }
        }

        stack.push(curr);
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

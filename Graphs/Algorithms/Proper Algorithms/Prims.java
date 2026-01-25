import java.util.*;

public class Prims {    
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        graph[0].add(new Edge(0, 2, 4));
        graph[2].add(new Edge(2, 0, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[3].add(new Edge(3, 1, 7));

        graph[3].add(new Edge(3, 2, 5));
        graph[2].add(new Edge(2, 3, 5));

        graph[3].add(new Edge(3, 4, 6));
        graph[4].add(new Edge(4, 3, 6));

        graph[2].add(new Edge(2, 5, 3));
        graph[5].add(new Edge(5, 2, 3));

        graph[4].add(new Edge(4, 5, 8));
        graph[5].add(new Edge(5, 4, 8));

    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; //cost based sorting for pairs
        }
    }

    //O(V + E LogV)
    public static void prims(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        int finalCost = 0; //MST cost / total minweight

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(!visited[curr.v]){
                visited[curr.v] = true;
                finalCost += curr.cost;

                for(int i = 0; i < graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    if (!visited[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }

                }
            }
        }

        System.out.println("final(min) Cost of MST = " + finalCost);
    }

    public static void main(String[] args) {

        /*          
                   
                       (7)
                1 ---------------- 3
               /                    \
           (2)/                      \(6)
             /                        \
            0                          4
             \                        /
           (4)\                      /(8)
               \                    /
                2 ---------------- 5
                       (3)
         
         */

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        prims(graph);
        // for (int i = 0; i < V; i++) {
        //     System.out.print(i + " → ");
        //     for (Edge e : graph[i]) {
        //         System.out.print("(" + e.dest + ", w=" + e.wt + ") ");
        //     }
        //     System.out.println();
        // }
    }
}

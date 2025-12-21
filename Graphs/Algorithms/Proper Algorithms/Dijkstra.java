import java.util.*;

//  What Dijkstra REALLY DOES
//  It processes nodes IN ORDER OF THEIR CURRENT SHORTEST DISTANCE
// (based on PriorityQueue)
//  Once a node is processed (visited = true),
// we are 100% sure its shortest path is finalized.
//  Because any other longer path reaching this node will never be shorter
// than the one already processed.
// This is the heart of Dijkstra.


public class Dijkstra {
    
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
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));

        graph[3].add(new Edge(3, 2, 5));
        graph[3].add(new Edge(3, 4, 6));

        graph[2].add(new Edge(2, 5, 3));

        // graph[5].add(new Edge(5, 2, 3));

        graph[4].add(new Edge(4, 5, 8));
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; //path based sorting for pairs
        }
    }

    //O(V + E LogV)
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];     //dist[i] -> src to i

        for(int i = 0; i < graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];

        pq.offer(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(!visited[curr.n]){
                visited[curr.n] = true;

                for(int i = 0; i < graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.offer(new Pair(v, dist[v]));
                    }
                }
            }
        }

        //print all source to vertices shortest dist
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String[] args) {

        /*
               

                   
             0  ----(2)---→ 1
             |              |
            (4)            (7)
             |              |
             ↓              ↓
             2  ←---(5)----  3
                |            |
                |            |
                |            |  
                (3)          (6)
                ↓             ↓
                |             |
                5 ←----(8)---- 4
                     
         */

        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        dijkstra(graph, 0);
        // for (int i = 0; i < V; i++) {
        //     System.out.print(i + " → ");
        //     for (Edge e : graph[i]) {
        //         System.out.print("(" + e.dest + ", w=" + e.wt + ") ");
        //     }
        //     System.out.println();
        // }
    }
}

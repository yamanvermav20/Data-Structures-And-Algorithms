//package Questions.BoardInfinitypractice.Minimum Spanning Tree;
// 🔵 Problem 2: Minimum Spanning Tree (MST)
// 📌 Problem Description

// The graph is undirected, meaning an edge between u and v can be traversed in both directions.
// Vertices are numbered from 0 to V-1.

// Custom Output Format:

// Print a single integer representing the total weight of the Minimum Spanning Tree (MST) of the graph.

// 📥 Input Format
// First line: two integers V and E
// Next E lines: three integers u v w

import java.util.*;

public class Main {
    static class Solution {
        public class Edge{
            int dest;
            int weight;
            
            public Edge(int dest, int weight){
                this.dest = dest;
                this.weight = weight;
            }
        }
        int spanningTree(int V, int E, int[][] edges) {
            ArrayList<Edge>[] graph = new ArrayList[V];

            for(int i = 0; i < V; i++) graph[i] = new ArrayList<>();

            for(int[] i : edges){
                graph[i[1]].add(new Edge(i[0], i[2]));
                graph[i[0]].add(new Edge(i[1], i[2]));
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            boolean[] visited = new boolean[V];

            pq.offer(new int[]{0, 0});
            int ans = 0;

            while(!pq.isEmpty()){
                int[] values = pq.poll();
                int src = values[0];
                int wt = values[1];

                if(!visited[src]){
                    visited[src] = true;
                    ans += wt;

                    for(int i = 0; i < graph[src].size(); i++){
                        Edge e = graph[src].get(i);

                        if(!visited[e.dest]) pq.offer(new int[]{e.dest, e.weight});
                        
                        // if(edges[i][0] == src){
                        //     pq.offer(new int[]{edges[i][1], edges[i][2]});
                        // }
                        // else if(edges[i][1] == src){
                        //     pq.offer(new int[]{edges[i][0], edges[i][2]});
                        // }
                    }
                }

            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] edges = new int[E][3];

        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        Solution sol = new Solution();
        int result = sol.spanningTree(V, E, edges);

        System.out.println(result);
        sc.close();
    }
}
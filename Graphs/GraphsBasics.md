# Graph Basics - DSA Notes

## What is a Graph?
A graph is a non-linear data structure made of:
- **Vertices (Nodes)**
- **Edges (Connections)**

Used in:
- Maps & navigation
- Social networks
- Network routing
- Scheduling problems

---

## Types of Graphs

### 1. Directed Graph
Edges have direction.
Example: A → B

### 2. Undirected Graph
Edges are two-way.
Example: A — B

### 3. Weighted Graph
Edges have costs/weights.

### 4. Unweighted Graph
Edges have no weights.

### 5. Cyclic Graph
Contains cycles.

### 6. Acyclic Graph
No cycles (Example: DAG).

---

## Graph Representations

### 1. Adjacency Matrix
2D array — good for dense graphs.

### 2. Adjacency List
Each node stores list of neighbors — best for sparse graphs.

---

## Important Graph Algorithms

| Algorithm         | Use |
|-------------------|------|
| BFS               | Shortest path (unweighted) |
| DFS               | Flood fill, cycles |
| Topological Sort | DAG ordering |
| Dijkstra         | Shortest path (weighted) |
| Union Find       | Cycle detection |
| MST (Kruskal)    | Minimum spanning tree |

---

✅ Today Focus:
- BFS traversal
- Shortest Path in Matrix
- flood fill
- no. of islands
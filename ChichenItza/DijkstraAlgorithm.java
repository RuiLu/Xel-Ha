import java.util.*;

/*
 * The Dijkstra Algorithm finds the shortest path 
 * from a source to all destinations in a directed graph (single source shortest path problem). 
 * During this process it will also determine a spanning tree for the graph.
 */
public class Dijkstra {
	
	private static final int V = 6;
	
	public static void main(String[] args) {
//		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
//            {4, 0, 8, 0, 0, 0, 0, 11, 0},
//            {0, 8, 0, 7, 0, 4, 0, 0, 2},
//            {0, 0, 7, 0, 9, 14, 0, 0, 0},
//            {0, 0, 0, 9, 0, 10, 0, 0, 0},
//            {0, 0, 4, 14, 10, 0, 2, 0, 0},
//            {0, 0, 0, 0, 0, 2, 0, 1, 6},
//            {8, 11, 0, 0, 0, 0, 1, 0, 7},
//            {0, 0, 2, 0, 0, 0, 6, 7, 0}
//           };
		int graph[][] = new int[][] {
			{0, 7, 9, 0, 0, 14},
			{7, 0, 10, 15, 0, 0},
			{9, 10, 0, 11, 0, 2},
			{0, 15, 11, 0, 6, 0},
			{0, 0, 0, 6, 0, 9},
			{14, 0, 2, 0, 9, 0}
		};
        dijkstra(graph, 0);
	}
	
	private static void dijkstra(int[][] graph, int src) {
		int[] dist = new int[V];
		// visited[i] will be true if vertex i is included in shortest path tree or
		// shortest path from src to i is finalized
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		// distance of source vertex is always zero
		dist[src] = 0;
		
		// find all shortest paths for all vertexes
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
			int u = minDistance(dist, visited);
			
			visited[u] = true;
			
			// Update dist value of the adjacent vertices of the
            // picked vertex.
			for (int v = 0; v < V; v++) {
				if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
						dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		
		// print the constructed distance array
        printSolution(dist, V);
	}
	
	private static int minDistance(int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		
		// find the current shortest path from unvisited nodes, return its index.
		for (int v = 0; v < V; v++) {
			if (!visited[v] && dist[v] < min) {
				min = dist[v];
				minIdx = v;
			}
		}
		
		return minIdx;
	}
	
	private static void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }
	
}


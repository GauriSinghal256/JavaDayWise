// here in adjacency matrix we will be using 2D array to represent the graph
//      0 —— 1
//      |     |
//      |     |
//      2 —— 3
// this is unweighted graph and undirected graph
// the matrix will look like this
// if there is a connection between 2 vertices then we will put 1 otherwise 0

//           0 1 2 3
//         ---------
//       0 | 0 1 1 0
//       1 | 1 0 0 1
//       2 | 1 0 0 1
//       3 | 0 1 1 0
import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix {

    static int[][] matrix;
    static int vertices;

    AdjacencyMatrix(int v) {
        vertices = v;
        matrix = new int[v][v];
    }

    void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
        matrix[dest][src] = 1; // for undirected graph
    }

    void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if edge exists — O(1)
    boolean hasEdge(int u, int v) {
        return matrix[u][v] == 1;
    }

    // Get all neighbors of node u — O(V) even if few neighbors
    List<Integer> getNeighbors(int u) {
        List<Integer> neighbors = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            if (matrix[u][v] == 1) {
                neighbors.add(v);
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.printGraph();
        System.out.println("Edge between 0 and 1: " + graph.hasEdge(0, 1)); 
        System.out.println("Neighbors of 0: " + graph.getNeighbors(2));

    }

}

/* 
Time Complexity 
Operation	  Complexity
Add Edge	      O(1)
Check Edge	   O(1)
Space	        O(V²)

 */

/*  
⚠️ Problem:
If graph has 1000 vertices, matrix size =

1000 × 1000 = 1,000,000 cells

So it uses more memory.

*/

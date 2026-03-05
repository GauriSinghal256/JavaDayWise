
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
import java.util.*;
public class AdjacencyMatrix{
    static int[][] matrix;
    static int vertices;

    public AdjacencyMatrix(int v) {
        AdjacencyMatrix.vertices = v;
        matrix = new int[v][v];
    }

    void addEdge(int src, int des){  
        matrix[src][des] = 1;
        matrix[des][src] = 1;   // for undirected graph
    }

    // add edge for directed graph
    void addDirectedEdge(int src, int des){
        matrix[src][des] = 1;
    }

    // add edge for weighted graph
    void addWeightedEdge(int src, int des, int weight){
        matrix[src][des] = weight;
        matrix[des][src] = weight;   // for undirected graph
    }

     // add edge for directed weighted graph
     void addDirectedWeightedEdge(int src, int des, int weight){
        matrix[src][des] = weight;
    }

     void printGraph(){
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // check if there is an edge between two vertices
    boolean hasEdge(int src, int des){
        return matrix[src][des] != 0;
    }

    // get the weight of the edge between two vertices
    int getEdgeWeight(int src, int des){
        return matrix[src][des];
    }

    // remove an edge between two vertices
    void removeEdge(int src, int des){
        matrix[src][des] = 0;
        matrix[des][src] = 0;   // for undirected graph
    }

     // remove an edge for directed graph
     void removeDirectedEdge(int src, int des){
        matrix[src][des] = 0;
    }

     // remove an edge for weighted graph
     void removeWeightedEdge(int src, int des){
        matrix[src][des] = 0;
        matrix[des][src] = 0;   // for undirected graph
    }

     // remove an edge for directed weighted graph
     void removeDirectedWeightedEdge(int src, int des){
        matrix[src][des] = 0;
    }

    // get all the neighbors of a vertex
    List<Integer> getNeighbours(int u){
        List<Integer> neighbours = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            if(matrix[u][i] != 0){
                neighbours.add(i);
            }
        }
        return neighbours;
    }

    // get the degree of a vertex
    int getDegree(int u){
        int degree = 0;
        for(int i=0; i<vertices; i++){
            if(matrix[u][i] != 0){
                degree++;
            }
        }
        return degree;
    }

    // get the in-degree of a vertex
    // for undirected graph degree , indegree and outdegree are same

    // for directed graph - here we are counting the number of edges coming into the vertex u
    // that is we will traverse the column of the vertex u and count the number of non-zero entries in that column
    int getInDegree(int u){
        int inDegree = 0;
        for(int i=0; i<vertices; i++){
            if(matrix[i][u] != 0){
                inDegree++;
            }
        }
        return inDegree;
    }

    // get the out-degree of a vertex
    // for directed graph - here we are counting the number of edges going out of the vertex
    // that is we will traverse the row of the vertex u and count the number of non-zero entries in that row
    int getOutDegree(int u){
        int outDegree = 0;
        for(int i=0; i<vertices; i++){
            if(matrix[u][i] != 0){
                outDegree++;
            }
        }
        return outDegree;
    }

    // get the total number of edges in the graph
    int getTotalEdges(){
        int totalEdges = 0;
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                if(matrix[i][j] != 0){
                    totalEdges++;
                }
            }
        }
        return totalEdges/2;   // for undirected graph
    }

     // get the total number of edges for directed graph
     int getTotalDirectedEdges(){
        int totalEdges = 0;
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                if(matrix[i][j] != 0){
                    totalEdges++;
                }
            }
        }
        return totalEdges;   // for directed graph
    }

    

    public static void main(String[] args) {
         AdjacencyMatrix graph = new AdjacencyMatrix(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.printGraph();
        System.out.println("Edge between 0 and 1: " + graph.hasEdge(0, 1)); 
        System.out.println("Neighbors of 0: " + graph.getNeighbours(2));
        
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

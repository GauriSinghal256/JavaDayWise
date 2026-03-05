
// implementation using list of lists
import java.util.*;
public class AdjacencyList {
    int V;
    ArrayList<ArrayList<Integer>> adj;

    public AdjacencyList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
    }

    // add edge for undirected graph
    void addEdge(int src , int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);   // for undirected graph
    }

    // add edge for directed graph
    void addDirectedEdge(int src, int dest){
        adj.get(src).add(dest);
    }

    // void printGraph(){
    //     for(int i=0 ;i<V;i++){
    //         System.err.print(i+ "-> ");
    //         for(int j=0; j<adj.get(i).size();j++){
    //             System.out.print(adj.get(i).get(j) + " ");
    //         }
    //     }
    // }

    void printGraph(){
        for(int i=0;i<V;i++){
            System.out.print(i + " -> ");
            for(int node : adj.get(i)){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    // check if there is an edge between two vertices
    boolean hasEdge(int src, int dest){
        return adj.get(src).contains(dest);
    }

    // get all the neighbors of a vertex
    List<Integer> getNeighbours(int u){
        return adj.get(u);
    }

    // remove an edge between two vertices
    void removeEdge(int src, int dest){
        adj.get(src).remove(Integer.valueOf(dest));
        adj.get(dest).remove(Integer.valueOf(src));   // for undirected graph
    }

    // remove an edge for directed graph
    void removeDirectedEdge(int src, int dest){
        adj.get(src).remove(Integer.valueOf(dest));
    }

    // degree of a vertex
    int degree(int u){
        return adj.get(u).size();
    }

    // indegree for directed graph
    int indegree(int u){
        int indegree = 0;
        for(int i=0; i<V; i++){
            if(adj.get(i).contains(u)){
                indegree++;
            }
        }
        return indegree;
    }

     // outdegree for directed graph
     int outdegree(int u){
        return adj.get(u).size();
    }



    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(4);
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
Operation	Complexity
Add Edge	O(1)
Remove Edge	O(V)
Check Edge	O(V)
Get neighbors	O(1)
Degree	      O(1)
Indegree    O(V)  
*/
// here we are implementing for the weoghted graph using adjacency list
// here we are using array of arraylist to store the graph
import java.util.*;
public class AAList {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
        static ArrayList<Edge>[] graph;
    
        public AAList(int v) {
            graph = new ArrayList[v];
            for(int i=0; i<v; i++){
                graph[i] = new ArrayList<>();
            }
        }
    
        void addEdge(int src, int dest, int weight){
            graph[src].add(new Edge(src, dest, weight));
            graph[dest].add(new Edge(dest, src, weight));   // for undirected graph
        }
    
        void printGraph(){
            for(int i=0; i<graph.length; i++){
                System.out.print(i + " -> ");
                for(Edge edge : graph[i]){
                    System.out.print(edge.dest + "(" + edge.weight + ") ");
                }
                System.out.println();
            }
        }

        // check if there is an edge between two vertices
        boolean hasEdge(int src, int dest){
            for(int i=0; i<graph[src].size() ; i++){

                Edge e = graph[src].get(i);
                if(e.dest == dest){
                    return true;
                }
            }
            return false;
        }

        // get the weight of the edge between two vertices
        int getEdgeWeight(int src, int dest){
            for(int i=0 ; i<graph[src].size() ; i++){
                Edge e = graph[src].get(i);
                if(e.dest == dest){
                    return e.weight;
                }
            }
            return -1;  // return -1 if there is no edge between src and dest
        }

        // remove an edge between two vertices
        void removeEdge(int src, int dest){
            for(int i=0; i<graph[src].size() ; i++){
                Edge e = graph[src].get(i);
                if(e.dest == dest){
                    graph[src].remove(i);
                    break;
                }
            }
            for(int i=0; i<graph[dest].size() ; i++){
                Edge e = graph[dest].get(i);
                if(e.dest == src){
                    graph[dest].remove(i);
                    break;
                }
            }
        }

         // remove an edge for directed graph
         void removeDirectedEdge(int src, int dest){
            for(int i=0; i<graph[src].size() ; i++){
                Edge e = graph[src].get(i);
                if(e.dest == dest){
                    graph[src].remove(i);
                    break;
                }
            }
        }

        // degree of a vertex
        int degree(int u){
            return graph[u].size();
        }

         // indegree for directed graph
         int indegree(int u){
            int indegree = 0;
            for(int i=0; i<graph.length; i++){
                for(Edge e : graph[i]){
                    if(e.dest == u){
                        indegree++;
                    }
                }
            }
            return indegree;
        }

         // outdegree for directed graph
         int outdegree(int u){
            return graph[u].size();
        }

        // get all the neighbors of a vertex
        void getNeighbours(int u){
            for(int i=0; i<graph[u].size() ; i++){
                Edge e = graph[u].get(i);
                System.out.print(e.dest + "(" + e.weight + ") ");
            }
             System.out.println();
        }

    public static void main(String[] args) {
         AAList g = new AAList(4);

    g.addEdge(0, 1, 4);
    g.addEdge(0, 2, 7);
    g.addEdge(1, 3, 2);
    g.addEdge(2, 3, 5);

    System.out.println("Graph:");
    g.printGraph();

    System.out.println("\nCheck Edge 0 → 1: " + g.hasEdge(0,1));

    System.out.println("Weight of edge 0 → 2: " + g.getEdgeWeight(0,2));

    System.out.print("Neighbors of 1: ");
    g.getNeighbours(1);

    System.out.println("Degree of 0: " + g.degree(0));

    System.out.println("Indegree of 3: " + g.indegree(3));

    System.out.println("\nRemoving edge 0 - 2");

    g.removeEdge(0,2);

    g.printGraph();
    }
    
}


import java.util.ArrayList;

public class Implementation {

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

    public static void main(String[] args) {
        int V = 5; //total number of vertices as we have to create an array of the size of total number of vertices and in that array we can easily store the lists 
        // here we have to understand it very clearly that what it is trying to say to us means how we are initialising the array 
        // int[] arr = new int[] so this was the normal array that we used to create but now instead of integer we are storing arraylist which is going to have edge internally so now we have to declare our array likewise
        ArrayList<Edge>[] graph = new ArrayList[V];   //now all the elements are null 

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);

        // for (int i = 0; i < V; i++) {
        //     graph.add(new ArrayList<>());
        // }

        // we can also make arraylist of arraylist then no error will come and also this a modern way to store the graph

        // 0-vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2-vertex
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3-vertex
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 2));

        // 2 neighbour 
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}

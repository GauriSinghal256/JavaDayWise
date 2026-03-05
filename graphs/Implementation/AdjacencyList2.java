
// // here we are implementing for the weighted graph using adjacency list
// here we are using array of arraylist to store the graph and in that arraylist we are storing the edge which is having source destination and weight

import java.util.ArrayList;

public class AdjacencyList2 {

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

    public static void printGraph(ArrayList<Edge>[] graph) {

    for(int i = 0; i < graph.length; i++) {

        System.out.print(i + " -> ");

        for(int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);

            System.out.print("(" + e.dest + "," + e.wt + ") ");
        }

        System.out.println();
    }
}


public static void getNeighbours(ArrayList<Edge>[] graph, int v) {

    for(int i = 0; i < graph[v].size(); i++) {
        Edge e = graph[v].get(i);

        System.out.println("Neighbour : " + e.dest + " weight : " + e.wt);
    }
}


public static boolean hasEdge(ArrayList<Edge>[] graph, int src, int dest){

    for(int i = 0; i < graph[src].size(); i++) {

        Edge e = graph[src].get(i);

        if(e.dest == dest) {
            return true;
        }
    }

    return false;
}

//  degree for undirected = total number of neighbours
public static int degree(ArrayList<Edge>[] graph, int v){

    return graph[v].size();
}

// Out-degree means edges going out from node. same as the above 

// Directed Grapg in degree
// we must scan the whole graph and count the number of edges coming into the node

public static int indegree(ArrayList<Edge>[] graph, int v){

    int count = 0;

    for(int i = 0; i < graph.length; i++){

        for(int j = 0; j < graph[i].size(); j++){

            Edge e = graph[i].get(j);

            if(e.dest == v){
                count++;
            }
        }
    }

    return count;
}

public static int totalEdges(ArrayList<Edge>[] graph){

    int count = 0;

    for(int i = 0; i < graph.length; i++){
        count += graph[i].size();
    }

    return count;
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

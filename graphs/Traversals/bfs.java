import java.util.*;

public class bfs{
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

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[5].add(new Edge(6, 5, 1));
    }

    // basic BFS traversal
    public static void bfsT(ArrayList<Edge> graph[], int start ,int V) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!visited[e.dest]){
                    visited[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
    }

    // bfs with distance/level tracking - useful for shortest path in unweighted graph
    public static void bfsWithLevel(ArrayList<Edge> graph[], int start ,int V){
        int[] dist = new int[V];
        Arrays.fill(dist, -1); // initialize distances to -1 (unreachable)
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0; // distance to the start node is 0
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(dist[e.dest] == -1){ // if the node is unvisited
                    dist[e.dest] = dist[curr] + 1; // update distance
                    q.add(e.dest);
                }
            }
        }
        // print shortest distances
        System.out.println("Shortest distances from node " + start + ":");

        for(int i=0; i<V; i++){
            System.out.println(start + " -> " + i + " = " + dist[i]);
        }
    }


    public static void main(String[] args){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfsT(graph, 1, V);
        bfsWithLevel(graph, 1, V);
    }

}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_HasPath {
          // using way-1 Adjacency List i.e ArrayList<Edge>
   static class Edge{
    int src,dest,weight;// src->source,destination & weight 
    Edge(int s,int d,int w){
       this.src = s;
       this.dest = d;
       this.weight = w;
    }
   } 
  static void createGraph(ArrayList<Edge> [] graph){//o(N)
      // convert this null graph with empty i.e initialize with new ArrayList
      for(int i = 0; i<graph.length; i++){ // here i is vertex
        graph[i] = new ArrayList<>();// here [[],[],[],[],[]]
      }
    // from vertex-0
    graph[0].add(new Edge(0,1,5));
    graph[0].add(new Edge(0, 2, 4));
    // from vertex-1
    graph[1].add(new Edge(1,0,5));// b/c the graph is undirected graph
    graph[1].add(new Edge(1,3,1));
  //  from vertex-2
    graph[2].add(new Edge(2,0,1));
    graph[2].add(new Edge(2,4,2));
  // from vertex-3
   graph[3].add(new Edge(3,1,3));
   graph[3].add(new Edge(3,5,1));
   graph[3].add(new Edge(3,4,1));
// from vertex-4
   graph[4].add(new Edge(4,3,3));
   graph[4].add(new Edge(4,2,2));
   graph[4].add(new Edge(4,5,9));
   // from vertex-5
   graph[5].add(new Edge(5,3,2));
   graph[5].add(new Edge(5,4,0));
   graph[5].add(new Edge(5,6,2));
// from vertex-6
  graph[6].add(new Edge(6,5,2));


  } 
  static void dfs(ArrayList<Edge> graph[],int stPoint){// O(n) , n = no. of vertices in a graph
    boolean vis[] = new boolean[graph.length];
    for(int i = 0; i<graph.length; i++){
      dfsUtil(graph, stPoint, vis);// helper funtion useable for connected component also
    }
  }
  static void dfsUtil(ArrayList<Edge> graph[],int stPoint,boolean vis[]){//O(V+E)
     // visit the curr-Vertex here stPoint is curr-vertex for call-1
    System.out.print(stPoint + " ");
     vis[stPoint] = true; // mark as true once a vertex has been visited
     // now jump to curr's neighbours
    for(int i = 0; i<graph[stPoint].size(); i++){
        // i-->indicate edges like e1,e2,e3,....so on
        Edge e = graph[stPoint].get(i);
       if(!vis[e.dest]){
        dfsUtil(graph, e.dest, vis);// 
       }
    }
}
static boolean hasPath(ArrayList<Edge> graph[],int curr,int dest,boolean vis[]){//O(V+E)
  if(curr == dest){
    return true;
  }
  // visit the node/vertex
  vis[curr] = true;
  // now jump to curr's Neighbour
 for(int i = 0;  i<graph[curr].size(); i++){
    Edge e = graph[curr].get(i);
    // e.dest = neighbour
  if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
    return true;
   }
}
  return false;
}
public static void main(String[] args) {
    int V = 7;// let say vertices = 5
    @SuppressWarnings("unchecked")
    ArrayList<Edge> [] graph = new ArrayList[V];
    createGraph(graph);
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the start-point = ");
        int st = sc.nextInt();
      System.out.print("Enter the destination-point = ");
      int dt = sc.nextInt();
      System.out.println("The vertices of the graph are :- ");
      dfs(graph,st);
  if(hasPath(graph, st, dt, new boolean[V])){
         System.out.println("\nYes,There is a valid path b/w starting-Point("+st+") & ending-point("+dt+").");
  }else{
      System.out.println("\nNo,There is a Invalid path b/w starting-Point("+st+") & ending-point("+dt+").");
  }
 }

}
    
}

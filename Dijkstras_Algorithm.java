import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras_Algorithm {
          // using way-1 Adjacency List i.e ArrayList<Edge>
   static class Edge{
    int src,dest,weight;// src->source,destination & weight 
    Edge(int s,int d,int w){
       this.src = s;
       this.dest = d;
       this.weight = w;
    }
   } 
  static void createGraph(ArrayList<Edge> [] graph){
      // convert this null graph with empty i.e initialize with new ArrayList
      for(int i = 0; i<graph.length; i++){ // here i is vertex
        graph[i] = new ArrayList<>();// here [[],[],[],[],[]]
      }
    // from vertex-0
    graph[0].add(new Edge(0,1,2));
    graph[0].add(new Edge(0,2,4));
    // from vertex-1
    graph[1].add(new Edge(1,2,1));// b/c the graph is directed graph
    graph[1].add(new Edge(1,3,7));
  //  from vertex-2
    graph[2].add(new Edge(2,4,3));
  // from vertex-3
   graph[3].add(new Edge(3,5,1));
// from vertex-4
   graph[4].add(new Edge(4,3,2));
   graph[4].add(new Edge(4,5,5));
 }
 
 static class Pair implements Comparable<Pair>{
     int v,path;
     Pair(int vertex,int shortPath){
        this.v = vertex;
        this.path = shortPath;
     }
  @Override
  //O(elogv)
  public int compareTo(Pair p2){// here each object of class pair sorted in ascending order
     return (this.path-p2.path);// path based sorting
  }
 } 

 static void dijkstra(ArrayList<Edge> graph[],int src){//O(V + ElogV)
   // create an array of integer type to store the shortest-distance/path from src to all vertices of the graph
  int dist[] = new int[graph.length];
  // step-1 :-  initialize all vetices with +infinity accept src(i.e 0)
 for(int i = 0;i<dist.length; i++){
     if(i != src){// initialize to all vertices accept src-one
       dist[i] = Integer.MAX_VALUE; // +infinty
     }
   }
  // step-2 :- create a PQ to store all shortest path of vertices from src
 PriorityQueue<Pair> pq = new PriorityQueue<>();
 pq.add(new Pair(src,0));// shortest path from src to src = 0
 boolean vis[] = new boolean[graph.length];// created for marking visited to the visited vertex
 // now apply normal BFS
  while(!pq.isEmpty()){
     Pair curr = pq.remove();
    if(!vis[curr.v]){
      // first make the curr.vertex as visited
      vis[curr.v] = true;
    // now check for its neigbhours here curr.v is curr's vertex 
    for(int i = 0; i<graph[curr.v].size(); i++){
         // extract all edges from src(u)-->dest(v)
        Edge e = graph[curr.v].get(i);
        // u()---wt()--->v() for each edge i.e from u-->v
        int u = e.src;
        int v = e.dest;
        int wt = e.weight; 
    // now apply dijkstra's algorithm
     if(dist[u]+ wt < dist[v]){ // here dist(u) + wt(u,v) < dist(v) ---> dist(v) = dist(u) + wt(u,v).
        // update the dist[v] i.e replace the path by the shortest distance
       dist[v] = dist[u] + wt;
       pq.add(new Pair(v, dist[v]));
       }
    }
   }
  }
  // now print all shortest path/distance from src to all vertices of the graph
  for(int i : dist){
     System.out.print(i + " ");
  }
  System.out.println();
 }
 
 public static void main(String[] args) {
    int v = 6;
    @SuppressWarnings("unchecked")
   ArrayList<Edge> graph[] = new ArrayList[v];
  // create a Directed graph
   createGraph(graph);
   System.out.println("All the shortest path from src = 0 are :- ");
   dijkstra(graph,0);
 }
}

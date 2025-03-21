import java.util.ArrayList;

public class Bellman_Ford {
          // using way-1 Adjacency List i.e ArrayList<Edge>
   static class Edge{
    int src,dest,weight;// src->source,destination & weight 
    Edge(int s,int d,int w){
       this.src = s;
       this.dest = d;
       this.weight = w;
    }
   } 
  static void createEdge(ArrayList<Edge> edges){
    
     edges.add(new Edge(0,1,2));
     edges.add(new Edge(0,2,4));
     edges.add(new Edge(1,2,-4));// b/c the graph is directed graph
     edges.add(new Edge(2,3,2));
     edges.add(new Edge(3,4,4));
     edges.add(new Edge(4,1,-1));
 } 


 static void bellmanFord(ArrayList<Edge> graph[],int src){//O(V*E)
     // create an array of integer type to store the shortest distance from src to all vertices
     int dist[] = new int[graph.length];// graph.length tells total no.of vertices
    // step-1 :- initialize all vertices with +infinity accept src-vertex(i.e = 0,b/c shortest-distance from src to src = 0)
    for(int i = 0 ; i<dist.length; i++){
       if(i != src){
        dist[i] = Integer.MAX_VALUE;
       }
    }
    int V = graph.length;
 // step-2 perform V-1 times
   for(int i = 0; i<V-1; i++){
    // find all edges takes (E) time,using following statement
    for(int j = 0; j < graph.length; j++){// here j --> indicate total vertices of the graph
      for(int k = 0; k < graph[j].size(); k++){// here k ---> total no. of edges from each vertex of the graph
         Edge e = graph[j].get(k);
         // find u,v,wt(u,v) for ease to understand
         int u = e.src;
         int v = e.dest;
         int wt = e.weight;
     // perform Relaxtion step
        if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
            // update the dist[v] i.e new shortest distance from u to v;
           dist[v] = dist[u] + wt;
        }
      }
    }
   }
  // now print all shortest distance of vertices of the graph
  for(int i  = 0; i<dist.length; i++){
    System.out.print(dist[i] + " ");
  }
  System.out.println();
 }

 public static void main(String[] args) {
  int v = 5;
//   @SuppressWarnings("unchecked")
//   ArrayList<Edge> graph[] = new ArrayList[v];
  ArrayList<Edge> edges = new ArrayList<>();
  // build a graph
  //createGraph(graph);
  createEdge(edges);
  System.out.println("All shortest path from src = 0 to all vertices of the graph ");
   bellman_Edge_Ford(edges, 0, v);
}
 static void bellman_Edge_Ford(ArrayList<Edge> edges,int src,int V){//O(V*E)
    // create an array of integer type to store the shortest distance from src to all vertices
    int dist[] = new int[V];// graph.length tells total no.of vertices
   // step-1 :- initialize all vertices with +infinity accept src-vertex(i.e = 0,b/c shortest-distance from src to src = 0)
   for(int i = 0 ; i<dist.length; i++){
      if(i != src){
        dist[i] = Integer.MAX_VALUE;
      }
   }
// step-2 perform V-1 times
  for(int i = 0; i<V-1; i++){
   // find all edges takes (E) time,using following statement
   for(int j = 0; j <edges.size(); j++){// here j --> indicate total vertices of the graph
        Edge e = edges.get(j);
        // find u,v,wt(u,v) for ease to understand
        int u = e.src;
        int v = e.dest;
        int wt = e.weight;
    // perform Relaxtion step
     if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){ // update the dist[v] i.e new shortest distance from u to v;
          dist[v] = dist[u] + wt;
       }
     }
   }
 // now print all shortest distance of vertices of the graph
 for(int i  = 0; i<dist.length; i++){
   System.out.print(dist[i] + " ");
 }
 System.out.println();
}
}

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algorithm {
// here our task :- To find a MST and return min. cost
static class Edge{
    int src,dest,weight;// src->source,destination & weight 
    Edge(int s,int d,int w){
       this.src = s;
       this.dest = d;
       this.weight = w;
    }
   } 
  static void createEdge(ArrayList<Edge> edges){
    
     edges.add(new Edge(0,1,10));
     edges.add(new Edge(0,5,15));
     edges.add(new Edge(0,3,30));
     edges.add(new Edge(1,3,40));// let the graph is directed graph
     edges.add(new Edge(2,3,50));
     //edges.add(new Edge(3,2,50));
 } 
    
 static class Pair implements Comparable<Pair>{
    int v,cost;//v- vertex from u,,cost-> cost 
   Pair(int vertex,int cost){
     this.v = vertex;
     this.cost = cost;
   }
 @Override
 public int compareTo(Pair p2){
    return (this.cost - p2.cost);// based on cost , store the pair in ascending order
  }
 }

 static void getMSTCost(ArrayList<Edge> graph,int V){
   boolean vis[] = new boolean[V];
   PriorityQueue<Pair> pq = new PriorityQueue<>();
   // initailize with starting point i.e let 0
   pq.add(new Pair(0, 0));
   int finalCost = 0;// to store total min. weight of the MST
   ArrayList<Integer> edges = new ArrayList<>();// to track the edges that are used to form the MST
   
   while(!pq.isEmpty()){
     Pair curr = pq.remove();
     if(!vis[curr.v]){// if curr's vertex is unvisited then make it visited
      vis[curr.v] = true;
      // add its cost and also store it in edges list
       finalCost += curr.cost;
        edges.add(curr.cost);
     // add all its neigbhours to pq
      for(int i = 0; i<graph.size(); i++){
         Edge e = graph.get(i);
         pq.add(new Pair(e.dest,e.weight));
      }
     }
   }
   System.out.println("Edges that are included to form a MST are\n"+edges);
   System.out.println("Total min cost of MST = "+finalCost);
 }

 public static void main(String[] args) {
    int v = 6;
    ArrayList<Edge> graph = new ArrayList<>();
    // built a graph
    createEdge(graph);
    getMSTCost(graph, v);
 }

}

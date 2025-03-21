import java.util.*;
public class Create_Graph{
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
    graph[0].add(new Edge(0,1,5));
    // from vertex-1
    graph[1].add(new Edge(1,0,5));// b/c the graph is undirected graph
    graph[1].add(new Edge(1,2,1));
    graph[1].add(new Edge(1,3,1));
  //  from vertex-2
    graph[2].add(new Edge(2,1,1));
    graph[2].add(new Edge(2,3,1));
    graph[2].add(new Edge(2,4,2));
  // from vertex-3
    graph[3].add(new Edge(3,2,1));
    graph[3].add(new Edge(3,1,3));
// from vertex-4
   graph[4].add(new Edge(4,2,2));
  }
    public static void main(String[] args) {
       // first we need  how many  no. of vertices req. to store the info. using graph
       Scanner sc = new Scanner(System.in);
       int V = 5;// let say vertices = 5
       // create an array named as graph of type ArrayList<Edge> of size = V
      ArrayList<Edge> [] graph = new ArrayList[V];

// neighbour of 2's vertex 
System.out.println("\nNeigbhours of vertex 2 are :- ");
 for(int j = 0; j<graph[2].size(); j++){
    Edge e = graph[2].get(j);
    System.out.print(e.dest + " ");
    }
 }

}
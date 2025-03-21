import java.util.ArrayList;

public class CycleInDirectedGraph {
    // task :-  check a directed graph is cyclic or not
             // using way-1 Adjacency List i.e ArrayList<Edge>
   static class Edge{
    int src,dest;// src->source,destination & weight 
    Edge(int s,int d){
       this.src = s;
       this.dest = d;
    }
   } 
  static void createGraph(ArrayList<Edge> [] graph){//o(N)
      // convert this null graph with empty i.e initialize with new ArrayList
      for(int i = 0; i<graph.length; i++){ // here i is vertex
        graph[i] = new ArrayList<>();// here [[],[],[],[],[]]
      }
    // from vertex-0
    graph[0].add(new Edge(0, 1));
  //  from vertex-2
    graph[2].add(new Edge(2,1));
    graph[2].add(new Edge(2,3));
 // from vertex-3
  graph[3].add(new Edge(3,4));
  // from vertex-4
  graph[4].add(new Edge(4,2));
  } 

  static boolean isCyclicGraphUtility(ArrayList<Edge> graph[],int curr,boolean vis[],boolean stack[]){
    vis[curr] = true;
    stack[curr] = true;// it means this curr-vertex is also avialable in recurrsion-stack
// now check for its neighbour
  for(int i = 0; i<graph[curr].size(); i++){
     Edge e = graph[curr].get(i);
    if(stack[e.dest]){
        return true;
    }
    if(!vis[e.dest] && isCyclicGraphUtility(graph, e.dest, vis, stack)){
    return true;
    }
  }
  stack[curr] = false;// after backtracking 
    return false;
  }
  static boolean isCyclicGraph(ArrayList<Edge> graph[]){//O(V+E)->T/C & S/C ->O(v),v = total no.of vertices of the graph
    boolean vis[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];
  // apply loop for diff.component of the graph
  for(int i = 0; i<graph.length; i++){
    if(!vis[i]){
     if(isCyclicGraphUtility(graph,i, vis, stack)){
        return true;   
     }
    }
  }
    return false;
  }
 public static void main(String[] args) {
    int  v = 5;
   @SuppressWarnings("unchecked")
   ArrayList<Edge> graph[] = new ArrayList[v];
 // create a directedd graph       
  createGraph(graph);
  if(isCyclicGraph(graph)){
    System.out.println("Yes, This is cyclic directed graph");
  } else{
    System.out.println("No, This is not cyclic directed graph");
  }
 }

    
}

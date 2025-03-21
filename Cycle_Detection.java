import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cycle_Detection {
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
    graph[0].add(new Edge(0, 2, 6));
    graph[0].add(new Edge(0, 3, 4));
    // from vertex-1
    graph[1].add(new Edge(1,0,5));// b/c the graph is undirected graph
   // graph[1].add(new Edge(1,2,1));
  //  from vertex-2
    graph[2].add(new Edge(2,0,1));
   // graph[2].add(new Edge(2,1,2));
  // from vertex-3
   graph[3].add(new Edge(3,0,3));
   graph[3].add(new Edge(3,4,1));
  } 

  static boolean detectCycle(ArrayList<Edge> graph[]){//O()
    boolean vis[] = new boolean[graph.length];
    for(int i = 0; i<graph.length; i++){// it is for , if there exit any graph's component
      if(!vis[i]){
        if(detectCycleUtil(graph,vis,i,-1)){// main kaam yeh karega jisme (graph,visitRecord,vertex,its-Parent)
          // corner-case i.e if cycle exit in any part or component of a graph then return true otherwise false
            return true;   
       }
    }
  }
    return false;
   
}
static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int par){// here curr-current vertex and par->parent of curr
  // apply normal dfs
    vis[curr] = true;
    // check for its neigbhours
  for(int i = 0; i<graph[curr].size(); i++){
     Edge e = graph[curr].get(i);
     // case-3 --> e.dest is a neigbhour of currVertex
    if(!vis[e.dest]){
        // apply normal dfs
        if(detectCycleUtil(graph, vis, e.dest, curr)){// curr->its-neigbhour i.e e.dest and par--> curr
        // yes cycle exit so return true
        return true;
        }

    } 
    // case-1  curr'svertex's neigbhor has been visited but it is not a parent of it
    else if(vis[e.dest] && e.dest != par){
        return true;
    }
    // case-2 --> do nothing i.e continue
  }
    return false;
}

public static void main(String[] args) {
    int v = 5;
    @SuppressWarnings("unchecked")
 ArrayList<Edge> graph[] = new ArrayList[v];
 Scanner sc = new Scanner(System.in);
  // graph has been created 
 createGraph(graph);
 if(detectCycle(graph)){
    System.out.println("Yes,there exit a cycle in the graph");
 } else{
    System.out.println("No,there not exit any cycle in the graph");
 }
}


}

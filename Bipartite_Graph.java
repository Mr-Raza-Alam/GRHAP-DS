import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph {
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
    graph[0].add(new Edge(0, 3, 6));
    // from vertex-1
    graph[1].add(new Edge(1,0,5));// b/c the graph is undirected graph
    graph[1].add(new Edge(1,2,1));
  //  from vertex-2
    graph[2].add(new Edge(2,1,1));
    graph[2].add(new Edge(2,3,2));
  // from vertex-3
   graph[3].add(new Edge(3,0,3));
   graph[3].add(new Edge(3,2,1));
  }     
  static boolean bipartiteGraph(ArrayList<Edge> graph[],int curr){
    int color[] = new int[graph.length];
    color[curr] = 0; // 0 -> yellow color
    for(int i = 1 ;i<graph.length; i++){// assign -1 i.e no-color
     if(i != curr) color[i] = -1;
   } 
   for(int j = 0; j<graph.length; j++){
      if(bipartiteUtily(graph,color,curr)){
         return true;
      }
   }
    return false;
  }
  static boolean bipartiteUtily(ArrayList<Edge> graph[],int color[],int curr){// indirectly it is dfs with some modification
      // check for its neigbhor 
      for(int i = 0; i<graph[curr].size(); i++) {
          Edge e = graph[curr].get(i);
        // case-2
        if(color[curr] == color[e.dest]){
            return false;
        }
          // case-1 if neigbhor has no-color then assign apposite colr
        if(color[e.dest] == -1){
          int nxtColor = color[curr] == 0 ? 1 : 0;// it means if curr-color is Yellow then assign Blue to its neigbhor else assign Yellow to it
          color[e.dest] = nxtColor;
          bipartiteUtily(graph, color, e.dest);
        }      
      }
    return true;
  }
  // using BFS with coloring concept of vertices
 static boolean isBipartiteGraph(ArrayList<Edge> graph[]){
    // apply color concept
    int col[] = new int[graph.length];
  // first assign no-color(i.e -1) to all the vertices of graph
  for(int i = 0; i<col.length; i++){
     col[i] = -1;
  }
  // now apply actual BFS with some modification 
 Queue<Integer> q = new LinkedList<>();
  for(int i = 0; i<graph.length; i++){// here loop is apply for diff. part/component of the graph if exit else come out
    // here i is vertex of the graph
    if(col[i] == -1){// BFS apply 
     col[i] = 0; // initialize by assign a color let yellow(i.e 0)
     q.add(i);// add the curr-vertex add to the queue for bfs
     while (!q.isEmpty()){
       int curr = q.remove();
      // check for its neighbours
     for(int j = 0; j<graph[curr].size(); j++){
        Edge e = graph[curr].get(j);
    // case-1 if the neigbhour is no-color then color it
      if(col[e.dest] == -1){
         int nxtCol = col[curr] == 0 ? 1 : 0;
         col[e.dest] = nxtCol;
         q.add(e.dest);
      } 
      // case-3 if color of neigbhour is similar as in the curr vertex then return false
      else if(col[e.dest] == col[curr]){
         return false;
        }
       }
     }
    }
  }
  return true;
 }

 public static void main(String[] args) {
   // built a graph
   int v = 4;
   @SuppressWarnings("unchecked")
   ArrayList<Edge> graph[] = new ArrayList[v];
   createGraph(graph);
   boolean res = isBipartiteGraph(graph);
   System.out.println(res);
   if(bipartiteGraph(graph, 0)){
     System.out.println("Yes,there exit a bipartite graph of the given graph");
   } else{
    System.out.println("No,there is not exit a bipartite graph of the given graph");
   }
 }
}
   //  54  if(color[curr] == 0){
        //     color[e.dest] = 1;
        //     bipartiteUtily(graph, color, e.dest);
        //    } else{
        //     color[e.dest] = 0;
        //     bipartiteUtily(graph, color, e.dest);
        //    }
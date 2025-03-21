import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection_BFS {
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
    
    static boolean isCycle_BFS(ArrayList<Edge> graph[],int src){
   boolean vis[] = new boolean[graph.length];
   Queue<Integer> q = new LinkedList<>();
   q.add(src);
   vis[src] = true;

   while (!q.isEmpty()){
     int curr = q.remove();
     // work on its all neigbhours
     for(int i= 0; i<graph[curr].size(); i++){
       // extract all edge or connection from curr.vertex
      Edge e = graph[curr].get(i);
      if(vis[e.dest]){
        return true;// cycle exit 
      } else{
        vis[e.dest] = true;
        q.add(e.dest);
      }
     }
   }
  
  return false;// no cycle
}

}

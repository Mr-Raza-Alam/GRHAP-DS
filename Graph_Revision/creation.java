package Graph_Revision;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class creation {

 public static class Edge{
    int src,dest,weight;
   public  Edge(int s,int d,int wt){
     this.src = s;
     this.dest = d ;
     this.weight = wt;
    }
 }

 // basic-level BFS  -- O(V+E),if graph is created using adjacency list
 static void bfs(ArrayList<Edge>graph[],int n, int sp){// sp - starting point
   // declare a visited array for ticked mark for each vertex traversed 
   boolean vis[] = new boolean[n];
 // firstly mark false i.e. no vertex is visited now
   Queue<Integer> q = new LinkedList<>();
   q.add(sp);
   // start bfs game 
   while(!q.isEmpty()){
    int curr = q.remove();
     if(!vis[curr]){
     // w-1 -- mark as visited
     vis[curr] = true;
     // w-2 -- print the curr vertex
     System.out.print(curr+" ");
     // w-3 -- add curr's all neigbhours 
      for(int i = 0; i<graph[curr].size(); i++){
          Edge e = graph[curr].get(i);
          q.add(e.dest);
       }
     }
   }
    
 }
     
  public static void main(String agr[]){
    int n = 5;
    @SuppressWarnings("unchecked")
     ArrayList<Edge> graph[] = new ArrayList[n]; // null ->empty Al
    // before inserting edges for each vertex of the graph, we have to initialize it with an empty AL
    for(int i = 0; i<n; i++){
        graph[i] = new ArrayList<>();// create an AL 
    }
     // oth - vertex
      graph[0].add(new Edge(0, 1,5));
    // 1th- vertex 
    graph[1].add(new Edge(1, 0,5));
    graph[1].add(new Edge(1, 2,1));
    graph[1].add(new Edge(1, 3,3));
    // 2th- vertex 
    graph[2].add(new Edge(2, 1,1));
    graph[2].add(new Edge(2, 3,1));
    graph[2].add(new Edge(2, 4,2));
    // 3th- vertex 
    graph[3].add(new Edge(3, 1,3));
    graph[3].add(new Edge(3, 2,1));
    // 4th- vertex
    graph[4].add(new Edge(4,2,2));

     // Traversal of graph --> a) BFS, b) DFS
     // bfs
     //System.out.println("Via BFS Vertices of the graph are :");
     //bfs(graph,n,0);
    // dfs
    System.out.println("Via DFS Vertices of the graph are :");
    dfs(graph,0,new boolean[n]);
    }
 // basic - level
 // dfs  O(n), n = V+E
  static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[]){
     // w-1
    vis[curr] = true;
    // w-2
    System.out.println(curr);
    // w-3
    for(int i = 0; i<graph[curr].size(); i++){
     Edge e = graph[curr].get(i);
     // now visited unvisited neighbours of curr recursively 
     // neighbour of curr = e.dest
    if(!vis[e.dest]){
       dfs(graph,e.dest,vis);
      }
    }
  }

}

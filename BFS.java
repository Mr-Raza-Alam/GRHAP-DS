import java.util.*;

public class BFS {
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
    graph[1].add(new Edge(1,3,1));
  //  from vertex-2
    graph[2].add(new Edge(2,0,1));
    graph[2].add(new Edge(2,4,2));
  // from vertex-3
   graph[3].add(new Edge(3,1,3));
   graph[3].add(new Edge(3,5,1));
   graph[3].add(new Edge(3,4,1));
// from vertex-4
   graph[4].add(new Edge(4,2,2));
   graph[4].add(new Edge(4,3,3));
   graph[4].add(new Edge(4,5,9));
   // from vertex-5
   graph[5].add(new Edge(5,3,2));
   graph[5].add(new Edge(5,4,0));
   graph[5].add(new Edge(5,6,2));
// from vertex-6
  graph[6].add(new Edge(6,5,2));
  } 
  // here now we are going to modify some logic in the bfs Alogrithm for connected component of a graph
  static void bfsUtil(ArrayList<Edge> graph[],int stPoint,boolean visit []){
    Queue<Integer> q = new LinkedList<>();
    q.add(stPoint);// start with a source point
    while (!q.isEmpty()){  
      int curr = q.remove(); // step-1 -> to extract curr vertex 
      if(!visit[curr]){
         System.out.print(curr + " ");// print the curr-vertex
         visit[curr] = true;// mark as true on visited vertex
         for(int j = 0; j<graph[curr].size(); j++){// add all neighbours of curr-vertex
             Edge e = graph[curr].get(j);
            q.add(e.dest);
         }
      }
    }
  }
  static void bfs(ArrayList<Edge> graph[],int st){//O(n)
    boolean visit [] = new boolean[graph.length];
     for(int i = 0; i<graph.length; i++){
        if(!visit[i]){
           bfsUtil(graph, st, visit);
        }
     }
  }
  @SuppressWarnings("uncecked")
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int V = 7;// let say vertices = 5
      @SuppressWarnings("unchecked")
      ArrayList<Edge> [] graph = new ArrayList[V];
      createGraph(graph);
      System.out.print("Enter the starting-point to traverse the graph = ");
      int st = sc.nextInt();
      System.out.println("The vertices of the graph are :-");
      bfs(graph, st);

 }
}

import java.util.*;
public class Topological_Sort {
     // using DFS with Stack & using BFS,Kahn's Algorithm
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
       // from vertex-2
        graph[2].add(new Edge(2, 3));
       //  from vertex-3
        graph[3].add(new Edge(3,1));
      // from vertex-4
       graph[4].add(new Edge(4,0));
       graph[4].add(new Edge(4,1));
       // from vertex-5
       graph[5].add(new Edge(5,0)); 
       graph[5].add(new Edge(5,2)); 
      } 
      static void topSortUtility(ArrayList<Edge> graph[],boolean vis[],Stack<Integer> s,int curr){
          vis[curr]   = true;
         for(int i = 0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
              topSortUtility(graph, vis, s, e.dest);
            }
         }
         s.push(curr);
      }
    
      static void topSort(ArrayList<Edge> graph[]){// T/C - O(V+E) & S/C - O(V)
         boolean vis[] = new boolean[graph.length];
         Stack<Integer> stack = new Stack<>();
         // apply a loop for all diffe. component of graph
         for(int i = 0; i<graph.length; i++){// here i is a vertex of the graph
           if(!vis[i]){// if the vertex is unvisited then apply simple dfs
              topSortUtility(graph,vis,stack,i);// modified dfs
           }
         }
       while (!stack.isEmpty()){
          System.out.print(stack.pop()+" ");
       }
      }
    // using Kahn's Algorithm (based on indegree or out-degree) here we select in-degree's concept
    static void calIndegree(ArrayList<Edge> graph[] ,int indeg[]){
      for(int i = 0; i<indeg.length; i++){// i is vertex of the DAG
         for(int j = 0; j<graph[i].size(); j++){// for calc. edge b/w i-->j
            Edge e = graph[i].get(j);
              indeg[e.dest]++;//e.dest is incoming edge for neigbhour of curr's vertex
         }        
      }
   }  
    
   static void topSortBFS(ArrayList<Edge> graph[]){
    // create a indeg[] to store the indegree of all vertices of the graph
     int indeg[] = new int[graph.length];
     // now call calIndegree() and store all indegree of the vertices of the graph
     calIndegree(graph, indeg);
     Queue<Integer> q = new LinkedList<>();
    // insert all vertices having 0 in-degree
    for(int i= 0; i<indeg.length; i++){
       if(indeg[i] == 0){
          q.add(i);
       }
    }
   // now apply BFS
   while (!q.isEmpty()){
    int curr = q.remove();
    System.out.print(curr + " ");// b/c the vertices having 0 in-degree i.e will be topological element
    // check for its neigbhours
    for(int i = 0; i<graph[curr].size(); i++){
      Edge e = graph[curr].get(i);
      indeg[e.dest]--;
      if(indeg[e.dest] == 0){
         q.add(e.dest);
      }
     }
   }
   }
      public static void main(String[] args) {
        int v = 6 ;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        // create a DAG
        createGraph(graph);
        System.out.println("After topological sort,we have");
        topSortBFS(graph);
      }
    }    
       // from vertex-0
    //     graph[0].add(new Edge(0, 1));
    //   //  from vertex-2
    //     graph[2].add(new Edge(2,1));
    //     graph[2].add(new Edge(2,3));
    //  // from vertex-3
    //   graph[3].add(new Edge(3,4));
    //   // from vertex-4
    //   graph[4].add(new Edge(4,2));


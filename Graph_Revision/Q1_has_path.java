package Graph_Revision;

import java.util.ArrayList;

public class Q1_has_path {

  public static class Edge{
     int src,dest;
     public  Edge(int s,int d){
      this.src = s;
      this.dest = d ;
     }
   }

  public static void main(String[] args) {
    int n = 7;
        @SuppressWarnings("unchecked")
     ArrayList<Edge> graph[] = new ArrayList[n];
     for(int i = 0; i<n; i++){
        graph[i] = new ArrayList<>();// create an AL
    }
         // oth - vertex
         graph[0].add(new Edge(0, 1));
         graph[0].add(new Edge(0, 2));
    
         // 1th- vertex 
         graph[1].add(new Edge(1, 3));
         // 2th- vertex 
         graph[2].add(new Edge(2, 4));
         // 3th- vertex 
         graph[3].add(new Edge(3, 1));
         graph[3].add(new Edge(3, 4));
         graph[3].add(new Edge(3, 5));
         // 4th- vertex
         graph[4].add(new Edge(4,2));
         graph[4].add(new Edge(4,3));
         graph[4].add(new Edge(4,5));
         // 5th- vertex
         graph[5].add(new Edge(5,3));
         graph[5].add(new Edge(5,4));
         graph[5].add(new Edge(5,6));
         // 6th- vertex
         graph[6].add(new Edge(6,5));
  boolean res = hasPath(graph,0,5,new boolean[n]);
  System.out.println("Value of has-path result : "+res);
  if(res){
    System.out.println("Yes, it has a path b/w src = "+0+" dest = "+5);
  }else{
    System.out.println("No, it has no any path b/w src = "+0+" dest = "+5);
  }
  }
 // has path
  static boolean hasPath(ArrayList<Edge> graph[],int curr,int dest,boolean vis[]){
   // edged case, when while traversing via dfs ,if we got destination then it is true . so return true 
   //here curr means src
   if(curr == dest){
    return true;
   }
   // w-1+w-2
   vis[curr] = true;
   //w-3
   for(int i =0; i<graph[curr].size(); i++){
    Edge e = graph[curr].get(i);
     if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
 // here hasPath(graph,neighbour,dest,vis) keep record of path  exit or not
        return true;
     }
   }    
   return false;
  }


}

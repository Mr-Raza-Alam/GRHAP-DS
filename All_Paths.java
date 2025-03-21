import java.util.ArrayList;
import java.util.Scanner;
public class All_Paths {
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
    graph[0].add(new Edge(0, 3));
  //  from vertex-2
    graph[2].add(new Edge(2,3));
  // from vertex-3
   graph[3].add(new Edge(3,1));
// from vertex-4
   //graph[4].add(new Edge(4,0));
   graph[4].add(new Edge(4,1));
   // from vertex-5
   graph[5].add(new Edge(5,0));
   graph[5].add(new Edge(5,2));
   graph[5].add(new Edge(5,4));
  } 

 static void printAllPath(ArrayList<Edge> graph[],int src,int target,ArrayList<Integer> path){//O(V^2)
    if(src == target){// base-case
      path.add(src);
     System.out.println(path+"\n");
     path.removeLast();
     return;
    }
  // check for src's neigbhour
  for(int i = 0; i<graph[src].size(); i++){
      path.add(src);
    // extract edge 
    Edge e = graph[src].get(i);
    printAllPath(graph, e.dest, target,path);
    path.removeLast();
   }
  }
 public static void main(String[] args) {
   int v = 6;
   @SuppressWarnings("unchecked")
   ArrayList<Edge> graph[] = new ArrayList[v]; 
   ArrayList<Integer> path = new ArrayList<>(); 
   Scanner sc = new Scanner(System.in);
   // create a DAG
   createGraph(graph);
   System.out.print("Enter the source-point = ");
   int src = sc.nextInt();
   System.out.print("Enter the target-point = ");
   int tar = sc.nextInt();
   System.out.println("Total path from src = "+src + " to destination = "+tar+" are :- ");
   printAllPath(graph, src, tar,path);
 }
    
}

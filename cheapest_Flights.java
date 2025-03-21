import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public  class cheapest_Flights {
// Chepeast flights within K stops
static class Edge{
   int src,dest,wt;
   Edge(int s,int d,int cost){
      this.src = s;
      this.dest = d;
      this.wt = cost;
   }
}
 static class Info{
   int vertex,cost,stop;// stop means stoppage
    Info(int v,int cost,int stop){
      this.vertex = v;
      this.cost = cost;
      this.stop = stop;
    }
 }
  static void createGraph(int flights[][],ArrayList<Edge> graph[]){
     // initialize with a empty arraylist 
    for(int i = 0; i<graph.length; i++){
        graph[i] = new ArrayList<>();
     }
   // now tranfer each edge to the graph or create a grpah
   for(int i = 0; i<flights.length; i++){
       int u = flights[i][0];
       int v = flights[i][1];
       int wt = flights[i][2];
       graph[u].add(new Edge(u, v, wt));
   }
  }

 public static int getCheapestFlight(int flights[][],int src,int tar,int k,int n){
     // create graph
     @SuppressWarnings("unchecked")
    ArrayList<Edge> graph[] = new ArrayList[n];
    createGraph(flights, graph);
    int dist[] = new int[flights.length];
   //  initailize dist[] from 1 to dist.length with +infinity that means we don't know how far and cost the next vertex
   for(int i = 0;i<dist.length; i++){
         if(i != src){
        dist[i] = Integer.MAX_VALUE;
       }
    } 
    Queue<Info> q = new LinkedList<>();
    q.add(new Info(src, 0, 0));// src-->src jane mein cost = 0, stop = 0
     while(!q.isEmpty()){
       Info curr = q.remove();
       if(curr.stop > k) {
         break;
       }
      // check for its all neigbhours
      for(int i = 0; i<graph[curr.vertex].size(); i++){
         // extract all edges from curr.vertex 
         Edge e = graph[curr.vertex] .get(i);
         int v = e.dest;
         int wt = e.wt;
        // now apply Dijkstras's rule
        if(curr.cost + wt <dist[v] && curr.stop<=k){
            // perform relaxtion steps
           dist[v] = curr.cost + wt;
           q.add(new Info(v,dist[v], curr.stop +1));
        }
      }
     }
   if(dist[tar] == Integer.MAX_VALUE){
    return -1;
   }  
    return dist[tar];
 }


  public static void main(String[] args) {
    int n = 5;// n = no. of vertex or in real world no.of diff. location
    int flights[][] = {{0,1,100},{1,3,40},{0,2,10},{2,4,20},{4,3,5}};
    int src = 0,dest = 3,k = 2;
    int res = getCheapestFlight(flights, src, dest, k,n);
    System.out.println("The cheapest flights from "+src+" to "+dest +" = "+res);
  }
    
}
// static int getCheapestFlight(int flights[][],int src,int dest,int k){ by me
    //      // create an dist array to track the  path (means to reach from one vertex to another via  path)
    //     int dist[] = new int[flights.length];
    //     // initailize dist[] from 1 to dist.length with +infinity that means we don't know how far and cost the next vertex
    //     for(int i = 1;i<dist.length; i++){
    //          dist[i] = Integer.MAX_VALUE;
    //     }
    //     int stoppage = 0,ans = 0;
    //     Queue<Info> q = new LinkedList<>();
    //     q.add(new Info(src,0, stoppage));// src-->src jane mein cost = 0, stop = 0
    
    //     while(!q.isEmpty()){
    //         Info curr = q.remove();
    //         if(stoppage -1 >k){
    //             return -1;
    //           }
    //        // go to its all neigbhour
    //        for(int i =0; i<flights.length;i++){
    //           int neigb = flights[i][1];// neigbhour
    //           int cost = flights[i][2];// its cost 
    //           // now here is dijikstras's rule
    //   // here dist[curr.vertex] != Integer.MAX_VALUE && dist[curr.vertex]  is replace by curr.cost b/c our work only curr.cost
    //         if(curr.cost + cost < dist[neigb] && stoppage <= k){// curr as u & neigb as v cost as wt(u,v)
    //              // perform relaxtion process
    //              dist[neigb] = dist[curr.vertex] + cost;
    //               ans +=cost;
    //               stoppage++;
    //               q.add(new Info(neigb, dist[neigb], stoppage));
    //           }
          
    //        }
    //      }
      
    //     return ans;// ans means cheapest flight to reach from src to dest via k stoppage
    //   }
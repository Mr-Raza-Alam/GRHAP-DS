import java.util.ArrayList;
import java.util.PriorityQueue;
public class Connecting_Citites {
  // task :- to find out the minimum cost to reach from a city as src to all cities provided
 // done by didi
  static class Edge implements Comparable<Edge>{// we store only edge rather adjacency arraylist
    int dest,cost;// here src is not included b/c we know src will be i , we just work with its neigbhour associated with cost
    Edge(int d,int c){
        this.dest = d;
        this.cost = c;
    }
  @Override 
   public int compareTo(Edge e){
     return (this.cost - e.cost);// swapp occurs when (this.cost - e.cost)>0,otherwise no swapping will occurs i.e sorting based on cost
   }
  }
 
  static int connectCities(int cities[][]){//(n*k)-->O(n)
    ArrayList<Integer> path = new ArrayList<>();
    boolean vis[] = new boolean[cities.length];
    int finalCost = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(0,0));// initially array start with 0 therefore 0--->0 ,cost = 0
    while (!pq.isEmpty()){// O(k), k = total no. of element comes into the PQ
      Edge curr = pq.remove();
      if(!vis[curr.dest]){
     // loop-work-1 make sure to mark as visited once a city is visited
     vis[curr.dest] = true;
    // loop-work-2  to keep the record of path via which we go to visit the city and cost to finalCost 
     path.add(curr.cost);
     finalCost += curr.cost;  
   // loop-work-3 also add curr.dest 's neigbhours 
    for(int i = 0; i<cities[curr.dest].length; i++){// O(n), n = total no. of dest i.e v
       if(cities[curr.dest][i] != 0){// b/c  cities[curr.dest][i] == 0 means there is no any path from u--->v
        // curr is as u& i is as v  cities[curr.dest][i] is as cost/weight from u-->v
         pq.add(new Edge(i,cities[curr.dest][i]));
         }
       }   
     }
    }
  System.out.println("The path we travel to visit all the cities are : "+path);
    return finalCost;
  }

 public static void main(String[] args) {
    int cities[][] = {{0,5,7,9,6},{5,0,3,0,8},{7,3,0,0,0},{9,0,0,0,1},{6,8,0,1,0}};
     int ans = connectCities(cities);
     System.out.println("Minimum cost required to visit all the cities = "+ans);
    //int src = 0;
    //  int ans = getMinCostCities(cities, src);
    // System.out.println("Minimum cost required to visit all citites from src( "+src+" ) = "+ans);
 }
    
}
 // done by me
//  // this Edge class for creating a graph 
//  static class Edge{
//     int src,dest,weight;
//     Edge(int s,int dst,int wt){
//       this.src = s;
//       this.dest = dst;
//       this.weight = wt;
//     }
//  }
//  // this Pair class  for PQ,PQ will store the sorted Pair based on cost 
//  static class Pair implements Comparable<Pair>{
//     int vertex,cost;
//     Pair(int v,int c){
//       this.vertex = v;
//       this.cost  = c;
//     }
//   @Override
//   public int compareTo(Pair p2){
//       return (this.cost - p2.cost);// swapp occurs when (this.cost - p2.cost)>0,otherwise no swapping will occurs i.e sorting based on cost 
//   }
//  }

//  static void createGraph(int cities[][],ArrayList<Edge> grpah[]){// O(n*m)
//     // step-1 :- initialize graph with empty AL 
//   for(int i = 0; i<grpah.length; i++){// O(n),n is actually all cities/vertex/length of graph/cities
//     grpah[i] = new ArrayList<>();
//   }
//  // step-2 :- fill the graph's empty vertex with its all neigbhour alongwith associated weight(i.e cost)
//   for(int i = 0; i<cities.length; i++){// O(n*m),n = no.of all rows,m = no. of all coloumns present in the 2-D array named as cities[][]
//     for(int j = 0; j<cities[i].length; j++){
//      // here i---->j act as u--->v as in graph
//      if(cities[i][j] !=0){// b/c  cities[i][j] == 0 means there is no any path from i--->j
//       grpah[i].add(new Edge(i, j, cities[i][j]));
//      }
//     }
//   }
//  }

//  static int getMinCostCities(int cities[][],int src){// O(n*m + n*k)
//     int n = cities.length;
//     @SuppressWarnings("unchecked")
//     ArrayList<Edge> graph[] = new ArrayList[n];
//     // step-1 :- create a graph ,using cities information
//     createGraph(cities, graph);
//   // step-2 :- work to implement Prim's Algorithm to solve this problem
//     ArrayList<Integer> minCost = new ArrayList<>();// to keep the record of min path to travel all the cities from src
//     boolean vis[] = new boolean[n];// to make sure visited to unvisited city after visiting them
//     int cost = 0;// to add the minCost
//   PriorityQueue<Pair> pq = new PriorityQueue<>();//  to keep list of next city to visit
//    pq.add(new Pair(src,0));
  
//    while(!pq.isEmpty()){// O(n*k)
//     Pair curr = pq.remove();
//     if(!vis[curr.vertex]){
//      // loop-work-1
//      vis[curr.vertex] = true;
//     // loop-work-2
//     minCost.add(curr.cost);
//      cost += curr.cost;
//     // loop-work-3
//      for(int i = 0; i<graph[curr.vertex].size();  i++){// O(k)
//         Edge e = graph[curr.vertex].get(i);
//         int v = e.dest;
//         int wt = e.weight;
//         pq.add(new Pair(v, wt));
//      }
//     }
//    }
//    System.out.println("The path selected to visit all the citites from src ( "+src+" ) are :-"+minCost);
//     return cost;
//  }
 
import java.util.ArrayList;

public class Kruskals_Algorithm {
// Task :- This algorithm is also for finding MST from the given graph
// so, for this we first store all the edges in AL based on cost/weigth sorting order and then perform find & union for forming a MST

static class Edge implements Comparable<Edge>{
    int src,dest,weigth;
    Edge(int s,int dst,int wt){
      this.src = s;
      this.dest = dst;
      this.weigth = wt;
    }
 
    @Override
    public int compareTo(Edge e){
         return(this.weigth - e.weigth);
    }
}

 static int n = 4;// here it is no. of vertices
 static int par[] = new int[n];
 static int rank[] = new int[n];
 
 static void initailize(){
  for(int i = 0; i<n; i++){
    par[i] = i;// initially each index has its own leader
  }
 }

 static int find(int x){// O(4k)-->O(1)
    if(x == par[x]){
        return x;
    }
  return par[x] = find(x);// here we use edge comparasion concept
 }

 static void union(int a,int b){// O(4k)-->O(1)
    int parA = find(a);
    int parB =  find(b);

    if(rank[parA] == rank[parB]){
        par[parB] = parA;
        rank[parA]++;
    }else if(rank[parA] < rank[parB]){
        par[parA] = parB;
    } else{
        par[parB] = parA;
    }
 }


static void createGraph(int arr[][],ArrayList<Edge> edges){
   for(int i = 0; i<arr.length; i++){
     int u = arr[i][0];
     int v = arr[i][1];
     int wt = arr[i][2];
    edges.add(new Edge(u, v, wt));
   }
}

static void kruskalMST(int arr[][]){ //O(v+e)
    initailize();//O(v) v = no. of vertices in the graph 
    // step-1 to store all min. edges to the AL
   ArrayList<Edge> edges = new ArrayList<>();// SC -> o(e), e = no. of total edges
   ArrayList<Integer> edgeMST = new ArrayList<>(); // SC -> O(k), k = total no.of edges will have include to form a MST
   createGraph(arr,edges);// O(e)
   int count = 0,minCost = 0;
  // step-2 :- apply a loop upto V-1, and perform find and union
   for(int i = 0; count<n-1; i++){// O(v)
     Edge e = edges.get(i);
     // work-1 :- 
    int parA = find(e.src);// u = e.src  in O(1)
    int parB = find(e.dest);// v = e.src in O(1)
    if(parA != parB){// means we perform union(u,v) when it doesn't form any cycle(i.e parA != parB)
      union(e.src,e.dest);// O(1)
       minCost += e.weigth; 
       edgeMST.add(e.weigth);
       count++;
    }
   }
   System.out.println("The edges participate to forming a MST are :- \n"+edgeMST);
   System.out.println("Min. cost required to form a MST = "+minCost);
}

public static void main(String[] args) {
  int grpah[][] = {{0,1,10},{0,2,15},{0,3,30},{1,2,40},{2,3,50}};
  kruskalMST(grpah);
}
    
}

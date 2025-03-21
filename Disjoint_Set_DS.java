public class Disjoint_Set_DS {
  static int n = 7;//  
  static int par[] = new int[n];
  static int rank[] = new int[n];

  static void initialize(){
     for(int i = 0; i<n; i++){
        par[i] = i;// each digit is itself a parent/leader
     }
  }
  
static int find(int x){// it return final leader 
    if(x == par[x]){// final leader of x is par[x] itself
        return x;
    }
 return par[x] = find(par[x]);
}

static void union(int a,int b){//
   int parA = find(a);
   int parB = find(b);
 // union occurs based on rank of seta and setb
   if(rank[parA] == rank[parB]){
    // then anyone can become a leader
    par[parB] = parA;// here parB become the leader
    rank[parA]++;
   }
 else if(rank[parA] < rank[parB]){
    // then obiously parA become the leader
  par[parA] = parB;
 } else{
  // then parB become the leader
 par[parB] = parA;
 }
}
 
 public static void main(String[] args) {
    initialize();
    System.out.println(1 +" is present in Set-"+find(1));
    union(1,3);
   System.out.println(3+" is present in Set-"+find(3));
   union(2,4);
   union(3,6);
   union(1,4);
   System.out.println(3+" is present in Set-"+find(3));
   System.out.println(4+" is present in Set-"+find(4));
   union(1,5);
   System.out.println(3+" is present in Set-"+find(3));
   
 }

}

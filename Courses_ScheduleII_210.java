import java.util.*;

public class Courses_ScheduleII_210 {

     public static void calInDegree(int [][]graph,int indeg[]){
       for(int i = 0; i<graph.length; i++){
         int Vidx = graph[i][1];
           indeg[Vidx]++;
       }
     }
    public static void findOrder(int numCourses, int[][] prerequisites){// T/C && S/c == O(n)
       int ans[] = new int[numCourses];
         int indeg[] = new int[numCourses];
           calInDegree(prerequisites,indeg);//O(n)
          Queue<Integer> dq = new LinkedList<>();
          for(int i = 0; i<indeg.length; i++){
             if(indeg[i] == 0){
              dq.add(i);
             }
          }
          // now apply actual BFS with some modification
          int j = 0;
         while(!dq.isEmpty()){//O(n)
            int curr = dq.remove();
           ans[j] = curr;
            for(int i = 0; i<indeg.length; i++){
               indeg[i]--;
              if(indeg[i] == 0){
                 dq.add(i);
              }      
            }
            j++;          
         }
// now reverse arr using 2-pointer approcah
     j = numCourses -1; 
     int st = 0;
     while(st <j){ //O(n)
       // swapp
       int t = ans[j];
       ans[j] = ans[st];
       ans[st] = t;
      st++;
      j--;
     }
 // now print 
 for(int i = 0; i<ans.length; i++){//O(n)
   System.out.print(ans[i]+" ");
 }
     }
    
     public static void main(String[] args) {
        int v = 4;
        int graph[][] = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println("The correct order of courses are :- ");
        findOrder(v,graph);
 }
    
}

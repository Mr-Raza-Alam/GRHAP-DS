public class Assingment3 {
 // taske is to find minimum time required to rot all the orange
    static int time = 0; 
  static boolean isRottenOrange(int box[][]){// O(m*n)
    int unRot = 2;
    for(int i = 0; i<box.length; i++){
      for(int j = 0; j<box[i].length; j++){
        if(box[i][j] == 2){
          adjacentCell(box,i,j);//O(n)
           break;
        }else if(box[i][j] == 1 && box[i][j+1] == 0){// this is a case when an orange can be safe
           unRot = 1;
        }
    }
   }
    if(unRot == 1) {
      return false;
    }
    return true;
  }
 public static void main(String[] args) {
   int box[][] = {{2,1,0,2,1},{0,0,1,2,1},{2,0,0,2,1}};
 if(isRottenOrange(box)){
    System.out.println("Yes all orange has been rotten,time taken by the function = "+time+"milisec");    
 }else{
    System.out.println("No all orange has not been rotten,time taken by the function = "+time+"milisec");    
 }
  System.out.println("After rotting the fresh orange.");
  for(int i= 0;i<box.length; i++){
    for(int j = 0; j<box[0].length; j++){
        System.out.print(box[i][j]+" ");
    }
    System.out.println();
  }
 }
 static void adjacentCell(int arr[][],int row,int col){
    int n = arr[row].length;
    while(col <n){
    // left Adjacent cell
    if(col-1>= 0 && arr[row][col-1] == 1){
      arr[row][col-1] = 2;
      time++;
    }
    // right Adjacent cell
    if(col+1 <n && arr[row][col+1] == 1){
        arr[row][col+1] = 2;
        time++;
      }
       col++;
     }
 }
}
  
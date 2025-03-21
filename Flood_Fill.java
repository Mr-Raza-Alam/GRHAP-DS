import java.util.Scanner;

public class Flood_Fill {
// leedtcode-problem no. - 733(easy)

static void helper(int image[][],int sr,int sc,int color,boolean vis[][],int O_color){
    // base-1:- vis[sr][sc] == true means that cell already has been visited
  // base-2 :- image[sr][sc] != Original color , then it means it empty leave it as it is
  // base-case-3  :- is given i.e if sr,sc < 0 && sr,sc >image.length then return
 if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length||vis[sr][sc]||image[sr][sc] != O_color){
    return;
 }
  // change the color of image[sr][sc] cell 
   image[sr][sc] = color;
   // mark as visited to that cell
   vis[sr][sc] = true;    
    // call for left cell
    helper(image, sr, sc-1, color, vis, O_color);
    // call for right cell
    helper(image, sr, sc+1, color, vis, O_color);
    // call for up cell
    helper(image, sr-1, sc, color, vis, O_color);
    // call for down cell
    helper(image, sr+1, sc, color, vis, O_color);
 
}
// T/C -> O(m*n)
static void floodFill(int image[][],int sr,int sc,int color){// if type is int[][] then return image 
   boolean vis[][] = new boolean[image.length][image[0].length];
   helper(image,sr,sc,color,vis,image[sr][sc]);// image[sr][sc] = original color O(m*n)
   return;
}

public static void main(String[] args) {
    int image[][] = {{0,0,0},{0,0,0}};
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter start row : ");
    int sr = sc.nextInt();
    System.out.print("Enter start coloumn : ");
    int s_c = sc.nextInt();
    System.out.print("Enter the desire color to fill : ");
    int color = sc.nextInt();
    floodFill(image,sr,s_c,color);
    System.out.println("After flood fill process,image-board have ");
    for(int i =0 ; i<image.length; i++){
        for(int j = 0; j<image[i].length; j++){
            System.out.print(image[i][j] + " ");
        }
     System.out.println();
    }
}

}

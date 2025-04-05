//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Cell{
    int i,j,time;
    
    Cell(int i,int j,int time){
        this.i=i;
        this.j=j;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        Queue<Cell> queue=new LinkedList<>(); 
        int n=mat.length;
        int m=mat[0].length;
        
        int visitedArray[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2){
                    queue.add(new Cell(i,j,0));
                    visitedArray[i][j]=2;
                }else{
                    visitedArray[i][j]=0;
                }
            }
        }
        
        
        int time=0;
        int drow[]={-1,0,+1,0};
        int dcol[]={0,+1,0,-1};
        while(!queue.isEmpty()){
            Cell current=queue.poll();
            // access this bu current.i,current.j current.time
            int row=current.i;
            int col=current.j;
            time=Math.max(time,current.time);
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1 &&
                visitedArray[nrow][ncol]!=2){
                    queue.add(new Cell(nrow,ncol,current.time+1));
                    visitedArray[nrow][ncol]=2;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1 && visitedArray[i][j]!=2){
                    return -1;
                }
            }
        }
        return time;
    }
}
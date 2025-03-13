//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=wt.length;
        int dp[][]=new int[n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=-1;
            }
        }
        return ks(W,val,wt,wt.length-1,dp);
    }
    static int ks(int w,int val[],int wt[],int index,int dp[][]){
        
        
        //Base Condition
        if(index<0) return 0;
        if(dp[index][w]!=-1) return dp[index][w];
        int take=0;
        int notake=0;
        if(wt[index]<=w){
            take=val[index]+ks(w-wt[index],val,wt,index-1,dp);   
        }
        notake=ks(w,val,wt,index-1,dp);
        
        return dp[index][w]=Math.max(take,notake);
    }
}

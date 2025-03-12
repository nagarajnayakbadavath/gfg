//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(findCost(cost,0,dp),findCost(cost,1,dp));
    }
    static int findCost(int cost[],int index,int dp[]){
        
        if(index>=cost.length) return 0;

        if(dp[index]!=-1) return dp[index];        
        int oneStep=cost[index]+findCost(cost,index+1,dp);
        int twoSteps=cost[index]+findCost(cost,index+2,dp);
        
        return dp[index]=Math.min(oneStep,twoSteps);
    }
};
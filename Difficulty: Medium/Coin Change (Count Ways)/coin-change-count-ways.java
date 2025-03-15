//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
        // code here.
        int dp[][]=new int[coins.length][sum+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=-1;
            }
        }
        
        return cc(coins,sum,coins.length-1,dp);
    }
    static int cc(int coins[],int target,int index,int dp[][]){
        //base case
        if(index==0){
            return target%coins[0]==0?1:0;
        }
        
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=cc(coins,target,index-1,dp);
        int take=0;
        if(coins[index]<=target){
            take=cc(coins,target-coins[index],index,dp);
        }
        return dp[index][target]=notTake+take;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean dp[][]=new Boolean[arr.length][sum+1];
        return check(arr,sum,0,dp);
    }
    static boolean check(int arr[],int sum,int index,Boolean dp[][]){
        //Base case
        if(sum==0){
            return true;
        }
        if(index>=arr.length){
            return false;
        }
        
        if(dp[index][sum]!=null) return dp[index][sum];
        
        boolean take=false;
        boolean notTake=false;
        notTake=check(arr,sum,index+1,dp);
        if(arr[index]<=sum){
            take=check(arr,sum-arr[index],index+1,dp);
        }
        return dp[index][sum]=notTake || take;
    }
}
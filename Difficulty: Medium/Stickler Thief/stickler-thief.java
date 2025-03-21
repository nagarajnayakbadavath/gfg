//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return maxLoot(arr,arr.length-1,dp);
    }
    static int maxLoot(int arr[],int index,int dp[]){
        
        //Base condition
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int nopick=maxLoot(arr,index-1,dp);
        int pick=arr[index]+maxLoot(arr,index-2,dp);
        return dp[index]=Math.max(pick,nopick);
    }
}
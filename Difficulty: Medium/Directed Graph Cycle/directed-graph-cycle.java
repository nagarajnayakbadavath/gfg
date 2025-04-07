//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        int visitedArray[]=new int[V];
        int visitedPath[]=new int[V];
        Arrays.fill(visitedArray,0);
        Arrays.fill(visitedArray,0);
        for(int i=0;i<V;i++){
            if(visitedArray[i]==0){
                if(dfs(i,adj,visitedArray,visitedPath)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int visitedArray[],int visitedPath[]){
        visitedArray[node]=1;
        visitedPath[node]=1;
        for(int adjNode:adj.get(node)){
            if(visitedArray[adjNode]==0){
                if(dfs(adjNode,adj,visitedArray,visitedPath)){
                    return true;
                }
            }else if(visitedPath[adjNode]==1){
                return true;
            }
        }
        visitedPath[node]=0;
        return false;
    }
}
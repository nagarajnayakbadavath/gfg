//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends

class Pair{
    int node;
    int parentNode;
    Pair(int node,int parentNode){
        this.node=node;
        this.parentNode=parentNode;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int visitedArray[]=new int[V+1];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Arrays.fill(visitedArray,0);
        for(int i=0;i<V;i++){
            if(visitedArray[i]==0){
                if(bfs(i,adj,visitedArray)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean bfs(int startingNode,ArrayList<ArrayList<Integer>> adj,int visitedArray[]){
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(startingNode,-1));
        visitedArray[startingNode]=1;
        
        while(!queue.isEmpty()){
            Pair current=queue.poll();
            int node=current.node;
            int parentNode=current.parentNode;
            for(int adjNode:adj.get(node)){
                if(visitedArray[adjNode]==0){
                    queue.add(new Pair(adjNode,node));
                    visitedArray[adjNode]=1;
                }else if(parentNode!=adjNode){
                    return true;
                }
            }
        }
        return false;
    }
}
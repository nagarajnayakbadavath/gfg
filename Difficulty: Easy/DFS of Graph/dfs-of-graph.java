//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                String[] input = br.readLine().trim().split(" ");
                ArrayList<Integer> node = new ArrayList<>();
                for (String s : input) {
                    if (!s.isEmpty()) {
                        node.add(Integer.parseInt(s));
                    }
                }
                adj.add(node);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfs(adj);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfs=new ArrayList<Integer>();
        int n=adj.size();
        int visitedArray[]=new int[n+1];
        Arrays.fill(visitedArray,0);
        int startingNode=0;
        return dfs(startingNode,visitedArray,adj,dfs);
    }
    static ArrayList<Integer> dfs(int startingNode,int visitedArray[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs){
        dfs.add(startingNode);
        visitedArray[startingNode]=1;
        for(int val:adj.get(startingNode)){
            if(visitedArray[val]==0){
                dfs(val,visitedArray,adj,dfs);
            }
        }
        return dfs;
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n=s.length();
        int max=0;
        int maxI=0;
        int maxJ=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j) && (j-i+1)>max){
                    max=j-i+1;
                    maxI=i;
                    maxJ=j;
                }
            }
        }
        while(maxI<=maxJ){
            sb.append(s.charAt(maxI));
            maxI++;
        }
        return sb.toString();
    }
    static boolean isPalindrome(String s,int firstIdx,int lastIdx){
        while(firstIdx<lastIdx){
            if(s.charAt(firstIdx)!=s.charAt(lastIdx)){
                return false;
            }
            firstIdx++;
            lastIdx--;
        }
        return true;
    }
}
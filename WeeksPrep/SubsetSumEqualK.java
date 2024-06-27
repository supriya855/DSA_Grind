
// Recurrence
import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        return helper(n-1,k,arr);
    }
    public static boolean helper(int idx, int k , int[] arr){
        if(k==0) return true;
        if(idx == 0) return arr[0]==k;
        boolean notTake = helper(idx-1,k,arr);// keeping same target
        boolean take = false;// intially
        if(arr[idx]<=k){
            take = helper(idx-1,k-arr[idx],arr);
        }
        return take || notTake;

    }
}


// Memorization

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k+1];
         for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n-1,k,arr,dp);
    }
    public static boolean helper(int idx, int k ,int[] arr, int[][] dp){
        if(k==0) return true;
        if(idx == 0) return arr[0]==k;
        if(dp[idx][k]!=-1) return dp[idx][k] == 1;
        boolean notTake = helper(idx-1,k,arr,dp);// keeping same target
        boolean take = false;// intially
        if(arr[idx]<=k){
            take = helper(idx-1,k-arr[idx],arr,dp);
        }
         dp[idx][k] = (take || notTake) ? 1 : 0;
        return dp[idx][k] == 1;

    }
}
// Tabulation from bottom to top base case to top

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp = new boolean[n][k+1];
        //base case
         for (int i = 0; i < n; i++) {
            dp[i][0] = true;//whenever target is 0
        }
        if (arr[0] <= k) 
        dp[0][arr[0]]= true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
            boolean notTake = dp[i-1][target];
            boolean take = false;
            if(arr[i]<=target){
                take = dp[i-1][target-arr[i]];
            }
            dp[i][target] = take || notTake;
            }
        }
        return dp[n-1][k];

    }
    // public static boolean helper(int idx, int k ,int[] arr, int[][] dp){
    //     if(k==0) return true;
    //     if(idx == 0) return arr[0]==k;
    //     if(dp[idx][k]!=-1) return dp[idx][k] == 1;
    //     boolean notTake = helper(idx-1,k,arr,dp);// keeping same target
    //     boolean take = false;// intially
    //     if(arr[idx]<=k){
    //         take = helper(idx-1,k-arr[idx],arr,dp);
    //     }
    //      dp[idx][k] = (take || notTake) ? 1 : 0;
    //     return dp[idx][k] == 1;

    // }
}

package DynamicProgramming;
import java.util.*;

class TUF
{
    static int getAns(int[] arr, int n , int ind, int prev_ind, int[][] dp)
    {
        if(ind==n)
        {
            return 0;
        }
        if(dp[ind][prev_ind+1]!=-1)
        {
            return dp[ind][prev_ind+1];
        }
        int notTake = 0 +getAns(arr, n ,ind+1, prev_ind, dp);
        int take =0;
        if(prev_ind==-1||arr[ind]> arr[prev_ind])
        {
            take = 1+getAns(arr, n ,ind+1,ind, dp);
        }
        dp[ind][prev_ind+1]=Math.max(notTake, take);
        return dp[ind][prev_ind+1];
    }
    static int LongestIncreasingSubs(int[] arr, int n)
    {
        int dp[][]= new int[n][n+1];
        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }
        return getAns(arr, n, 0, -1, dp);
    }
    class LongestIncreasingSubsequence
    {
        public static void main(String[] args) {
            int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
            int n = arr.length;
            System.out.println("Length of Longest Subsequence is : " + LongestIncreasingSubs(arr, n));
        }

    }
}

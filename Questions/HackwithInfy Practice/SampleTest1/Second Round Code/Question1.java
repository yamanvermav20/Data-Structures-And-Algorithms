import java.util.*;

public class Question1 {
    static int[][][] dp;

    public static int solve(int[] arr, int index, int prev, int state) {
        if (index == arr.length) {
            return 0;
        }
        
        if (dp[index][prev + 1][state] != -1) {
            return dp[index][prev + 1][state];
        }
        
        if (prev == -1 || arr[index] > arr[prev]) {
            int take = 1 + solve(arr, index + 1, index, state);
            int nottake = solve(arr, index + 1, prev, state);
            return dp[index][prev + 1][state] = Math.max(take, nottake);
        } 
        else {
            int take = 0;
            if (state == 1) take = 1 + solve(arr, index + 1, index, 0);
            int nottake = solve(arr, index + 1, prev, state);
            return dp[index][prev + 1][state] = Math.max(take, nottake);
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3, 7};
        int n = arr.length;

        dp = new int[n][n + 1][2];
        for (int[][] row : dp) {
            for (int[] cell : row) Arrays.fill(cell, -1);
        }

        System.out.println("Longest Momentum Subsequence: " + solve(arr, 0, -1, 1));
    }
}
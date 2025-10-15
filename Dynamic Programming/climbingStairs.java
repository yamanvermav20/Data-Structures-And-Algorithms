//if variation of the question
//Question is to Climb Stair, we have to climb n stair in which we have to take a jump of 1 or 2, so count the ways
//Here is the code for 1 and 2 jumps
//Can also have variation if we have 1, 2, and 3 jumps
//just add one more call for 3 or n
//dp[n] = countWays(n - 1, dp) + countWays(n - 2, dp) + countWays(n - 3, dp);

import java.util.*;
public class climbingStairs {
    static int count = 0;

    //Recursive
    //Recursion(2 ^ n) 
    public static void climbingStair(long n, int height){
        if(height > n){
            return;
        }
        if(height == n){
            count++;
            return;
        }
        
        climbingStair(n, height + 1);
        climbingStair(n, height + 2);
    }

    //Using Memoization(Top - Down DP) 
    //O(n)
    public static long countWays(int n, long[] dp){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = countWays(n - 1, dp) + countWays(n - 2, dp);
        return dp[n];
    }

    //Using Tabulation(Bottom - Up DP)
    //Create Table + Intialise
    //Meaning for Indexd
    //Fill
    //O(n)
    public static long countWaysTabulation(int n){
        long[]dp = new long[n + 1];
        dp[0] = 1;

        for(int i = 1; i <=  n; i++){
            if(i == 1){
                dp[i] = dp[i - 1];
            }
            else{
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // climbingStair(n, 0);
        // System.out.println(count);
        long[] dp = new long[ n + 1];
        Arrays.fill(dp, -1);
        System.out.println(countWays(n, dp));
        System.out.println(countWaysTabulation(n));
    }
}

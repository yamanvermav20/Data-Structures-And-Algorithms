import java.util.*;
public class fibonacci {
    public static int fibonacci(int n, int[] dp){
        if(n == 0 || n == 1) return n;
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        System.out.println(fibonacci(n, dp));
        sc.close();
    }
}

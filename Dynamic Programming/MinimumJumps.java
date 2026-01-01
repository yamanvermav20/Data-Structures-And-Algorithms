import java.util.*;
public class MinimumJumps {
    public static int min(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, arr.length + 1);
        dp[arr.length - 1] = 0;

        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = i + 1; j <= i + arr[i] && j < arr.length; j++){
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }

        print(dp);
        
        return dp[0];
        
    }
    public static void print(int[] dp){
        for(int i : dp){
            System.out.print(i + "  ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 4, 1};
        System.out.println(min(arr));
    }
}

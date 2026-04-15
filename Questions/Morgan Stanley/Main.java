import java.util.*;

public class Main {

    //Questionn 1001101 
    //wegive k = 3 and we can change it and then add it find the ways 0 to 1

    //arr = [8, 4, 2, 2, 2, 3];
    // we have to maximize the trp
    //Questions is  same as Leetcode Delete and Earn;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        
        int[] arr2 = new int[max + 1];
        for(int i : arr){
            arr2[i] += i;
        }
        
        int[] dp = new int[max + 1];
        dp[0] = arr2[0];
        dp[1] = Math.max(arr2[0], arr2[1]);

        for(int i = 2; i < max + 1 ; i++){
            dp[i] = Math.max(arr2[i] + dp[i - 2], dp[i - 1]);
        }

        System.out.print(dp[max]);
    }
}


import java.util.*;
public class LongestIncreasingSubsequence {
    public static int lcs(int[] arr1, int[] arr2){
        int n = arr1.length;

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){

                if(arr1[i - 1] == arr2[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        print(dp);

        return dp[n][n];
    }
    public static int LIS(int[] arr, int n){
        HashSet<Integer> set = new  HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()]; //sorted unique els
        int index = 0;

        for(int num : set){
            arr2[index++] = num;
        }

        Arrays.sort(arr2);

        return lcs(arr, arr2);
    }

    public static void print(int[][] dp){
        for(int[] i : dp){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] arr = {50, 3, 10, 7, 40, 80};
        System.out.println(LIS(arr, arr.length));
    }
}


// simple trick to solve LIS
// this just check that the current number is greater than what number behind it
//if it big then check that number which is small that how big is it from other number
//arr = {50, 3, 10, 7, 40, 80}
//n = 6
// like for 80 it is bigger than 40 , check 40 it is bigger than
//   7, 7 is bigger than 3 like that 
// but we have to check for each index

// for (int i = 1; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (arr[j] < arr[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//         }
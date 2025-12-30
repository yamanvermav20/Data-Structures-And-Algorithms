import java.util.*;
public class LongestCommonSubsequence {
    static int[][] dp;
    public static int lcs(String str1, String str2, int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(str1.charAt(i) == str2.charAt(j)){
            dp[i][j] = 1 + lcs(str1, str2, i - 1, j - 1);
            return dp[i][j];
        }
        else{
            int left =  lcs(str1, str2, i - 1, j);
            int right = lcs(str1, str2, i, j - 1);
            dp[i][j] = Math.max(left, right);
            return dp[i][j];
        }
    }

    public static int lcstab(String str1, String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 0; i <= str1.length(); i++){
            for(int j = 0; j <= str2.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        print(dp);

        return dp[str1.length()][str2.length()];
    }
    public static void print(int[][] dp){
        for(int i[] : dp){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        String str1 = "Hello World";
        String str2 = "elgWold";

        dp = new int[str1.length()][str2.length()];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }

        System.out.println(lcstab(str1, str2));
    }
}

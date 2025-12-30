import java.util.*;
public class LongestCommonSubstring {
    static int ans = 0;
    public static void LCSubstring(String str1, String str2, int n, int m, int lcs){
        if(n == 0 || m == 0){
            ans = Math.max(ans, lcs);
            return;
        }

        ans = Math.max(ans, lcs);

        if(str1.charAt(n - 1) == str2.charAt(m - 1)){
            LCSubstring(str1, str2, n - 1, m - 1, lcs + 1);
        }
        else{
            LCSubstring(str1, str2, n - 1, m, 0);
            LCSubstring(str1, str2, n, m - 1, 0);
        }
    }

    public static void LCSubstringtab(String str1, String str2, int n, int m){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int ans = 0;

        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        print(dp);
        System.out.println(ans);
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
        String str1 = "ABCDE";
        String str2 = "ABGCE";

        // LCSubstring(str1, str2, str1.length(), str2.length(), 0);
        LCSubstringtab(str1, str2, str1.length(), str2.length());
        // System.out.print(ans);
    }
}

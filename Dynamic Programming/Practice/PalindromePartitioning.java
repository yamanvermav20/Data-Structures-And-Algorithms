import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PalindromePartitioning{
    public static void backtrack(String s, List<List<String>> ans, List<String> list, int index, boolean[][] dp){
        if(index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(dp[index][i]){
                list.add(s.substring(index, i + 1));
                backtrack(s, ans, list, i + 1, dp);
                list.remove(list.size() - 1);
            }
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2 || dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }
                }
            }
        }
        backtrack(s, ans, new ArrayList<>(), 0, dp);
        return ans;
    }
    public static void main(String[] args){
        String str = "aabdedaba";
        List<List<String>> ans = partition(str);
        
        for(List<String> i : ans){
            System.out.print("[ ");
            for(String j : i){
                System.out.print(j + " ");
            }
            System.out.println(']');
        }
    }
}
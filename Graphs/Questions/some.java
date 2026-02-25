// package Graphs.Questions;
import java.util.*;

public class some {
    public static int solve(String str){
        int[] freq = new int[26];
        int n = str.length();
        int count = 0;
        int ans = 0;

        for(int i = n - 1; i >= 1; i--){
            if(str.charAt(i - 1) == str.charAt(i)){
                ans += count - freq[str.charAt(i) - 'a'];
                Arrays.fill(freq, 0);
                freq[str.charAt(i) - 'a'] = count;
            }
            else{
                freq[str.charAt(i) - 'a']++;
            }
            count++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(solve(str));
    }
}

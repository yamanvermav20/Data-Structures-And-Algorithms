//package Questions.HackwithInfy_Classes;
import java.util.*;

public class Question1 {
    public static HashSet<String> atMost(String str, int k){
        HashSet<String> set = new HashSet<>();
        int count = 0;
        int[] freq = new int[26];

        int end = 0;
        int start = 0;

        while(end < str.length()) {
            char ch = str.charAt(end);
            if(freq[ch - 'a'] == 0)  count++;
            freq[ch - 'a']++;

            while(count > k){
                ch = str.charAt(start);
                freq[ch - 'a']--;
                if(freq[ch - 'a'] == 0) count--;
                start++;
            }

            for(int i = start; i <= end; i++){
                set.add(str.substring(i, end + 1));
            }
            end++;
        }

        return set;
    }
    public static void total_Substrings(String str, int k){
        HashSet<String> ans = new HashSet<>();

        for(int i = 0; i < str.length(); i++){
            HashSet<Character> set = new HashSet<>();

            for(int j = i; j < str.length(); j++){
                set.add(str.charAt(j));
                if(set.size() == k){
                    ans.add(str.substring(i, j + 1));
                }   
                else if(set.size() > k) break;
            }
        }

        for(String i : ans){
            System.out.print(i + " .. ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();

        HashSet<String> ans1 = atMost(str, k);        
        HashSet<String> ans2 = atMost(str, k - 1);        

        ans1.removeAll(ans2);

        for(String ss : ans1){
            System.out.print(ss + " .. ");
        }

        System.out.println();
        System.out.println("Here below is second one");
        total_Substrings(str, k);
    }
}

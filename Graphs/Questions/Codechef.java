import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int solve(String s) {
        int[] freq = new int[26];
        char prev = s.charAt(s.length() - 1);
        int count = 1;
        int ans = 0;
        freq[prev - 'a']++;
        
        for(int i = s.length() - 2; i >= 0; i--) {
            char curr = s.charAt(i);
            
            if(prev == curr) {
                ans += count - freq[curr - 'a'];
                Arrays.fill(freq, 0);
                freq[curr - 'a'] = count + 1;
            }
            else  freq[curr - 'a']++;
            prev = curr;
            count++;
        }
        
        return ans;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
        
        String str = "aabbcab"; //7
        String str2 = "aabbcefbggde";  // 19
        String str3 = "aaaaaaaa";    // 0
        String str4 = "aabbbbbb";   // 6
        String str5 = "bbafcebbdefbdbdb"; //9
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
        System.out.println(solve(s));
	}
}
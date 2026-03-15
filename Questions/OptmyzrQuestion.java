// package Graphs.Questions;

import javax.sql.rowset.spi.SyncFactoryException;

public class OptmyzrQuestion {
    public static int maxOperations(String s) {
        int n = s.length();
        int total = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                // This pair can spread to fill remaining positions
                total += (n - i - 2);
                // skip duplicate pairs of same char
                while (i + 1 < n - 1 && s.charAt(i) == s.charAt(i + 1)) i++;
            }
        }
        return total;
    }
    public static int brute(String s){
        StringBuilder stb = new StringBuilder(s);
        int count = 0;

        for(int i = s.length() - 1; i >= 1; i--){
            for(int j = i; j < s.length(); j++){
                if(stb.charAt(j - 1) == stb.charAt(j)){
                    if(j + 1 < s.length()  && stb.charAt(j) != stb.charAt(j + 1)){ 
                        stb.setCharAt(j + 1, stb.charAt(i));
                        count++;
                    }
                }
            }
        }   

        return count;
    }
    public static void main(String[] args){
        String str = "aabbcab"; //7
        String str2 = "aabbcefbggde";  // 19
        String str3 = "aaaaaaaa";    // 0
        String str4 = "aabbbbbb";   // 6
        String str5 = "bbafcebbdefbdbdb"; //9

        System.out.println(brute(str));
        System.out.println(brute(str2));
        System.out.println(brute(str3));
        System.out.println(brute(str4));
    }
}

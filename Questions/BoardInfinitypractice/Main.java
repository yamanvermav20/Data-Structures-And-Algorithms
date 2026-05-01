// package Questions.BoardInfinitypractice;
import java.util.*;

public class Main {
    public static void print(int[] val){
        for(int i : val){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void solve(String str, int x){
        int n = str.length();
        int[] val = new int[str.length()];
        Arrays.fill(val, -1);

        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '0'){
                if(i - x >= 0) val[i - x] = 0;
                if(i + x < n) val[i + x] = 0;
            }
        }
        // print(val);
        for(int i = 0; i < n; i++){
            // print(val);
            if(str.charAt(i) == '1'){
                if((i - x < 0 || val[i - x] == 0) && (i + x >= n || val[i + x] == 0)){
                    System.out.print(-1);
                    return;
                }
                if(i - x >= 0 && val[i - x] != 0) val[i - x] = 1;
                if(i + x < n && val[i + x] != 0) val[i + x] = 1;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i : val){
            ans.append(i);
        }
        
        System.out.print(ans);
    }
    public static void main(String[] args) {
        // String str = "101110";
        //int x = 2;
        //ans is "111011";

        String str = "101010";
        int x = 0;

        solve(str, x);
    }
}

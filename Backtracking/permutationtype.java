import java.util.*;
public class permutationtype {
    public static char getChar(int n){
        return (char) ('a' + n - 1);
    }
    public static ArrayList<String> permutation(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> result = new ArrayList<>();

        int firstDigit = str.charAt(0) - '0';
        if(firstDigit >= 1 && firstDigit <= 9){
            char ch = getChar(firstDigit);
            ArrayList<String> smallAns = permutation(str.substring(1));
            for(String s: smallAns){
                result.add(ch + s);
            }
        }
        if(str.length() >= 2){
            int firstTwo = Integer.parseInt(str.substring(0, 2));
            if(firstTwo >= 10 && firstTwo <= 26){
                char ch2 = getChar(firstTwo);
                ArrayList<String> smallAns2 = permutation(str.substring(2));

                for(String s: smallAns2){
                    result.add(ch2 + s);
                }
            }
        }
        ArrayList<String> smallAns3 = permutation(str.substring(1));
        for(String s : smallAns3){
            result.add(str.charAt(0) + s);
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> ans = permutation(str);
        System.out.println(ans);
    }
}

import java.util.*;
public class news {
    public static String decodeString(String s) {
        // Stack<String> st = new Stack<>();
        String str = "";
        for(int i = s.length() - 1; i >= 0; i--){
            if(Character.isDigit(s.charAt(i))){
                int digit = Integer.parseInt(String.valueOf(s.charAt(i)));
                str = decode(str, digit);
            }
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                str += s.charAt(i);
            }
        }
        return str;
    }
    public static String decode(String str, int digit){
        String newStr = "";
        for(int i = 0; i < digit; i++){
            newStr += str;
        }
        return newStr;
    }
    public static void main(String[] args){
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }
}

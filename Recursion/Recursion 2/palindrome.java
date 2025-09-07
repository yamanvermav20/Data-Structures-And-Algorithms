import java.util.Scanner;

public class palindrome {
    public static boolean checkpalindrome(String str,int start, int end){
        if(start>=end){
            return true;
        }
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return checkpalindrome(str,start+1,end-1);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(checkpalindrome(str,0,str.length()-1));
    }
}

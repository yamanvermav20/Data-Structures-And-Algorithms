import java.util.*;
public class reverse {
    public static String reversed(String strr,int i,int j){
        StringBuilder str=new StringBuilder(strr);
        if(i>=j){
            return str.toString();
        }
        char temp=str.charAt(j);
        str.setCharAt(j,str.charAt(i));
        str.setCharAt(i,temp);

        strr=str.toString();
        
        return reversed(strr,i+1,j-1);
    }   
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        System.out.println(reversed(a,0,a.length()-1));
    } 
}

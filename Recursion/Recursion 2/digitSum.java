import java.util.*;
public class digitSum {
    public static int digits(int n){
        if(n==0){
            return 0;
        }
        return (n%10)+digits(n/10);
    }
    public static void main(String [] args){
        Scanner sc=new Scanner (System.in);
        int a=sc.nextInt();
        System.out.println(digits(a));
    }
}

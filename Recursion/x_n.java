import java.util.*;
public class x_n {
    public static int Power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*Power(x,n-1);
    }

    public static int PowerOptimised(int x,int n){
        if(n==0){
            return 1;
        }
        int a=PowerOptimised(x,n/2);
        int halfPower=a*a;
        if(n%2!=0){
            halfPower=x*halfPower;
        }
        return halfPower;
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner (System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(PowerOptimised(x,n));
    }

}

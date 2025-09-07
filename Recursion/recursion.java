import java.util.*;
public class recursion {
    public static void printInc(int n){
        if(n==1){
            System.out.println(n);
            return ;
        }
        printInc(n-1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int fibonacci(int n){
        if(n==0){
            return 0;
            
        }
        if(n==1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);                                            


    }

    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int a;
        a=sc.nextInt();

        //printInc(a);

        //System.out.println(factorial(a));

        System.out.println(fibonacci(a));




        
    }
}

import java.util.*;
public class recursionquestion {
    public static int fibonacci(int a){
        if(i==0){
            return 0;
        }
        if(i==1){
            return 1;
        }
        return fibonacci(a-1)+fibonacci(a-2);
    }
    static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.print(fibonacci(a));

    }
    
}

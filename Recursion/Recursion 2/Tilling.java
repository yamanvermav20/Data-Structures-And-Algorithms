import java.util.*;
public class Tilling {
    public static int TillingProblem(int n){  // 2 X n floor size
        //base case;
        if(n==0 || n==1){
            return 1;
        }
        //vertical
        int fnm1=TillingProblem(n-1);

        //horizontal
        int fnm2=TillingProblem(n-2);

        int totalways=fnm1+fnm2;

        return totalways;
    }

    public static int friendsdProblem(int n){
        if(n==1 ||  n==2){
            return n;
        }
        int singleWays=friendsdProblem(n-1);
        int doubleWays=friendsdProblem(n-2)*(n-1);
        int totalways=singleWays+doubleWays;
        return totalways;

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);



    //     System.out.println("Enter n for 2 x n floor : ");
    //     int n=sc.nextInt();
        
    //     System.out.print("The number of ways to adjust the tiles are  :  ");
    //     System.out.println(TillingProblem(n));
    

        int n=sc.nextInt();
        System.out.println(friendsdProblem(n));
    }


    
}

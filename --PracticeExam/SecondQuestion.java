// package APC_EXAM_01_08_2025;

//*** Error Find */
import java.util.Scanner;
// public class hello extends Exception{
//     public hello(String message){
//         super(message);
//     }
// }
// throw new hello("s");

public class SecondQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int testcases = sc.nextInt();//*user types: 23⏎ (only 23 is read) //will read the nextline enter after entering testcase      
        // sc.nextLine() //either use thsi after inputing or other method
        // int testcases = Integer.parseInt(sc.nextLine());
        int testcases = sc.nextInt();
        sc.nextLine();
        while(testcases-- > 0){
            String str = sc.nextLine(); // reads the leftover '\n' → s = ""
            int a;
            // System.out.println(str);
            try{
                a = sc.nextInt(); // if we take input here we have to consume 23⏎ (enter)
                sc.nextLine();   //here we consume enter so that next input of str dont read it
                
                if(a < 0 || a > 100){
                    System.out.println("Invalid range");
                }
                else{
                    System.out.println("Correct");
                }
            }
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }
        sc.close();
    }
}

// package HackwithInfy Practice.SampleTest1.Question 2;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i : arr){
            currentSum = Math.max(i + currentSum, i);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.print(maxSum);
    }
}

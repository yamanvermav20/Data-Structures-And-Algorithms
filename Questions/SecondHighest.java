import java.util.*;

public class SecondHighest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i : arr){
            if(i > max){
                secondMax = max;
                max = i;
            }
            else if(i > secondMax && i != max){
                secondMax = i;
            }
        }

        System.out.print(secondMax);
    }
}

import java.util.*;
public class APC_EXAM_01_08_2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while(testcases-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            nextGreaterElement(arr, n);
            
        }
        sc.close();
    }
    public static void nextGreaterElement(int[] arr, int n){
        for(int i = 0; i < n; i++){
            boolean flag = false;
            for(int j = i + 1; j < n; j++){
                if(arr[i] < arr[j]){
                    System.out.print(arr[j] + " ");
                    flag = true;
                    break;
                }
            }
            if(!flag) System.out.print(-1 + " "); // done this wrong in exam
        }
    }
}

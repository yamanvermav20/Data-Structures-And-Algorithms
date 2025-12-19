import java.util.*;

public class JobScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        if(n == 0){
            System.out.println(0);
            return;
        }

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else{
                return b[1] - a[1];
            }
        });

        int maxDeadline = arr[n - 1][0];

        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int maxProfit = 0;

        for(int i = n - 1; i >= 0; i--){
            int deadline = arr[i][0];
            int profit = arr[i][1];

            for(int t = deadline; t > 0; t--){
                if(slot[t] == -1){      
                    slot[t] = profit;   
                    maxProfit += profit;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(arr[i][0] + "  " + arr[i][1]);
        }

        System.out.println(maxProfit);
    }
}

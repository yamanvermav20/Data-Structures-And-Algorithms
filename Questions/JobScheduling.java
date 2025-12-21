import java.util.*;

public class JobScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        if(n == 0){
            System.out.println(0);
            sc.close();
            return;
        }

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
                return b[1] - a[1];
        });

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i][0]);
        }
        
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int maxProfit = 0;

        for(int i = 0; i < n; i++){
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
        sc.close();
    }
}

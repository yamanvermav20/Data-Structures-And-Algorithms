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

        int maxDeadlines = 0;
        for (int i = 0; i < n; i++) {
            maxDeadlines = Math.max(maxDeadlines, arr[i][0]);
        }
        
        int[] slot = new int[maxDeadlines + 1];
        Arrays.fill(slot, -1);

        int maxProfits = 0;

        for(int i = 0; i < n; i++){
            int deadlines = arr[i][0];
            int profits = arr[i][1];

            for(int t = deadlines; t > 0; t--){
                if(slot[t] == -1){      
                    slot[t] = profits;   
                    maxProfits += profits;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(arr[i][0] + "  " + arr[i][1]);
        }

        System.out.println(maxProfits);
        sc.close();
    }
}

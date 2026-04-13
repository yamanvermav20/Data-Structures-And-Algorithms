import java.util.*;

public class Main {

    //Questionn 1001101 
    //wegive k = 3 and we can change it and then add it find the ways 0 to 1

    //arr = [8, 4, 2, 2, 2, 3];
    // we have to maximize the trp

    public static int solve(int[] arr, int index, HashSet<Integer> set, int value){
        if(index == arr.length){
            return 0;
        }
        if(set.isEmpty()){
            return 0;
        }

        set.remove(arr[index] + 1);
        set.remove(arr[index] - 1);
        int pick = 0;
        if(set.contains(arr[index])) pick = arr[index] + solve(arr, index + 1, set, value + arr[index]);
        set.add(arr[index] + 1);
        set.add(arr[index] - 1);

        int notpick = solve(arr, index + 1, set, value);

        return Math.max(pick, notpick);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        
        int ans = solve(arr, 0, set, 0);
        System.out.print(ans);
    }
}


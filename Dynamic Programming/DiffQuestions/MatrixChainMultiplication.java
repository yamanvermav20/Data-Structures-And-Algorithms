public class MatrixChainMultiplication {
    public static int MCM(int[] arr, int start, int end){
        if(start == end){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k = start; k < end; k++){
            int cost1 = MCM(arr, start, k); // Astart .... Ak => arr[start - 1] x arr[k]
            int cost2 = MCM(arr, k + 1, end); // Ak + 1 .... Aend => arr[k] x arr[j]
            int cost3 = arr[start - 1] * arr[k] * arr[end];
            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans;


    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3}; // n = 5;
        int n = arr.length;

        System.out.println(MCM(arr, 1, n - 1));
    }    
}

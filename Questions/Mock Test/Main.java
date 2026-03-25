// package Questions.Mock Test;
import java.util.*;

public class Main {
    static int MOD = 1000000007;
    public static int find(int N, List<Integer> A, List<Integer> B){
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B);

        StringBuilder stb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;

        while(index1 < N || index2 < N){
            for(int i = 0; i < A.get(index1); i++) stb.append('1');
            for(int i = 0; i < B.get(index2); i++) stb.append('0');
            index1++; index2++;
        }

        int ans = 0;

        for(char ch : stb.toString().toCharArray()){
            ans = (ans * 2 +  (ch - '0')) % MOD;
        }

        return ans;
    }


    public static int solve(int N, List<Integer> A, List<Integer> B) {
        // 1. Sort A in descending order to put largest 1-blocks at the most significant positions
        Collections.sort(A, Collections.reverseOrder());
        
        // 2. Sort B in ascending order to minimize the '0' gaps between the 1-blocks
        Collections.sort(B);

        long totalValue = 0;
        long totalLength = 0;
        
        // Calculate the total bit-length of the binary string
        for (int val : A) totalLength += val;
        for (int val : B) totalLength += val;

        long currentPos = totalLength;

        for (int i = 0; i < N; i++) {
            long sizeA = A.get(i);
            long sizeB = B.get(i);

            // Calculate the value of the block of 1s:
            // This is (2^currentPos - 2^(currentPos - sizeA)) % MOD
            long highPow = power(2, currentPos, MOD);
            long lowPow = power(2, currentPos - sizeA, MOD);

            // Use (A - B + MOD) % MOD to handle negative results during subtraction
            long blockValue = (highPow - lowPow + MOD) % MOD;
            totalValue = (totalValue + blockValue) % MOD;

            // Move the current position to the start of the next 1-block
            currentPos -= (sizeA + sizeB);
        }

        // Cast to int since totalValue < 1,000,000,007
        return (int) totalValue;
    }

    /**
     * Efficiently calculates (base^exp) % mod using Binary Exponentiation.
     * Time Complexity: O(log exp)
     */
    private static long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            A.add(sc.nextInt());
        }
        for(int i = 0; i < N; i++){
            B.add(sc.nextInt());
        }

        System.out.println(find(N, A, B));
    }
    
}

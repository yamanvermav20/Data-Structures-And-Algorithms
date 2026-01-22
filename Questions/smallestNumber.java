//give a d = digits and k = sum we have to make a smallest number from these which has d digits and all digit sum is k
public class smallestNumber {
    public static boolean backtrack(int d, int k, StringBuilder stb, int sum){
        int used = stb.length();
        int Rdigits = d - used;
        int Rsum = k - sum;

        if(used == d && sum == k){
            return true;
        }
        if(used > d || sum > k){
            return false;
        }
        if(Rdigits < 0 || (Rdigits * 9 < Rsum)) return false;

        for(int i = 9; i >= 1; i--){
            int length = stb.length();
            stb.append(i);
            if(backtrack(d, k, stb, sum + i)) return true;
            stb.setLength(length);
        }

        return false;
    }
    public static void greedy(int d, int k, StringBuilder stb, int sum){
        int[] ans = new int[d];
        for(int i = d - 1; i > 0; i--){
            if(k > 9){
                ans[i] = 9;
                k -= 9;
            }
            else{
                ans[i] = k;
                k = 0;
            }
        }
        ans[0] = 
    }
    public static void main(String[] args) {
        int d = 10;
        int k = 36;
        if(d * 9 < k){ 
            System.out.println("No solution exist");
            return;
        }
        
        StringBuilder stb = new StringBuilder();
        boolean ans = backtrack(d, k, stb, 0);
        if(ans){
            System.out.println(stb.reverse().toString());
        }
        else{
            System.out.println("No solution exists");
        }
    }
}

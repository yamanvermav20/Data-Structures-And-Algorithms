public class rodCutting {
    public static void rodCuttingdp(int[] length, int[] prices, int totalRod){
        int n = length.length;
        int[][] dp = new int[n + 1][totalRod + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= totalRod; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0; //this show we  intialises although java already has 0 intialised;
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= totalRod; j++){
                if(length[i - 1] <= j){
                    dp[i][j] = Math.max(dp[i -1][j], prices[i - 1] + dp[i][j - length[i - 1]]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][totalRod]);
    }
    public static void main(String args[]){
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int totalRod = 8;

        rodCuttingdp(length, prices, totalRod);
    }
}

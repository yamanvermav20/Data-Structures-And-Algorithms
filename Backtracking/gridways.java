public class gridways {
    public static int backtrack(int n, int m, int row, int col){
        if(row == n - 1 && col == m - 1){
            return 1;
        }
        if(row == n || col == m){
            return 0;
        }
        int way1 = backtrack(n, m, row + 1, col);
        int way2 = backtrack(n, m, row, col + 1);
        return way1 + way2;
    }
    public static void main(String[] args){
        int n = 3, m = 3;
        int a = backtrack(n, m, 0, 0);
        System.out.println(a);
    }
}

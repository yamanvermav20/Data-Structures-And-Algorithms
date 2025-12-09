import java.util.*;

class Result {

    static boolean ok(int a[][], int r, int c, int x){
        for(int i = 0; i < 9; i++){
            if(a[r][i] == x || a[i][c] == x) 
                return false;
        }

        int sr = r - r % 3;
        int sc = c - c % 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(a[sr + i][sc + j] == x) 
                    return false;
            }
        }

        return true;
    }

    static boolean solve(int a[][], int r, int c){
        if(r == 9) return true;
        if(c == 9) return solve(a, r+1, 0);
        if(a[r][c] != 0) return solve(a, r, c+1);

        for(int x = 1; x <= 9; x++){
            if(ok(a, r, c, x)){
                a[r][c] = x;
                if(solve(a, r, c+1)) return true;
                a[r][c] = 0;
            }
        }

        return false;
    }

    static int solveSudoku(int mat[][]){
        return solve(mat, 0, 0) ? 1 : 0;
    }
}
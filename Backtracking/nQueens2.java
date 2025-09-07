import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class nQueens2 {
    public static void backtrack(int n, int row, List<List<String>> result, List<String> list, boolean[] colCheck, boolean[] diag1, boolean[] diag2){
        if(row == n){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int j = 0; j < n; j++){
            int d1 = row - j + n - 1;
            int d2 = row + j;
            if(colCheck[j] || diag1[d1] || diag2[d2]) continue;

            char[] array = new char[n];
            Arrays.fill(array, '.');
            array[j] = 'Q';
            colCheck[j] = diag1[d1] = diag2[d2] = true;
            list.add(new String(array));
            backtrack(n, row + 1, result, list, colCheck, diag1, diag2);
            list.remove(list.size() - 1);
            colCheck[j] = diag1[d1] = diag2[d2] = false;
        }
    }
    public static void main(String[] args){
        int n = 4;
        List<List<String>> result = new ArrayList<>();
        boolean[] colCheck = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        backtrack(n, 0, result, new ArrayList<>(), colCheck, diag1, diag2);
        for(List<String> list : result){
            for(String value : list){
                System.out.println(value);
            }
            System.out.println("----chess new ---");
        }
    }
}

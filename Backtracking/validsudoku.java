public class validsudoku {
    public boolean void isValid(char[][] sudoku, int column){
        if(column == sudoku.length){
            return true;
        }
        for(int i = 0; i < sudoku.length; i++){
            if(isSafe(i)){
                sudoku[i][column] = i;
                if(isValid(sudoku, column + 1)) return true;
                sudoku[i][column] = '.';
            }
        }
    }
    public static void main(String[] args){
        char[][] sudoku = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
        };
        isValid(sudoku, 0);

    }
}

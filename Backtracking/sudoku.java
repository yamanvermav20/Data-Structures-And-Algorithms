public class sudoku {
    public static boolean isSafe(int row, int col, int[][] board, int value){
        //row Check
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == value){
                return false;
            }
            if(board[i][col] == value){
                return false;
            }
        }

        int rr = (row / 3) * 3;
        int cc = (col / 3) * 3;

        for(int i = rr; i < rr + 3; i++){
            for(int j = cc; j < cc + 3; j++){
                if(board[i][j] == value){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean solveSudoku(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 0){
                    for(int value = 1; value <= 9; value++){
                        if(isSafe(i, j, board, value)){
                            board[i][j] = value;
                            if(solveSudoku(board)) return true;
                            board[i][j] = 0;

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void printBoard(int[][] board) {

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
        };
        boolean result = solveSudoku(board);

        if(!result) {
            System.out.println("-1  (No valid Sudoku solution)");
        } else {
            System.out.println("Solved Sudoku:\n");
            printBoard(board);
        }
    }
}

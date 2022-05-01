import java.util.Scanner;

public class Nqueen {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[][] board = new boolean[n][n];

        boolean[] cols  = new boolean[n];
        boolean[] ndiag = new boolean[2 * n -1];
        boolean[] rdiag = new boolean[2 * n -1];

        nqueen(board , 0 , cols , ndiag , rdiag , "");
    }

    private static void nqueen(boolean[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag , String asf) {

        if(row == board.length){
            System.out.println(asf + "--");
            return;
        }

        for(int col = 0 ; col < board[0].length ; col++){
            //if all statements are false means we can place our queen at that col
            if(cols[col] == false && ndiag[row + col] == false && rdiag[row - col + board.length-1] == false
            ){
                board[row][col] = true;
                cols[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + board.length -1] = true;
                nqueen(board , row +1 , cols , ndiag ,rdiag  , asf + row + ":" + col + " ,");
                //while backtrack we should false the true col
                board[row][col] = false;
                cols[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + board.length -1] = false;

            }

        }

    }
}

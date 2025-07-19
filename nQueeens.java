import java.util.*;

public class Main {
    public static void main(String args[]){
        int n=4;
        char board[][] = new char[n][n];
        int count = nQueens(board,0);
        System.out.println("Total ways: "+count);
    }
    
    static int nQueens(char board[][],int row){
        int count = 0;
        if(row==board.length){
            printBoard(board);
            count++;
            return count;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                count += nQueens(board,row+1);
                board[row][j]='.';
            }
        }
        return count;
    }
    static void printBoard(char board[][]){
        System.out.println("---Chess Board---");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(char board[][], int row, int col){
        //left diagonal up
        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q') return false;
        }
        //vertical up
        for(int i=row; i>=0 ; i--){
            if(board[i][col]=='Q') return false;
        }
        //right diagonal up
        for(int i=row,j=col; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}

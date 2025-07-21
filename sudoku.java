import java.util.*;

public class Main {
    public static void main(String[] args) {
        int sudoku[][]={
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
        };
        
        boolean ans = sudokuSolver(sudoku,0,0);

    }
    public static boolean sudokuSolver(int sudoku[][],int row, int col){
        if(row>=9){
            printSudoku(sudoku);
            return true;
        }
        int nextRow = row, nextCol=col+1;
        if(nextCol>8){
            nextRow++;
            nextCol=0;
        }
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku,nextRow, nextCol);
        }
        for(int i=1;i<=9;i++){
            if(isSafe(sudoku,row,col,i)){
                sudoku[row][col]=i;
                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int sudoku[][], int row, int col, int number){
        for(int i=0;i<9;i++){
            if(sudoku[row][i]==number) return false;
            if(sudoku[i][col]==number) return false;
        }
        //grid check
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        int i,j;
        for(i=sr;i<sr+3;i++){
            for(j=sc;j<sc+3;j++){
                //System.out.print(i+" "+j+" ");
                if(sudoku[i][j]==number) return false;
            }
            System.out.println();
        }
        return true;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

}

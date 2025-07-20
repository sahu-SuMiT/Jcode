import java.util.*;

public class Main {
    public static void main(String args[]){
        int n=3,m=5;
        String grid[][] = new String[n][m];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]=".";
            }
        }
        grid_ways(grid,0,0,"o");
    }
    static void grid_ways(String grid[][],int row, int col, String next){
            // if(!legitChoice(grid,row,col)) return;
            if((row==grid.length-1)&&(col==grid[0].length-1)){
                grid[row][col]="o";
                printGrid(grid);
                grid[row][col]=".";
                return;
            }
            grid[row][col]=next;
            // System.out.print(level+"f*\n");
            // printGrid(grid);

            if(legitChoice(grid, row, col+1)){
                grid_ways(grid,row,col+1,">");
            }
            if(legitChoice(grid, row+1,col)){
                grid_ways(grid,row+1,col,"V");
            }
            if(legitChoice(grid, row, col-1)){
                grid_ways(grid,row,col-1,"<");
            }
            if(legitChoice(grid, row-1, col)){
                grid_ways(grid,row-1,col,"A");
            }
            grid[row][col]=".";
            // System.out.print(level+"bx*\n");
            // printGrid(grid);
    }
    static boolean legitChoice(String grid[][], int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length) return false;
        boolean found = Arrays.asList(">","V","<","A","O","o").contains(grid[row][col]);
        if(found) return false;
        return true;

    }
    static void printGrid(String grid[][]){
        System.out.println("---grid---");
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}


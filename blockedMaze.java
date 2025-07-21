import java.util.*;
public class Main{
    public static void main(String[] args){
        int maze[][]={
            {1,1,1,1},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,1}   
        };
        int ans[][]=new int[maze.length][maze[0].length];
        boolean vis[][]=new boolean[maze.length][maze[0].length];
        move(maze,0,0,vis,ans);
        
    }
    static void move(int maze[][], int x, int y,boolean vis[][], int ans[][]){
        if(x==maze.length-1 && y==maze[0].length-1){
            ans[y][x]=1;
            printMaze(ans);
            ans[y][x]=0;
            return;
        }
        ans[y][x]=1;
        vis[y][x]=true;
        if(validMove(maze,x+1,y,vis)) move(maze,x+1,y,vis,ans);
        if(validMove(maze,x,y+1,vis)) move(maze,x,y+1,vis,ans);
        if(validMove(maze,x-1,y,vis)) move(maze, x-1,y,vis,ans);
        if(validMove(maze,x,y-1,vis)) move(maze,x,y-1,vis,ans);
        vis[y][x]=false;
        ans[y][x]=0;
        return;
    }
    static boolean validMove(int maze[][],int nextX, int nextY,boolean vis[][]){
        if(nextX<0 || nextX>=maze[0].length || nextY<0 || nextY>=maze.length) return false;
        if(maze[nextY][nextX]==0) return false;
        if(vis[nextY][nextX]==true) return false;
        return true;
    }
    static void printMaze(int maze[][]){
        System.out.println("---paths---");
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
}


public class Transpose {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int m=matrix.length;
        int n=matrix[0].length;

        //create transpose n x m
        int[][] transpose=new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                transpose[j][i]=matrix[i][j];
            }
        }

        //print the transpose matrix
        for(int i=0;i<n;i++) {
            for (int j =0; j < m; j++){
                System.out.print(transpose[i][j]+" ");}
            System.out.println();
        }
    }
}

//output
/*    1 4 7 
      2 5 8
      3 6 9     */

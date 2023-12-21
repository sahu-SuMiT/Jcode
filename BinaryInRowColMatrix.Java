static int[] search(int[][] matrix, int target){
		int r=0;
		int c=matrix[0].length-1; //i think matrix[0].length
		
		while(r<matrix.length && c>=0){
			if(target==matrix[r][c]){
				return new int[]{r,c};	
			}
			else if(target<matrix[r][c]){
				c--;
			}
			else if(target>matrix[r][c]){
				r++;
			}
					
		}
		return new int[]{-1,-1};
		
	}

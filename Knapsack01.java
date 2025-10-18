//dp[i][j] is the max value using atmost i items and j weights

public static int tabulation01(int[]val,int[]wt,int c,int[][]dp){
        Arrays.fill(dp[0],0);
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int currVal=val[i-1];
                int currWt=wt[i-1];
                if(currWt<=j){
                    dp[i][j]=Math.max(currVal+dp[i-1][j-currWt],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    
    
    public static int memoization01(int[]val,int[]wt,int n,int c,int[][]dp){
        if(n==0 || c==0)return 0;
        int currVal=val[n-1];
        int currWt=wt[n-1];
        if(dp[n][c]!=0) return dp[n][c];
        if(currWt<=c){
            //include
            int included=currVal+memoization01(val,wt,n-1,c-currWt,dp);
            int excluded=memoization01(val,wt,n-1,c,dp);
            return dp[n][c]=Math.max(included,excluded);
        }else{
            return dp[n][c]=memoization01(val,wt,n-1,c,dp);
        }
    }

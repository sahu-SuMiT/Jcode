    static int mcm(int[]arr,int i,int j,int[][]dp){
        if(i==j)return dp[i][j]=0;
        int res=Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        for(int k=i;k<j;k++){
            int c1=mcm(arr,i,k,dp);
            int c2=mcm(arr,k+1,j,dp);
            int c3=arr[i-1]*arr[k]*arr[j];
            res=Math.min(res,c1+c2+c3);
        }
        return dp[i][j]=res;
    }
    
    static int mcmTab(int[]arr,int[][]dp){
        int n=arr.length;
        for(int i=1;i<n;i++){
            dp[i][i]=0;
        }
        
        for(int len=2;len<n;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int c1=dp[i][k];
                    int c2=dp[k+1][j];
                    int c3=arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(dp[i][j],c1+c2+c3);
                }
            }
        }
        return dp[1][arr.length-1];
    }

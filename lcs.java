    static int lcs(String s1, String s2, int n, int m,int[][]dp){
        if(n==0||m==0)return 0;
        if(dp[n][m]!=0){
            System.out.println("stored:"+n+","+m+":"+dp[n][m]);
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]=1+lcs(s1,s2,n-1,m-1,dp);
        }else{
            int ans1=lcs(s1,s2,n-1,m,dp);
            int ans2=lcs(s1,s2,n,m-1,dp);
            return dp[n][m]=Math.max(ans1,ans2);
        }
    }
    
    static int lcsTabulation(String s1, String s2, int n, int m, int[][]dp){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

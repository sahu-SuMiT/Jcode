    static int lcsubstring(String s1,String s2,int n, int m,int [][]dp){
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        for(int[]i:dp){
            System.out.println(Arrays.toString(i));
        }
        return ans;
    }

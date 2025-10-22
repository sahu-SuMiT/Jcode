    static int catalan(int n, int[]dp){
        if(n==0||n==1)return 1;
        int ans=0;
        if(dp[n]!=-1)return dp[n];
        for(int i=0;i<n;i++){
            ans+=catalan(i,dp)*catalan(n-1-i,dp);
        }
        return dp[n]=ans;
    }
    static int catalanTab(int n){
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        System.out.println("Finalised dp Array:"+Arrays.toString(dp));
        return dp[n];
    }

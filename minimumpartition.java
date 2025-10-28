static int partition(int[]arr){
        int sum=0;
        for(int a:arr){
            sum+=a;
        }
        int n=arr.length;
        int w=sum/2;
        int[][]dp=new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int sum1=dp[n][w];
        int sum2=sum-sum1;
        for(int[]a:dp){
            System.out.println(Arrays.toString(a));
        }
        return Math.abs(sum1-sum2);
    }

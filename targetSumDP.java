    static boolean targetSum(int target, int[]nums,boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            //target=0, always true with any items
            dp[i][0]=true;
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=target;j++){
                //item capacity <= available weight
                int curr_val=nums[i-1];
                int curr_weight=nums[i-1];
                if(curr_weight<=j){
                    
                    //System.out.println("i="+i+"j="+j+(dp[i-1][j-curr_weight]) +"-"+ (dp[i-1][j]));
                    
                    dp[i][j]=dp[i-1][j-curr_weight] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

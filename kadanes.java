    public static void kadanes(int numbers[]){
        int currSum = 0; 
        int maxSum = Integer.MIN_VALUE; 
        for(int i = 0; i < numbers.length; i++){
            if(currSum + numbers[i] < 0){
                currSum = 0;
            }else{
                currSum += numbers[i];
            }
            maxSum = Math.max(currSum, maxSum);
            System.out.println(maxSum+" "+ currSum+ " "+numbers[i]);
        }
        System.out.println("Max Sum : "+ maxSum);
    }

// collect rainwater
int collectedWater = 0;
        int[] height = {4,2,0,6,3,2,5};
        int[] maxHeightLeft = new int[height.length];
        int[] maxHeightRight = new int[height.length]; 
        maxHeightLeft[0] = height[0]; 
        maxHeightRight[height.length-1] = height[height.length-1];
        for(int i = 1; i<height.length; i++){
            maxHeightLeft[i] = Math.max(height[i], maxHeightLeft[i-1]);
        }
        for(int i = height.length-2; i>=0; i--){
            maxHeightRight[i] = Math.max(height[i], maxHeightRight[i+1]);
        }
        for(int i = 0; i < height.length; i++){
            collectedWater += Math.min(maxHeightLeft[i], maxHeightRight[i]) - height[i];
        }
        System.out.println(collectedWater);

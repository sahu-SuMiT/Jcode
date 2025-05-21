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

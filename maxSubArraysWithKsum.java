// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int k=3;
        int ans=binarySearch(arr,k);
        System.out.println(ans);
    }
    static boolean isPossible(int arr[], int k, long max){
        int subArraysNeeded=1;
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum>max){
                subArraysNeeded++;
                currSum=arr[i];
            }
        }
        return subArraysNeeded<=k;
    }
    static int binarySearch(int arr[],int k){
        int low=0;
        long high=0;
        for(int i=0;i<arr.length;i++){
            high+=arr[i];
            if(low<arr[i])low=arr[i];
        }
        int ans=(int)high;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(isPossible(arr,k,mid)){
                ans=(int)mid;
                high=(int)mid-1;
            }else{
                low=(int)mid+1;
            }
        }
        return ans;
    }
}

    public static int minimizeRange(int[] arr, int k) {
        Arrays.sort(arr);
        int l=0;
        int r=arr.length-1;
        int count=0;
        while(k>0 && l<r){
            count++;
            //each iteration
            int lcount=l+1; int rcount=(arr.length-r);
            if(lcount<=rcount){
                int cost=lcount*(arr[l+1]-arr[l]);
                if(k>=cost){
                    //raise the numbers
                    for(int ind=0;ind<=l;ind++){
                        arr[ind]=arr[l+1];
                    }
                    k-=cost;
                    l++;
                }else{
                    int partialChange=k/lcount;
                    for(int ind=0;ind<=l;ind++){
                        arr[ind]+=partialChange;
                    }
                    k=0;
                }
            }else{
                int cost=rcount*(arr[r]-arr[r-1]);
                if(k>=cost){
                    //lower the numbers
                    for(int ind=arr.length-1;ind>=r;ind--){
                        arr[ind]=arr[r-1];
                    }
                    k-=cost;
                    r--;
                }else{
                    int partialChange=k/rcount;
                    for(int ind=arr.length-1;ind>=r;ind--){
                        arr[ind]-=partialChange;
                    }
                    k=0;
                }
            }
            System.out.println("I"+count+" "+Arrays.toString(arr));
        }
        return arr[r]-arr[l];
    }

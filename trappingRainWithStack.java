import java.util.Arrays;
import java.util.Stack;
public class Main{
    public static void main(String args[]){
        int arr[]={7,0,4,2,5,0,6,4,0,5};
        int lg[]=new int[arr.length];
        int rg[]=new int[arr.length];
        lGreatest(arr,lg);
        rGreatest(arr,rg);
        System.out.println(Arrays.toString(lg));
        System.out.println(Arrays.toString(rg));

        int sumWater=0;
        int waterArray[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            waterArray[i]=Math.min(arr[lg[i]],arr[rg[i]])-arr[i];
            sumWater+=(Math.min(arr[lg[i]],arr[rg[i]])-arr[i]);
        }
         System.out.println("Stored water:"+Arrays.toString(waterArray));
        System.out.println(sumWater);
    }
    static void lGreatest(int arr[], int lg[]){
        Stack<Integer>s=new Stack<>();
        Arrays.fill(lg,-1);
        s.push(0);
        for(int i=1;i<arr.length;i++){
            int greatest=i;
            while(!s.empty()){
                if(arr[s.peek()]>arr[greatest]){
                    greatest=s.pop();
                }else{
                    s.pop();
                }
            }
            lg[i]=greatest;
            s.push(greatest);
        }
        for(int k=0;k<lg.length;k++)
            if(lg[k]==-1)
                lg[k]=k;
    }
    static void rGreatest(int arr[], int rg[]){
        Stack<Integer>s=new Stack<>();
        Arrays.fill(rg,-1);
        s.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            int greatest=i;
            while(!s.empty()){
                if(arr[s.peek()]>arr[greatest]){
                    greatest=s.pop();
                }else{
                    s.pop();
                }
            }
            rg[i]=greatest;
            s.push(greatest);
        }
        for(int k=0;k<rg.length;k++)
            if(rg[k]==-1)
                rg[k]=k;
    }
}

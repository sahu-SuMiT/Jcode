// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    static int[]tree;
    static void init(int n){
        tree=new int[n*4];
    }
    static int buildSTUtil(int[]arr,int i,int si,int sj){
        if(si==sj){
            tree[i]=arr[si];
            return tree[i];
        }
        int mid=(si+sj)/2;
        buildSTUtil(arr,2*i+1,si,mid);
        buildSTUtil(arr,2*i+2,mid+1,sj);
        return tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
    static int getMinUtil(int[]arr,int i,int si,int sj,int qi,int qj){
        if(si==sj)return arr[si];
        if(si>=qj||sj<=qi){
            return Integer.MIN_VALUE;
        }
        else if(qi>=si&&sj<=qj){
            return tree[i];
        }else{
            int mid=(si+sj)/2;
            return Math.max(getMinUtil(arr,2*i+1,si,mid,qi,qj),getMinUtil(arr,2*i+2,mid+1,sj,qi,qj));
        }
    }
    static int getMin(int[]arr,int qi,int qj){
        return getMinUtil(arr,0,0,arr.length-1,qi,qj);
    }
    static void buildST(int[]arr){
        int n=arr.length;
        buildSTUtil(arr,0,0,n-1);
    }
    private static void updateUtil(int[]arr,int idx,int i,int si,int sj,int val){
        if(idx<si||sj<idx){
            return;
        }
        if(si==sj){
            tree[i]=val;
        }else{
            int mid=(si+sj)/2;
            updateUtil(arr,idx,2*i+1,si,mid,val);
            updateUtil(arr,idx,2*i+2,mid+1,sj,val); 
            tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
        }
    }
    public static void update(int[]arr,int idx,int val){
        int n=arr.length;
        arr[idx]=val;
        updateUtil(arr,idx,0,0,n-1,val);
    }
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8};
        init(arr.length);
        buildST(arr);
        
        System.out.println(Arrays.toString(tree));
        System.out.println(getMin(arr,0,3));
        update(arr,0,10);
        System.out.println("After Update:"+Arrays.toString(arr));
        System.out.println(Arrays.toString(tree));
        System.out.println(getMin(arr,0,3));
    }
}  

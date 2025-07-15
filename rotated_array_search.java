// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target =2;
        int tarIdx=searchIt(arr, target, 0, arr.length-1);
        System.out.println("ans: "+tarIdx);
    }
    public static int search(int arr[], int tar, int si, int ei){
        if(si>ei)return -1;
        int mid = si+(ei-si)/2;
        if(arr[mid]==tar) return mid;
        if(arr[si]<=arr[mid]){//line 1
            if(arr[si]<=tar && tar<=arr[mid]){
                return search(arr, tar, si, mid);
            }else{
                return search(arr, tar, mid+1, ei);
            }
        }
        else{//line 2
            if(arr[mid]<=tar && tar <= arr[ei]){
                return search(arr, tar, mid, ei);
            }else{
                return search(arr, tar, si, mid-1);
            }
        }
    }
    public static int searchIt(int arr[], int tar, int si, int ei){
        if(si>ei) return -1;
        while(si<=ei){
            int mid = si+(ei-si)/2;
            if(arr[mid]==tar) return mid;
            if(arr[si]<=arr[mid]){
                if(arr[si]<=tar && tar<=arr[mid]){
                    ei=mid;
                }else{
                    si=mid+1;
                }
            }else{
                if(arr[mid]<=tar && tar <=arr[ei]){
                    si=mid;
                }else{
                    ei=mid-1;
                }
            }
        }
        return -1;
    }
}

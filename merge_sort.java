import java.util.*;

public class Main {
    public static void main(String[] args) {
        int array[]={5,5,5};
        int inversion_count=0;
        inversion_count=mergeSort(array,0,array.length-1);
        System.out.println("ans: "+Arrays.toString(array)+ "inv: "+inversion_count);
    }
    public static int mergeSort(int[] array, int si, int ei){
        int inversion_count=0;
        if(si>=ei){
            return inversion_count;
        }
        int mid = si+(ei-si)/2;
        inversion_count += mergeSort(array, si, mid);
        inversion_count += mergeSort(array, mid+1, ei);
        inversion_count += merge(array, si, mid, ei);
        return inversion_count;
    }
    public static int merge(int[] array, int si,int mid, int ei){
        int inversion_count=0;
        if(array.length <=1) return inversion_count;
        int i=si,j=mid+1,k=0;
        int temp[]=new int[ei-si+1];
        
        while(i<=mid && j<=ei){
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else{
                for(int p=i;p<=mid;p++){
                    System.out.print("("+array[p]+","+array[j]+")");
                }
                inversion_count+=array[mid-i+1];
                temp[k++]=array[j++];//inversion found
            }
        }
        while(i<=mid){
            temp[k++]=array[i++];
            
        }
        while(j<=ei){
            temp[k++]=array[j++];
        }
        for(i = si,k=0; i<temp.length; i++){
            array[i]=temp[k++];
        }
        return inversion_count;
    }
    
}

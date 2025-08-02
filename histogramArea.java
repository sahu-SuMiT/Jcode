import java.util.*;
public class Main{
    public static void main(String args[]){ 
        int histogram[]={2,5};
        int spanLeft[] = new int[histogram.length];
        int spanRight[] = new int[histogram.length];
        nextLeftSmaller(histogram, spanLeft);
        nextRightSmaller(histogram, spanRight);
        
        int valLeft[] = new int[histogram.length];
        int valRight[] = new int[histogram.length];
        for(int i=0;i<histogram.length;i++){
            valLeft[i]=(spanLeft[i]==-1)?Integer.MIN_VALUE:histogram[spanLeft[i]];
            valRight[i]=(spanRight[i]==-1)?Integer.MAX_VALUE:histogram[spanRight[i]];
        }
        int area[]= new int[histogram.length];
        calcArea(histogram,area,spanLeft, spanRight);
        System.out.println("Area:"+Arrays.toString(area));

    }
    static void calcArea(int arr[], int area[], int leftInd[], int rightInd[]){
 
        for(int i=0;i<rightInd.length;i++){
            if(rightInd[i]==-1) rightInd[i]=rightInd.length;
        }
        //calc area here
        for(int i=0;i<area.length;i++){
            area[i]=arr[i]*(rightInd[i]-leftInd[i]-1);
        }
        return;

    }
    static void nextRightSmaller(int arr[], int span[]){
        Stack<Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            int curr=arr[i];
            while(!s.empty() && arr[s.peek()]>=curr){
                s.pop();
            }
            if(s.empty()){
                span[i]=-1;
            }else{
                span[i]=s.peek();
            }
            s.push(i);
        }
    }
    static void nextLeftSmaller(int arr[], int span[]){
        Stack<Integer>s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            while(!s.empty() && arr[s.peek()]>=curr){
                s.pop();
            }
            if(s.empty()){
                span[i]=-1;
            }else{
                span[i]=s.peek();
            }
            s.push(i);
        }
    }

}

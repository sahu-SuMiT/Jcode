
// Online IDE - Code Editor, Compiler, Interpreter
import java.util.*;
public class Main
{
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        Student(String name, int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    public static void heapSort(int arr[]){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,i,n);
        }
        
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp; 
            
            heapify(arr,0,i);
        }
    }
    public static void heapify(int arr[], int i, int n){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        
        if(left<n && arr[maxIdx]<arr[left]) maxIdx=left;
        if(right<n && arr[maxIdx]<arr[right]) maxIdx=right;
        
        if(maxIdx != i){
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;
            heapify(arr,maxIdx,n);
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student>pq=new PriorityQueue<>(Comparator.reverseOrder());
        int array[]={1,5,4,3,2,10,9,7,8,6};
        heapSort(array);
        System.out.println(Arrays.toString(array));
        
        
        
    }
    static class Heap{
        ArrayList<Integer>arr=new ArrayList<Integer>();
        public void add(int data){
            arr.add(data);
            int x=arr.size()-1;
            int par=(x-1)/2;
            while(x>0 && arr.get(x)<arr.get(par)){
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                x=par;
                par=(x-1)/2;
                
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void minHeapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            
            if(left<arr.size() && arr.get(left)<arr.get(minIdx)){
                minIdx=left;
            }
            if(right<arr.size() && arr.get(right)<arr.get(minIdx)){
                minIdx=right;
            }
            if(minIdx != i){
                //swap
                int temp=arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                minHeapify(minIdx);
            }
        }
        private void maxHeapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int maxIdx=i;
            
            if(left<arr.size() && arr.get(left)>arr.get(maxIdx)){
                maxIdx=left;
            }
            if(right<arr.size() && arr.get(right)>arr.get(maxIdx)){
                maxIdx=right;
            }
            if(maxIdx != i){
                //swap
                int temp=arr.get(i);
                arr.set(i,arr.get(maxIdx));
                arr.set(maxIdx,temp);
                maxHeapify(maxIdx);
            }
        }
        public void remove(){
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            
            arr.remove(arr.size()-1);
            
            minHeapify(0);
            
            return; 
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
        public void printHeap(){
            int line=1;
            int count=0;
            System.out.println("Here is the heap"+arr.size());
            for(int i : arr){
                count++;
                System.out.print(i+" ");
                
                if(count==line){
                    System.out.println();
                    count=0;
                    line=2*line;
                }
            }
        }
    }
}

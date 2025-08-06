import java.util.*;
public class Main{
    // static class Queue{
    //     Stack<Integer>s;
    //     Queue(){
    //         s=new Stack<>();
    //     }
    //     void add(int val){
    //         Stack<Integer>temp=new Stack<>();
    //         while(!s.empty()){
    //             temp.push(s.pop());
    //         }
    //         s.add(val);
    //         while(!temp.empty()){
    //             s.push(temp.pop());
    //         }
    //     }
    //     int remove(){
    //         return s.pop();
    //     }
    //     int peek(){
    //         return s.peek();
    //     }
    //     boolean empty(){
    //         return s.empty();
    //     }
    // }
    static class Stack{
        static Queue<Integer>q1=new LinkedList<>();
        static Queue<Integer>q2=new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int val){
            if(!q1.isEmpty()){
                q1.add(val);
            }else{
                q2.add(val);
            }     
        }
        public static int pop(){
            if(q1.isEmpty() && q2.isEmpty()){
                System.out.println("Empty Stack");
                return Integer.MIN_VALUE;
            }
            if(!q1.isEmpty()){
                while(q1.size()!=1){
                    q2.add(q1.remove());
                }
                return q1.remove();
            }else{
                while(q2.size()!=1){
                    q1.add(q2.remove());
                }
                return q2.remove();
            }
        }
        public static int peek(){
            if(q1.isEmpty() && q2.isEmpty()){
                System.out.println("Empty Stack");
                return Integer.MIN_VALUE;
            }
            if(!q1.isEmpty()){
                while(q1.size()!=1){
                    q2.add(q1.remove());
                }
                int val=q1.peek();
                q2.add(q1.remove());
                return val;
            }else{
                while(q2.size()!=1){
                    q1.add(q2.remove());
                }
                int val=q2.peek();
                q1.add(q2.remove());
                return val;
            }
        }
    }
    public static void main(String args[]){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}

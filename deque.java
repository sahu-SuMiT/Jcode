import java.util.*;
public class Main{
    static class Queue{
        Deque<Integer>deque=new LinkedList<>();
        public void add(int val){
            deque.addLast(val);
        }
        public int remove(){
            return deque.removeFirst();
        }
        public int peek(){
            return deque.getFirst();
        }
        public int size(){
            return deque.size();
        }
        public boolean isEmpty(){
            return deque.isEmpty();
        }
    }
    static class Stack{
        Deque<Integer>deque=new LinkedList<>();
        public void push(int val){
            deque.addLast(val);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
        public boolean empty(){
            return deque.isEmpty();
        }
    }
    public static void main(String args[]){
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}

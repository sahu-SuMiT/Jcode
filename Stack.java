import java.util.*;
public class Main{
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    static class Stack{
        static Node head=null;
        static boolean isEmpty(){
            return head==null;
        }
        static void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()) {
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        static int pop(){
            if(isEmpty()) return -1;
            int top=head.val;
            head=head.next;
            return top;
        }
        static int peek(){
            if(isEmpty()) return -1;
            return head.val;
        }
    }
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        Node n = new Node(1);
        System.out.print("n.val:"+Integer.MIN_VALUE);

    }
}

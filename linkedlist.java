import java.util.*;
public class Main{
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
        static int size;
        static Node head;
        static Node tail;
        public void print(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.val+" ");
                temp=temp.next;
            } 
            System.out.println();
        }
        public void addFirst(int val){
            Node newNode = new Node(val);
            if(head==null){
                head=tail=newNode;
                size++;
                return;
            }else{
                newNode.next=head;
                head=newNode;
            }
            size++;
        }
        public void addLast(int val){
            Node newNode = new Node(val);
            if(head==null){
                head=tail=newNode;
                size++;
                return;
            }else{
                tail.next=newNode;
                tail=newNode.next;
            }
            size++;
        }
        public void add(int ind, int val){
            if(ind==0){
                addFirst(val);
                return;
            }
            Node temp = head;
            int i=0;
            while(i<ind-1){
                i++;
                temp=temp.next;
            }
            Node r = temp.next;
            Node newNode = new Node(val);
            newNode.next=r;
            temp.next=newNode;
            size++;
        }
        public int removeFirst(){
            if(size==0){
                System.out.println("Failed to delete Empty Linked List");
                return Integer.MIN_VALUE;
            }
            else if(size==1){
                size--;
                int val=head.val;
                head=tail=null;
                return val;
            }
            size--;
            int val=head.val;
            head=head.next;
            return val;
        }
        public int removeLast(){
            if(size==0){
                System.out.println("Failed to delete Empty Linked List");
                return Integer.MIN_VALUE;
            }
            else if(size==1){
                size--;
                int val=head.val;
                head=tail=null;
                return val;
            }
            size--;
            Node temp=head;
            for(int i=0;i<size-2;i++){
                temp=temp.next;
            }
            int val=temp.next.val;
            temp.next=null;
            tail=temp;
            return val;
        }
        public int itrSearch(int key){
            int i=0;
            Node temp=head;
            while(temp!=null){
                if(temp.val==key){
                    return i;
                }
                i++;
                temp=temp.next;
            }
            return -1;
        }
        public int recSearch(int key){
            return recHelper(head,key);
        }
        public int recHelper(Node head, int key){
            if(head==null) return -1;
            if(head.val==key) return 0;
            int ind=recHelper(head.next,key);
            if(ind==-1) return -1;
            else return ind+1;
        }
        public void reverse(){
            Node curr=tail=head, prev=null, next=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            head=prev;
        }
        public Node mid(){
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
        public int getSize(){
            Node curr=head;
            int size=0;
            while(curr!=null){
                curr=curr.next;
                size++;
            }
            return size;
        }
        public boolean checkPalindrome(){
            if(head==null || head.next==null) return true;
            Node midNode=mid();
            Node prev=null;
            Node curr=midNode;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node left=head;
            Node right=prev;
            while(right!=null){
                if(left.val != right.val) return false;
                left=left.next;
                right=right.next;
            }
            return true;
        }
        public boolean hasCycle(){
            if(size==1 && head.next==head){return true;}
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow) return true;
            }
            return false;
        }
        public void removeCycle(){
            boolean cycle=false;
            Node slow=head;
            Node fast=head;
            while(fast!=null || fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(slow==fast){
                    cycle=true;
                    break;
                }
            }
            if(!cycle) return;
            //slow and fast are at the same point at this instant
            //corner case, head=fast=slow
            if(fast==head){
                Node temp=head.next;
                Node prev=null;
                while(temp!=fast){
                    prev=temp;
                    temp=temp.next;
                }
                prev.next=null;
                return;
            }
            //major case
            slow=head;
            Node prev=fast;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            prev.next=null;
            return;
        
        }
        private Node getMid(Node head){
            if(head==null || head.next==null) return head;
            Node slow=head;
            Node fast=head;
            Node prev=null;
            while(fast!=null && fast.next!=null){
                prev=slow;
                slow=slow.next;
                fast=fast.next.next;
            }
            return prev;
        }
        public Node mergeSort(Node head){
            if(head==null || head.next==null){
                return head;
            }
            Node midNode = getMid(head);
            Node right = midNode.next;
            midNode.next=null;
            head=mergeSort(head);
            right=mergeSort(right);
            head=merge(head,right);
            return head;
        }
        public Node merge(Node left, Node right){
            Node newNode= new Node(-1);
            Node curr=newNode;
            while(left!=null && right!=null){
                if(left.val<right.val){
                    curr.next=new Node(left.val);
                    left=left.next;
                }else{
                    curr.next=new Node(right.val);
                    right=right.next;
                }
                curr=curr.next;
            }
            while(left!=null){
                curr.next=new Node(left.val);
                left=left.next;
                curr=curr.next;
            }  
            while(right!=null){
                curr.next=new Node(right.val);
                right=right.next;
                curr=curr.next;
            }
            return newNode.next;           
        }
        public void alternate_merge(){
            Node left=head;
            Node right;
            Node fast=head;
            Node slow=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            Node prev=null;
            Node curr=head;
            while(curr!=null){
                prev=curr;
                curr=curr.next;
            }
            right=prev;
            //reverse the half mid from last
            curr=slow;
            prev=null;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            } 
            //delink the mid
            prev=head;
            curr=head;
            while(curr!=slow){
                prev=curr;
                curr=curr.next;
            }
            prev.next=null;
            //delinked
            Node nextL=left.next;
            Node nextR=right.next;

            while(left!=null&&right!=null){
                nextL=left.next;
                nextR=right.next;
                left.next=right;
                right.next=nextL;

                right=nextR;
                left=nextL;
            }
            print_list(head);
        }
        public void zigZag(){
            //find mid
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            Node mid=slow;

            //reverse second half
            Node curr=mid.next;
            mid.next=null;
            Node prev=null;
            Node next;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            Node left=head;
            Node right=prev;
            Node nextL,nextR;

            //alternate merge
            while(left!=null && right!=null){
                nextL=left.next;
                left.next=right;
                nextR=right.next;
                right.next=nextL;
                
                left=nextL;
                right=nextR;
            }
        }
    }  
    public static void print_list(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node ll = new Node(0);
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.tail.next=ll.head.next.next;
        System.out.println("ll.head.val, ll.tail.val "+ ll.head.val+" "+ll.tail.val);
        // int a = ll.removeFirst();
        // int b = ll.removeLast();
        // int c = ll.recSearch(8);
        
        System.out.println("ll.size "+ ll.size);
        System.out.println("cycle test: "+ll.hasCycle());
        ll.removeCycle();
        System.out.println("cycle test: "+ll.hasCycle());
        ll.addFirst(9);
        ll.addFirst(10);
        ll.print();
        ll.reverse();
        ll.print();
        ll.head=ll.mergeSort(ll.head);
        ll.print();
        ll.zigZag();
        ll.print();
    }

}

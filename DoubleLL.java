public class DoubleLL {
    public class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public DoubleLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int val) {
        if(head == null) {
            head = tail = new Node(val);
            size++;
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }
    public void addLast(int val){
      if(head==null){
        head=tail=new Node(val);
        return;
      }
      Node newNode=new Node(val);
      newNode.prev=tail;
      tail.next=newNode;
      tail=newNode;
      size++;
    }

    public int removeFirst() {
        if(head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1) {
            int val = head.val;
            head = null;
            tail = null;
            size--;
            return val;
        }
        int val = head.val;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }
    public int removeLast(){
      if(head==null){
        System.out.println("DLL is empty");
        return Integer.MIN_VALUE;
      }
      if(size==1){
        int val=head.val;
        head=null;
        tail=null;
        size--;
        return val;
      }
      int val=tail.val;
      tail=tail.prev;
      tail.next=null;
      size--;
      return val;
    }

    public void print() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.val + "<->");
            curr = curr.next;  // This was missing!
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
    public void reverse(){
      if(head==null || size==1)return;
      Node prev=null;
      Node curr=tail=head;
      Node next;
      while(curr!=null){
        next=curr.next;
        curr.next=prev;
        curr.prev=next;

        prev=curr;
        curr=next;
      }
      head=prev;
    }

    public static void main(String args[]) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.print();
        System.out.println(dll.getSize());

        dll.removeLast();
        dll.print();
        System.out.println(dll.getSize());
        dll.addLast(4);
        dll.print();
        System.out.println(dll.getSize());
        System.out.println("dll.head, dll.tail"+dll.head+" "+dll.tail);
        dll.reverse();
        dll.print();
        System.out.println("reversed dll.head, dll.tail"+dll.head+" "+dll.tail);
    }
}

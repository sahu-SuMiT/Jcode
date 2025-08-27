
import java.util.*;

public class Main
{   static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    static boolean validBST(Node root){
        if(root==null) return true;
        if(root.left!=null && root.left.val>=root.val) return false;
        if(root.right!=null && root.right.val<=root.val) return false;
        if(root.left!=null && !validBST(root.left)) return false;
        if(root.right!=null && !validBST(root.right)) return false;
        return true;
    }
    static void isValidBSTHelper(Node root, ArrayList<Integer>inOrder){
        if(root==null) return ;
        isValidBSTHelper(root.left,inOrder);
        inOrder.add(root.val);
        isValidBSTHelper(root.right,inOrder);
    }
    static boolean isValidBST(Node root){
        if(root==null) return true;
        ArrayList<Integer>inOrder=new ArrayList<>();

        isValidBSTHelper(root,inOrder);
        for(int i: inOrder){
            System.out.print(i+" ");
        }
        for(int i=0;i<inOrder.size()-1;i++){
            if(inOrder.get(i)>=inOrder.get(i+1)){
                return false;
            }
        }
        return true;
    }
    static Node insert(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.val>val){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    static void printTree(Node root, int space) {
        if (root == null) return;

        // Increase distance between levels
        space += 5;

        // Print right child first (so it appears on top)
        printTree(root.right, space);

        // Print current node after spaces
        System.out.println();
        for (int i = 5; i < space; i++) System.out.print(" ");
        System.out.println(root.val);

        // Print left child
        printTree(root.left, space);
    }
    static boolean isValidBST(Node root,Node min, Node max){
        if(root==null) return true;
        if(min!=null && root.val<=min.val) return false;
        if(max!=null && root.val>=max.val) return false;
        return (isValidBST(root.left,min,root)&&isValidBST(root.right,root,max));
    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        Info(boolean isBST, int size, int min, int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    static int maxNodes=0;
    static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftTree=largestBST(root.left);
        Info rightTree=largestBST(root.right);
        boolean isBST= (leftTree.max < root.val) && (root.val < rightTree.min) && leftTree.isBST && rightTree.isBST;
        int size=leftTree.size+rightTree.size+1;
        if(isBST) maxNodes=Math.max(maxNodes,size);
        int max=Math.max(root.val, Math.max(leftTree.max,rightTree.max));
        int min=Math.min(root.val,Math.min(leftTree.min,rightTree.min));
        return new Info(isBST,size,min,max);
    }
    static Node merge2BST(Node root1, Node root2){
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        inOrder(root1,list1);
        inOrder(root2,list2);
        ArrayList<Integer>combinedList=new ArrayList<>();
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                combinedList.add(list1.get(i++));
            }else{
                combinedList.add(list2.get(j++));
            }
        }
        
        while(i<list1.size()){
            combinedList.add(list1.get(i++));
        }
        while(j<list2.size()){
            combinedList.add(list2.get(j++));
        }
        Node root=balanced_tree(null,combinedList);
        return root;
    }
    static void inOrder(Node root, ArrayList<Integer>list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);

    }
    static Node balanced_tree(Node root,ArrayList<Integer>arr){
        if(arr.size()==0)return null;
        int mid=arr.size()/2;
        root=insert(root,arr.get(mid));
        ArrayList<Integer>leftArr=new ArrayList<>();
        ArrayList<Integer>rightArr=new ArrayList<>();
        int i=0;
        for(i=0;i<mid;i++){
            leftArr.add(arr.get(i));
        }
        for(i=mid+1;i<arr.size();i++){
            rightArr.add(arr.get(i));
        }
        root.left=balanced_tree(root.left,leftArr);
        root.right=balanced_tree(root.right,rightArr);
        return root;
    }
    static Node mirror(Node root){
        if(root==null) return root;
        Node ls=mirror(root.left);
        Node rs=mirror(root.right);
        root.left=rs;
        root.right=ls;
        return root;
    }
    public static void main(String[] args) {
        
        Node root=new Node(50);
        root.left=new Node(30);
        root.right=new Node(60);
        root.left.left=new Node(5);
        root.left.right=new Node(20);
        root.right.left=new Node(45);
        root.right.right=new Node(70);
        root.right.right.left=new Node(65);
        root.right.right.right=new Node(80);
        
        printTree(root,0);
        Info info=largestBST(root.left);
        System.out.println("info:"+info.isBST+" "+ info.size+" "+ info.min+" "+ info.max);
        System.out.println("Largest BST of Size: "+maxNodes);
    }
}

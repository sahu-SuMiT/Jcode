
import java.util.*;
public class Main
{   
    static class Node{
        int val;
        Node left,right;
        Node(int val){
            this.val=val;
        }
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
    static boolean search(Node root, int val){
        if(root==null)return false;
        if(root.val==val)return true;
        if(val<root.val) return search(root.left,val);
        else return search(root.right,val);
    }
    static Node delete(Node root,int val){
        if(root.val>val)root.left=delete(root.left,val);
        else if(root.val<val) root.right=delete(root.right,val);
        else{
            //leaf node
            if(root.left==null && root.right==null) return null;
            //single child case
            else if(root.right==null) return root.left;
            else if(root.left==null) return root.right;
            //double child case
            else{
                Node IS=immediateSuccessor(root);
                root.val=IS.val;
                root.right=delete(root.right,IS.val);
            }
        }
        return root;
    }
    static Node immediateSuccessor(Node root){
        root=root.right;
        while(root.left!=null) root=root.left;
        return root;
    }
    static void printInRange(Node root, int k1, int k2){
        if(root==null) return;
        if(root.val<k1){
            printInRange(root.right,k1,k2);
        }
        if(k2<root.val){
            printInRange(root.left,k1,k2);
        }
        if(k1<=root.val && root.val<=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.val+" ");
            printInRange(root.right,k1,k2);
        }
    }
    static void pathToLeaf(Node root,ArrayList<Integer>list){
        if (root == null) {
            return;
        }
        if(root.left==null && root.right==null){
            list.add(root.val);
            for(int item:list){
                System.out.print(item+" ");
            }
            System.out.println();
            if(list.size()>0) list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        pathToLeaf(root.left,list);
        pathToLeaf(root.right,list);
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        int values[]={8,5,3,6,10,11,14};
        Node root=null;
        for(int val : values){
            root=insert(root,val);
        }
        printTree(root,0);
        ArrayList<Integer>list=new ArrayList<>();
        pathToLeaf(root,list);
    }
}

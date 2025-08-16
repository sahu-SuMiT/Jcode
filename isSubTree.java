// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
        static boolean isSubtree(TreeNode root,TreeNode subRoot){
            return (bfsFind(root, subRoot));
        }
    }
    static boolean bfsFind(TreeNode root, TreeNode node){
        if(root==null || node==null) return false;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        TreeNode currTreeNode=null;
        while(!q.isEmpty()){
            currTreeNode=q.remove();
            if(currTreeNode.val==node.val) break;
            if(currTreeNode.left!=null) q.add(currTreeNode.left);
            if(currTreeNode.right!=null) q.add(currTreeNode.right);
        }
        if(q.isEmpty() && currTreeNode.val!=node.val){
            System.out.println("subroot Not found");
        }
        System.out.println("Found subroot: "+currTreeNode.val);
        q.clear();
        Queue<TreeNode>q2=new LinkedList<>();
        q.add(currTreeNode);
        TreeNode subTreeNode=node;
        q2.add(subTreeNode);
        
        while(!q.isEmpty() && !q2.isEmpty()){
            System.out.println("q1,q2 peek "+q.peek().val +" "+q2.peek().val);
            currTreeNode=q.remove();
            subTreeNode=q2.remove();
            System.out.println("comparing: "+currTreeNode.val+" "+subTreeNode.val+" "+(currTreeNode.val==subTreeNode.val));
            if(currTreeNode.val==subTreeNode.val){
                if(currTreeNode.left!=null) q.add(currTreeNode.left);
                if(currTreeNode.right!=null) q.add(currTreeNode.right);
                if(subTreeNode.left!=null) q2.add(subTreeNode.left);
                if(subTreeNode.right!=null) q2.add(subTreeNode.right);
            }else{
                return false;
            }
        }
        if(q.size()!=q2.size()) return false;
        return true;
    } 
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        
        TreeNode subRoot=new TreeNode(2);
        subRoot.left=new TreeNode(4);
        subRoot.right=new TreeNode(5);
        
        boolean ans=root.isSubtree(root,subRoot);
        System.out.println(ans);
        
    }
}

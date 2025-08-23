
// Online IDE - Code Editor, Compiler, Interpreter
import java.util.*;
public class Main
{   
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    static int sum(Node root){
        if(root==null) return 0;
        int lSum=sum(root.left);
        int rSum=sum(root.right);
        int currVal=root.val;
        root.val=lSum+rSum;
        return currVal+root.val;
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
    static boolean multivalued(Node root, Set<Integer>set){
        if(root==null) return false;
        if(set.contains(root.val))return true;
        set.add(root.val);
        if(multivalued(root.left,set)) return true;
        if(multivalued(root.right,set)) return true;
        return false;
    }
    static boolean univalued(Node root, Set<Integer>set){
        return !multivalued(root,set);
    }
    static class Info{
        Node node;
        int level;
        Info(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    static boolean mirror(Node root,Node root2){
        Queue<Info>q1=new ArrayDeque<>();
        Queue<Info>q2=new ArrayDeque<>();
        ArrayList<Integer>list1=new ArrayList<>(); ArrayList<Integer>list2=new ArrayList<>();
        q1.add(new Info(root,0)); q2.add(new Info(root2,0));
        while(!q1.isEmpty() && !q2.isEmpty()){
            int currLevel=Math.min(q1.peek().level,q2.peek().level);
            while(!q1.isEmpty() && q1.peek().level==currLevel){
                Info currInfo=q1.remove();
                list1.add(currInfo.node.val);
                if(currInfo.node.left!=null)q1.add(new Info(currInfo.node.left,currLevel+1));
                if(currInfo.node.right!=null)q1.add(new Info(currInfo.node.right,currLevel+1));
            }
            while(!q2.isEmpty() && q2.peek().level==currLevel){
                Info currInfo=q2.remove();
                list2.add(currInfo.node.val);
                if(currInfo.node.left!=null)q2.add(new Info(currInfo.node.left,currLevel+1));
                if(currInfo.node.right!=null)q2.add(new Info(currInfo.node.right,currLevel+1));
            }
            if(list1.size()!=list2.size()) return false;
            for(int i=0;i<list1.size();i++){
                if(list1.get(i)!=list2.get(list1.size()-i-1)) return false;
            }
            list1.clear();
            list2.clear();

        }
        return true;
    }
    static boolean deleteLeafs(Node root, int val){
        if(root==null)return false;
        if(root.val==val && root.left==null && root.right==null) return true;
        boolean canDeleteLeft=deleteLeafs(root.left,val);
        boolean canDeleteRight=deleteLeafs(root.right,val);
        if(canDeleteLeft) root.left=null;
        if(canDeleteRight) root.right=null;
        return false;
    }
    static void subtrees(Node root){
        HashMap<String,Integer>stringsCount=new HashMap<>();
        postOrder(root,stringsCount);
        Set<String>keySet=new HashSet<>(stringsCount.keySet());
        for(String key : keySet){
            if(stringsCount.get(key)>1){
                System.out.print(key.charAt(key.length()-1)+", ");
            }
            
        }
    }
    static String postOrder(Node root,HashMap<String,Integer>stringsCount){
        if(root==null) return "#";
        String leftString=postOrder(root.left,stringsCount);
        String rightString=postOrder(root.right,stringsCount);
        String currString=leftString+rightString+root.val;
        stringsCount.put(currString,stringsCount.getOrDefault(currString,0)+1);
        return currString;
    }
    static int maxSum;
    static int maxSum(Node root){
        if(root==null)return 0;
        int leftMaxPathSum=maxSum(root.left);
        int rightMaxPathSum=maxSum(root.right);
        int selfMaxSum=leftMaxPathSum+rightMaxPathSum+root.val;
        maxSum=Math.max(selfMaxSum,maxSum);
        System.out.println("From node:"+(root.val)+"maxSum"+maxSum+"returningMaxPatSum:"+(Math.max(leftMaxPathSum,rightMaxPathSum)+root.val));
        return Math.max(leftMaxPathSum,rightMaxPathSum)+root.val;
        
    }
    public static void main(String args[]){
        Node root=new Node(-10);
        root.left=new Node(-9);
        root.right=new Node(20);
        root.right.left=new Node(15);
        root.right.right=new Node(7);
        
        int ans=maxSum(root);
        System.out.println("maxPathsum"+maxSum);
    }
}

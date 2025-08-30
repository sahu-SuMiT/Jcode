public class Main{
  static class Node{
    int val,height;
    Node left, right;
    Node(int val){
      this.val=val;
    }
    Node(int val, int height){
      this.val=val;
      this.height=height;
    }
  }
  static Node insert(Node root, int val){
    if (root==null){
      root=new Node(val);
      return root;
    }
    if(val>root.val){
      root.right=insert(root.right,val);
    }else if(val<root.val){
      root.left=insert(root.left,val);
    }
    else{
      return root;
    }
    root.height=height(root);
    // System.out.println("Height of root"+root.val+" "+ root.height);
    int bf=getBalanceFactor(root);
    // System.out.println("bf of root "+root.val+" "+bf);
    //LL case
    if(bf>1 && val<root.left.val){
      root=rightRotate(root);
      return root;
    }
    //RR case
    if(bf<-1 && val>root.right.val){
      root=leftRotate(root);
      return root;
    }
    //LR case
    if(bf>1 && val>root.left.val){
      root.left=leftRotate(root.left);
      root=rightRotate(root);
      return root;
    }
    //RLcase
    if(bf<-1 && val<root.right.val){
      root.right=rightRotate(root.right);
      root=leftRotate(root);
      return root;
    }
    return root;
  }
  static int getBalanceFactor(Node root){
    if(root==null){
      return 0;
    }
    return height(root.left)-height(root.right);
  }
  static int height(Node root){
    if(root==null) return 0;
    return 1+Math.max(height(root.left), height(root.right));
  }
  static Node leftRotate(Node y){
    if(y==null || y.right==null) return  y;
    Node x=y.right;
    Node T2=x.left;

    x.left=y;
    y.right=T2;
    return x;
  }
  static Node rightRotate(Node y){
    if(y==null || y.left==null) return  y;
      Node x=y.left;
      Node T2=x.right;

      x.right=y;
      y.left=T2;
      return x;
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
  static Node delete(Node root, int key){
    if(root==null)return root;
    if(key<root.val){
        root.left=delete(root.left,key);
    }else if(key>root.val){
        root.right=delete(root.right,key);
    }else{
        if(root.left==null && root.right==null) return null;
        else if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            Node IS=immediateSuccessor(root);
            root.val=IS.val;
            root.right=delete(root.right,IS.val);
        }
    }
    int bf=getBalanceFactor(root);
    // System.out.println("bf of root "+root.val+" "+bf);
    //LL case
    if(bf>1 && key<root.left.val){
      root=rightRotate(root);
      return root;
    }
    //RR case
    if(bf<-1 && key>root.right.val){
      root=leftRotate(root);
      return root;
    }
    //LR case
    if(bf>1 && key>root.left.val){
      root.left=leftRotate(root.left);
      root=rightRotate(root);
      return root;
    }
    //RLcase
    if(bf<-1 && key<root.right.val){
      root.right=rightRotate(root.right);
      root=leftRotate(root);
      return root;
    }
    
    return root;
  }
  static Node immediateSuccessor(Node root){
      root=root.right;
      while(root.left!=null){
          root=root.left;
      }
      return root;
  }
  public static void main(String[] args){
    Node root=new Node(3);
    root=insert(root,2);
    root=insert(root,1);

    root=insert(root,10);
    root=insert(root,20);
    root=insert(root,30);
    
    root=delete(root,30);
    root=delete(root,20);
    root=delete(root,10);
    printTree(root,0);
    
  }
}

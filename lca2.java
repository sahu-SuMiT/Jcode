    static Node lca(Node root, int n1, int n2){
        if(root==null || root.val==n1 || root.val==n2) return root;
        
        Node leftLca=lca(root.left,n1,n2);
        Node rightLca=lca(root.right,n1,n2);
        
        if(leftLca==null) return rightLca;
        if(rightLca==null) return leftLca;
        
        return root;
    }

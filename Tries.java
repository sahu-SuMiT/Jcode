
// Online IDE - Code Editor, Compiler, Interpreter

public class Main
{   
    static class Node{
        Node[] children;
        boolean eow;
        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    } 
    
    public static Node root=new Node();
    static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
     
        }
        curr.eow=true;
    }
    static boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        if(curr.eow==true)
            return true;
        else
            return false;
    }
    static boolean wordBreak(String key){
        if(key.length()==0) return true;
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i))&&wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[]={"i","like","sam","samsung","mobile","ice"};
        for(String word:words){
            insert(word);
        }
        String key="ilikesamsung";
        System.out.print(wordBreak(key));
       
        
    }
}

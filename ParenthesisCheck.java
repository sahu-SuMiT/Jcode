import java.util.*;
public class Main{
    public static void main(String args[]){ 

        System.out.println(extraBraces("(a-b)"));
    }
    static boolean parenthesisCheck(String braces){
        Stack<Character>s=new Stack<>();
        for(int i=0;i<braces.length();i++){
            char currChar=braces.charAt(i);
            if(currChar=='(' || currChar=='{' || currChar=='[') s.push(currChar);
            else{
                if(s.empty()) return false;
                if(currChar==')' && s.peek()=='(') s.pop();
                if(currChar=='}' && s.peek()=='{') s.pop();
                if(currChar==']' && s.peek()=='[') s.pop(); 
               
            }
        }
        if(s.empty()) return true;
        else return false;
    }
    static boolean extraBraces(String str){
        Stack<Character>s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            if(currChar!=')'){
                s.push(currChar);
            }else{
                int count=0;
                System.out.println("itr:"+i);
                printStack(s);
                while(s.peek()!='('){
                    count++;
                    System.out.print(count+" ");
                    s.pop();
                }
                s.pop();
                System.out.print("count:"+count);
                printStack(s);
                if(count<=0) return true;
                System.out.println("itr:"+i);
            }
        }
        return false;
    }
    static void printStack(Stack<Character>s){
        
        Stack<Character>temp=new Stack<>();
        StringBuilder sb= new StringBuilder("");
        System.out.print("Stack top->");
        if(s.empty()) return;
        while(!s.empty()){
            sb.append(s.peek().toString());
            sb.append(" ");
            temp.push(s.pop());
        }
        sb.reverse();
        System.out.print(sb.toString());
        System.out.println();
        while(!temp.empty()){
            s.push(temp.pop());
        }
    }

}

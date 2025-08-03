import java.util.*;
public class Main{
    public static void main(String args[]){
        String input = "2[cb]";
        recPrint(input);
    }
    static boolean isADigit(char a){
        return ('0'<=a && a<='9');
    }
    static int charToInt(char a){
        return(a-'0');
    }
    static void recPrint(String str){
        Stack<Character>stringStack=new Stack<>();
        Stack<Integer>intStack=new Stack<>();
        int count=0;String temp="",result="";
        for(int i=0;i<str.length();i++){
            // System.out.print("itr: "+i);
            if(isADigit(str.charAt(i))){
                count=charToInt(str.charAt(i));
                i++;
                while(isADigit(str.charAt(i))){
                    count=count*10+charToInt(str.charAt(i));
                    i++;
                }
                i--;
            }
            else if(str.charAt(i)=='['){
                if(i>0 && isADigit(str.charAt(i-1))){
                    intStack.push(count);
                    stringStack.push(str.charAt(i));
                }else{
                    intStack.push(1);
                    stringStack.push(str.charAt(i));
                }
            }
            else if(str.charAt(i)==']'){
                while(!stringStack.empty() && stringStack.peek()!='['){
                    temp= stringStack.peek()+temp;
                    stringStack.pop();
                }
                if(stringStack.peek()=='['){
                    stringStack.pop();
                }
                count=intStack.pop();
                for(int j=0;j<count;j++){
                    result+=temp;
                }
                for(int j=0; j<result.length();j++){
                    stringStack.push(result.charAt(j));
                }
                result="";
                temp="";
            }
            else{
                stringStack.push(str.charAt(i));
            }
        }
        result="";
        while(!stringStack.empty()){
            result=stringStack.pop()+result;
        }
        System.out.println(result);
    }
    
}

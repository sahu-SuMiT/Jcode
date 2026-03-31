// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.io.*;
class Main {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null||!st.hasMoreElements()){
                try{
                    String line=br.readLine();
                    if(line==null)return null;
                    st=new StringTokenizer(line);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
    static void solve(){
        //your code here 
    }
    public static void main(String[] args) {
        FastReader fs=new FastReader();
        int t=fs.nextInt();
        while(t-->0){
            solve();
        }
    }
}

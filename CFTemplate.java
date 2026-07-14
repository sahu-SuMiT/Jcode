import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String[] scanStringArray(int n) {
            String[] a = new String[n];
            for (int i = 0; i < n; i++) a[i] = next();
            return a;
        }

        int[] scanIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] scanLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final double EPS = 1e-9;
    static final int MOD = (int) 1e9 + 7;
    static final int INT_MIN=Integer.MIN_VALUE;
    static final int INT_MAX=Integer.MAX_VALUE;
    static final long LONG_MIN=Long.MIN_VALUE;
    static final long LONG_MAX=Long.MAX_VALUE;
    
    static int mod(long x){
        return (int)((x%MOD+MOD)%MOD);
    }
    

    static void cout(Object o) { out.print(o); }
    static void coutln(Object o) { out.println(o); }
    static void coutln() { out.println(); }

    static void yes() { out.println("YES"); }
    static void no() { out.println("NO"); }

    static long gcd(long a, long b) {
        return (a == 0) ? b : gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    static long binExp(long a, long b){
        long res = 1;
        while(b > 0){
            if((b & 1) == 1) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    static void solve(FastScanner sc) {
        int n = sc.nextInt();
        long k = sc.nextLong();
        yes();
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
        out.flush();
    }
}

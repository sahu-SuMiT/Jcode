    static final double EPS = 1e-9;
    static final int MOD = (int) 1e9 + 7;
    static final int INT_MIN=Integer.MIN_VALUE;
    static final int INT_MAX=Integer.MAX_VALUE;
    static final long LONG_MIN=Long.MIN_VALUE;
    static final long LONG_MAX=Long.MAX_VALUE;
    
    static int mod(long x){
        return (int)((x%MOD+MOD)%MOD);
    }
    

    static void cout(Object o) { System.out.print(o); }
    static void coutln(Object o) { System.out.println(o); }
    static void coutln() { System.out.println(); }

    static void truncate(int[] arr, int limit) {
        if (arr.length <= limit){
            coutln(Arrays.toString(arr));
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < limit; i++)sb.append(arr[i]).append(", ");
        sb.append("]");
        System.out.println(sb.toString());
    }

    static String truncate(long[] arr, int limit) {
        if (arr.length <= limit) {
            coutln(Arrays.toString(arr));
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < limit; i++)sb.append(arr[i]).append(", ");
        sb.append("]");
        coutln(sb.toString());
    }

class Main {
    static int n=7;
    static int[] rank=new int[n];
    static int[]par=new int[n];
    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }
    static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    static void union(int a, int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parA]=parB;
            rank[parB]++;
        }else if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }else{
            par[parA]=parB;
        }
    }
    public static void main(String[] args) {
        init();
        union(1,3);
        union(2,4);
        union(3,6);
        union(1,4);
        union(1,5);
        System.out.println(find(2));
    }
}

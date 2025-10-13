    static int kruskals(ArrayList<Edge>graph){
        int V=graph.size();
        Collections.sort(graph,(a,b)->{
            return a.wt-b.wt;
        });
        int mstCost=0;
        for(int i=0;i<V-1;i++){
            Edge e=graph.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);
            if(parA!=parB){
                union(e.src,e.dest);
                mstCost+=e.wt;
            }
        }
        return mstCost;
    }

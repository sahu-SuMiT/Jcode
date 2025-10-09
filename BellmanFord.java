public static void bellmanFord(ArrayList<Edge>graph[],int src){
        int dist[]=new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        //algo
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            //edges-O(E)
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    //u,v,w
                    int u=e.src,v=e.dest,wt=e.wt;
                    //relax
                    if(dist[u]!=Integer.MAX_VALUE &&  dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        
        System.out.println(Arrays.toString(dist));
    }

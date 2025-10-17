    static void Allap(ArrayList<Edge>[]graph){
        int V=graph.length;
        int[]low=new int[V];
        int[]dt=new int[V];
        int time=0;
        boolean[]vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs_ap(graph,i,-1,vis,time,dt,low);
            }
        }
    }
    
    static void dfs_ap(ArrayList<Edge>[]graph,int src, int par,boolean[]vis,int time, int[]dt,int[]low){
        vis[src]=true;
        dt[src]=low[src]=++time;
        int children=0;
        for(Edge e:graph[src]){
            if(e.dest==par)continue;
            else if(vis[e.dest]) low[src]=Math.min(low[src],dt[e.dest]);
            else{
                dfs_ap(graph,e.dest,src,vis,time,dt,low);
                low[src]=Math.min(low[src],low[e.dest]);
                if(par!=-1&&dt[src]<=low[e.dest]){
                    System.out.println("Ap:"+src);
                }
                children++;
            }
        }
        if(par==-1 && children>1){
            System.out.println("Ap:"+src);
        }
    }

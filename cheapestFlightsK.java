    static class Item{
        int v;
        int cost;
        int stops;
        Item(int v, int cost,int stops){
            this.v=v;
            this.cost=cost;
            this.stops=stops;
        }
    }
    static int cheapestFlightsK(ArrayList<Edge>graph[],int src, int dest, int k){
        Queue<Item>q=new ArrayDeque<>();
        q.add(new Item(src,0,0));
        int[]dist=new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            Item curr=q.remove();
            if(curr.stops>k) break;
            for(Edge e:graph[curr.v]){
                if(curr.stops<=k && curr.cost+e.w<dist[e.d]){
                    dist[e.d]=curr.cost+e.w;
                }
                q.add(new Item(e.d,curr.cost+e.w,curr.stops+1));
            }
        }
        if(dist[dest]==Integer.MAX_VALUE) return -1;
        return dist[dest];
    }

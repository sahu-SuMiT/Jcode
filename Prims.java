    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        Pair(int v, int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    static int prims(ArrayList<Edge>graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int finalCost=0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalCost+=curr.cost;
                for(Edge e:graph[curr.v]){
                    pq.add(new Pair(e.d,e.w));
                }
            }
        }
        return finalCost;

    }

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    static class Edge{
        int src, dest, wt;
        Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static ArrayList<Edge>[] createGraph(){
        int V=6;
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        
        graph[2].add(new Edge(2, 4, 3));
        
        graph[3].add(new Edge(3, 5, 1));
        
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        return graph;
    }
    static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    static void dijkstra(ArrayList<Edge>[]graph,int dist[],int src){
        PriorityQueue<Pair>pq=new PriorityQueue<>((p1,p2)->{return p1.dist-p2.dist;});
        pq.add(new Pair(src,0));
        dist[src]=0;
        boolean vis[]=new boolean[graph.length];
        
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                for(Edge e:graph[curr.node]){
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[]graph=createGraph();
        int[]dist=new int[6];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(graph,dist,0);
        System.out.println(Arrays.toString(dist));
        for(int i=0;i<dist.length;i++){
            System.out.println(i+"("+dist[i]+")");
        }
        
    }
}

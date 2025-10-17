





import java.util.*;
public class Main
{
    static class Edge{
        int src,dest;
        Edge(int src,int dest){this.src=src;this.dest=dest;};
        @Override
        public String toString(){
            return this.src+"->"+this.dest;
        }
    }
    static ArrayList<Edge>[] createGraph(int V){
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
    
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        
    
        return graph;
    }
    static void tarjan(ArrayList<Edge>[]graph){
        int V=graph.length;
        int[]low=new int[V];
        int[]dt=new int[V];
        int time=0;
        boolean[]vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs_bridge(graph,vis,i,-1,time,dt,low);
            }
        }
    }
    static void dfs_bridge(ArrayList<Edge>[]graph,boolean[]vis,int src,int par,int time,int[]dt,int[]low){
        vis[src]=true;
        dt[src]=low[src]=++time;
        for(Edge e:graph[src]){
            if(e.dest==par)continue;
            else if(!vis[e.dest]){
              dfs_bridge(graph,vis,e.dest,src,time,dt,low);
              low[src]=Math.min(low[src],low[e.dest]);
              if(dt[src]<low[e.dest]){
                  System.out.println("bridge "+src+"-"+e.dest);
              }
            }
            else{
                low[src]=Math.min(dt[e.dest],low[src]);
            }
        }
    }
	public static void main(String[] args) {
	    int V=6;
		ArrayList<Edge>[] graph=createGraph(V);
        tarjan(graph);
	}
}

import java.util.*;

public class Main {
    static class Edge{
        int src,dest,wt;
        String color;
        Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
            this.color="white";
        }
    }
    public static ArrayList<Edge>[] createGraph(int V){
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        // graph[0].add(new Edge(0,2,1));
        // graph[0].add(new Edge(0,3,1));

        //graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,2,1));

        //graph[2].add(new Edge(2,0,1));
        // graph[2].add(new Edge(2,1,1));

        // graph[3].add(new Edge(3,0,1));
        // graph[3].add(new Edge(3,4,1));
        
        // graph[4].add(new Edge(4,3,1));
       
        return graph;
    }
    static boolean isCycle(ArrayList<Edge>[]graph){
        boolean[]stack=new boolean[graph.length];
        boolean[]vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(isCycleUtil(graph,i,vis,stack)) return true;
        }
        return false;
    }
    static boolean isCycleUtil(ArrayList<Edge>[]graph,int curr,boolean[]stack,boolean[]vis){
        vis[curr]=true;
        stack[curr]=true;
        for(Edge neib:graph[curr]){
            if(stack[neib.dest]==true){
                return true;
            }
            if(!vis[neib.dest]&&isCycleUtil(graph,neib.dest,stack,vis)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    static boolean isBipartite(ArrayList<Edge>[]graph){
        boolean[]vis=new boolean[graph.length];
        int[]color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(!vis[i]) bipartiteUtil(graph,i,color,vis);
        }
        Arrays.fill(vis,false);
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                vis[i]=true;
                for(Edge e:graph[i]){
                    if(color[e.dest]==color[i])return false;
                }
            }
        }
        return true;
    }
    static void bipartiteUtil(ArrayList<Edge>[]graph,int src,int[]color,boolean[]vis){
        Queue<Integer>q=new ArrayDeque<>();
        q.add(src);
        color[src]=0;
        while(!q.isEmpty()){
            int currNode=q.remove();
            if(vis[currNode])continue;
            vis[currNode]=true;
            int nodeColor=color[currNode];
            for(Edge e:graph[currNode]){
                if(vis[e.dest]) continue;
                q.add(e.dest);
                color[e.dest]=1-nodeColor;
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Edge>[]graph=createGraph(5);
        System.out.println(isCycle(graph));
    }
}

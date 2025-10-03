import java.util.*;
public class Main{
    static class Edge{
        int src,dest,wt;
        Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static ArrayList<Edge>[] createGraph(int V){
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
        
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
       
        return graph;
    }
    public static void main(String a[]){
        int V=7;
        ArrayList<Edge>[]graph=createGraph(V);


        bfs(graph,0);
        System.out.println("--");
        dfs(graph,0);

        // hasPath(graph,new boolean[graph.length],0,6);
        // System.out.println(path);

    }
    static void bfs(ArrayList<Edge>[]graph,int src){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            bfsUtil(graph,vis,i);
        }
    }
    static void bfsUtil(ArrayList<Edge>[]graph,boolean[]vis,int src){
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    if(!vis[e.dest]){
                        q.add(e.dest);
                    }
                }
            }
        }
    }
    static ArrayList<Integer>path=new ArrayList<>();
    static boolean hasPath(ArrayList<Edge>[]graph,boolean vis[],int src, int dest){
        //System.out.println("call for src:"+src);
        path.add(src);
        vis[src]=true;
        if(src==dest){
            return true;
        }
        for(Edge e:graph[src]){
            if(!vis[e.dest] && hasPath(graph,vis,e.dest,dest)){
                return true;
            }
        }
        path.remove(path.size()-1);
        return false;
    }
    static void dfs(ArrayList<Edge>[]graph,int src){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i])
                dfsUtil(graph,vis,i);
        }
    }
    static void dfsUtil(ArrayList<Edge>[]graph, boolean vis[], int src){
        vis[src]=true;
        System.out.print(src+" ");
        for(Edge e:graph[src]){
            if(!vis[e.dest])
                dfsUtil(graph,vis,e.dest);
        }

    }
      static boolean detectCycle(ArrayList<Edge>[]graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i] && detectCycleUtil(graph,vis,i,-1))
                return true;
        }
        return false;
    }
    static boolean detectCycleUtil(ArrayList<Edge>[]graph,boolean[]vis,int node,int parent){
        vis[node]=true;
        for(int i=0;i<graph[node].size();i++){
            Edge e=graph[node].get(i);
            if(!vis[e.dest]){
                if(detectCycleUtil(graph,vis,e.dest,node))
                    return true;
            }
            else if(vis[e.dest]&&e.dest!=parent){
                return true;
            }
                
            
        }
        return false;
    }

}

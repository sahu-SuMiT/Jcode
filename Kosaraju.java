





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
    //kosaraju
    static void connected_components(ArrayList<Edge>[]graph,Stack<Integer>res){
        boolean[]vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]) topoSort(graph,res,vis,i);
        }
    }
    static void topoSort(ArrayList<Edge>[]graph,Stack<Integer>res,boolean[]vis,int src){
        vis[src]=true;
        for(Edge e:graph[src]){
            if(!vis[e.dest]){
                topoSort(graph,res,vis,e.dest);
            }
        }
        res.push(src);
    }
    //transpose the graph
    
    static ArrayList<Edge>[] transpose(ArrayList<Edge>[]graph){
        ArrayList<Edge>[]transpose=new ArrayList[graph.length];
        for(int i=0;i<graph.length;i++){
            transpose[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            for(Edge e:graph[i]){
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        for(int i=0;i<graph.length;i++){
            System.out.println(transpose[i]);
        }
        return transpose;
    }
    
    static void dfs(ArrayList<Edge>[]graph,int src,boolean[]vis){
        vis[src]=true;
        System.out.print(src+"->");
        for(Edge e:graph[src]){
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }
    static void cc_dfs(ArrayList<Edge>[]graph,Stack<Integer>res){
        boolean[]vis=new boolean[graph.length];
        while(!res.empty()){
            int src=res.pop();
            if(!vis[src]){
                System.out.println(src+"is not visited");
            }
            
            if(!vis[src]){dfs(graph,src,vis); System.out.println();}
        }
    }
    //dfs on transpose
    static void kosaraju(ArrayList<Edge>[]graph){
        Stack<Integer>res=new Stack<>();
        //topo sort stack
        connected_components(graph,res);
        //transpose
        
        ArrayList<Edge>[]transpose=transpose(graph);
        //dfs the transpose
        cc_dfs(transpose,res);

    }
    static ArrayList<Edge>[] createGraph(int V){
        ArrayList<Edge>[]graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        
        
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        
        graph[1].add(new Edge(1, 0));
    
        graph[2].add(new Edge(2, 1));
    
        graph[3].add(new Edge(3, 4));
    
        return graph;
    }
	public static void main(String[] args) {
	    int V=5;
	    ArrayList<Edge>[]graph=createGraph(V);
		kosaraju(graph);
	}
}

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
        graph[2].add(new Edge(2,3,1));

        graph[3].add(new Edge(3,1,1));

        graph[4].add(new Edge(4,1,1));
        graph[4].add(new Edge(4,0,1));

        graph[5].add(new Edge(5,0,1));
        graph[5].add(new Edge(5,2,1));
       
        return graph;
    }
    static void topSort(ArrayList<Edge>graph[]){
        //find indegree
        Queue<Integer>q=new LinkedList<>();
        int[]indegree=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(Edge e:graph[i]){
                indegree[e.dest]++;
            }
        }
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");
            for(Edge e:graph[curr]){
                indegree[e.dest]--;
                if(indegree[e.dest]==0) q.add(e.dest);
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Edge>[]graph=createGraph(6);
        topSort(graph);
    }
}

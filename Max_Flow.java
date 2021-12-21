/**
 * Section : IAR 
 * @author Batol Ahmed Alwagdani
 * @author Sarah Mohammed AlJumai
 * @author Joud Mohammed Alsuhiabani
 */

/**
 * CPCS 324 Project - Part 2
 * Question 2 Task 2
 * This program is designed to find the maximum flow matching  based on Emonds-Karp algorithm
 * of a given graph represented 
 * 
 */
import java.util.LinkedList;
import java.util.Scanner;
public class Max_Flow {
    /**
     * main function
     */
    public static void main(String[] args) throws java.lang.Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------");
        System.out.println("\t\t \t  Maximum Flow  calculator ");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Please enter the number of vertices and number of edges : ");
       
       int ver = input.nextInt();
       int edge = input.nextInt();

       Graph graph = new Graph(ver, edge);
        int[][] WeightedGraph = graph.MakeGraph(graph);
        //send the graph ,the source and the sink to the maxflow method
        MaxFlow(WeightedGraph, 0, WeightedGraph.length - 1);
    }

    
    /**
     * 
     * @param graph
     * @param source 
     * @param sink 
    
    *Edmonds-Karp maximum-flow algorithm using BFS to find the maximum flow of the network,
     and the corresponding min-cut using DFS
     */
    public static void MaxFlow(int[][] graph, int source, int sink) {
        System.out.println("\n-----------------------------------------------");
        System.out.println("\t\t Maximum flow");
        System.out.println("-----------------------------------------------\n");
        System.out.println("Augmentation paths:");
        int src, dest;

        /*
          Create Residual graph  with the same capacity as the original grapth to fill it with the
          residual capacity of edges  
         */
        //To get the number of vertices of the graph.
        int Ver = graph[1].length;

        int[][] rGraph = new int[Ver][Ver];
        for (src = 0; src < Ver; src++) {
            for (dest = 0; dest < Ver; dest++) {
                rGraph[src][dest] = graph[src][dest];
            }
        }

        // Parent array to store path by BFS
        int parent[] = new int[Ver];

        //Initialize  max flow =0 
        int MaxFlow = 0;
        //------------------------------------------

        //While there is path from source to sink, set the flow Direction "->" or "<-" 
        while (bfs(rGraph, source, sink, parent)) {
            String Path = "";

            //Initialize  max flow to infinite 
            int pathFlow = Integer.MAX_VALUE;

            // Find  maximum flow through the path found from BFS .
            for (dest = sink; dest != source; dest = parent[dest]) {
                // Set flow Direction and  source is the parent
                String Direction = " <- ";
                src = parent[dest];
                //Update  path flow 
                pathFlow = Math.min(pathFlow, rGraph[src][dest]);

                if (graph[src][dest] != 0) {
                    Direction = " -> ";
                }
                //Update  Path 
                Path = Direction + (dest + 1) + Path;
            }
            //Update the Path and print it 
            Path = (dest + 1) + Path;
            System.out.printf("%-17s\n", Path);

            /* 
              Update residual capacities of the edges and
              reverse edges along the path
             */
            for (dest = sink; dest != source; dest = parent[dest]) {
                src = parent[dest];
                rGraph[src][dest] -= pathFlow;
                rGraph[dest][src] += pathFlow;
            }
            // Add path flow value to total max flow
            MaxFlow += pathFlow;
            System.out.println("Updated flow: " + MaxFlow + "\n");

        }

        // print max-flow
        System.out.println("> The maximum flow is " + MaxFlow);

        //get the mini cut
        System.out.println("\n-----------------------------------------------");
        System.out.println("\t\tMinimum cut");
        System.out.println("-----------------------------------------------");
        // print min-cut edges
        System.out.println("\n> Edges included in the min-cut");
        //isvesited array to keep track of the visited nodes
        boolean[] isVisited = new boolean[graph.length];
        //Trverse  path with DFS to get the minimum cut
        dfs(rGraph, source, isVisited);

        // Print all edges from a vertex to other neighbor vertices 
        int totalCut_cap = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                //if there is an edge with weight between i ,j print it and add it to the mini cut
                if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) {
                    System.out.print("\nEdge between : " + (i + 1) + "->" + (j + 1));
                    System.out.println("\n capacity = " + graph[i][j]);
                    //Update  total mini cut capacity 
                    totalCut_cap += graph[i][j];
                    System.out.println("new min-cut capacity: " + totalCut_cap);
                }
            }
        }
        //Print final total mini cut capacity
        System.out.println("\n> The total min-cut capacity is " + totalCut_cap + "\n");
    }

  /**
   * 
   * @param Rgraph
   * @param src
   * @param visited 
   */
    //DFS method to find the mini cut
    public static void dfs(int[][] Rgraph, int src, boolean[] visited) {
        visited[src] = true;
        //iterate of the graph to visit the nodes of a path 
        for (int i = 0; i < Rgraph.length; i++) {
            if (Rgraph[src][i] > 0 && !visited[i]) {
                dfs(Rgraph, i, visited);
            }
        }
    }
/**
 * 
 * @param Rgraph
 * @param source
 * @param sink
 * @param parent
 * @return true
 */
//BFS method to get all the path possible from the source to  sink 
    public static boolean bfs(int Rgraph[][], int source, int sink, int parent[]) {

        int ver = Rgraph[1].length;

        // set all vertices as not visited
        boolean[] isvisited = new boolean[ver];
        for (int i = 0; i < isvisited.length; ++i) {
            isvisited[i] = false;
        }

        /* 
          Create a queue implemented as linklist to keep track of the path , add source vertex to the queue and mark
          source vertex as visited
         */
        LinkedList<Integer> pathQueue = new LinkedList<>();
        pathQueue.add(source);
        isvisited[source] = true;
        //the source has no parent 
        parent[source] = -1;

        //Traverse  vertices using BFS approche while there are verts in the queue   
        while (!pathQueue.isEmpty()) {
            //Consider the head of the queue as the source
            int src = pathQueue.poll();
            for (int dest = 0; dest < ver; dest++) {
                /*if destination has not been visited and there is an edge with a capacity between src & dest
                 add is to the queue and set it as visited , set the the parent of dest is the src
                 */
                if (isvisited[dest] == false && Rgraph[src][dest] > 0) {
                    pathQueue.add(dest);
                    parent[dest] = src;
                    isvisited[dest] = true;
                }
            }
        }
        //Check if we reach the sink using the found path using BFS
        //  Return true If we reached sink else return false

        return (isvisited[sink] == true);
    }//end of BFS

}

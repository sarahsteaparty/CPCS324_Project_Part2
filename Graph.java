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

import java.util.Scanner;
public class Graph {
  
   //number of vertices
    private int ver;
     //number of edges
    private int edges;
    
      
    /**
     *Graph constructor 
     * @param ver number of vertices
     * @param edges   number of edges
     */
     Graph (int ver, int edges) {
        this.ver = ver;
        this.edges = edges;
    }

   

     
     
    public int getVerts() {
        return ver;
    }

    public int getEdges() {
        return edges;
    }

    public void setVerts(int verts) {
        this.ver = verts;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }
     
     
     /**
      * 
      * @param graph
      * @return WeightedGraph
      */
     
       public int[][] MakeGraph( Graph graph) {
           Scanner input=new Scanner(System.in);
            int[][] WeightedGraph = new int[graph.getVerts()][graph.getVerts()];
            
     
          for (int i = 0; i < graph.getVerts(); i++) {
         
          for (int j =0;j<graph.getVerts();j++){
              System.out.println("Enter the edge weight between source vertex "+(i+1)+" and destinatin vertex "+(j+1));
          WeightedGraph[i][j]=input.nextInt();
          }
        }
           return WeightedGraph;

    }  
}

/*
 * CPCS-324 Algorithms and Data Structures II course project - Phase 2
 * It computes the all the shortest paths according to the distance matrix 
 * using Dijkstra Algorithm
 * Vertex A is source
 * Group members: Sarah AlJumai, Batol Al-Wagdani ,Joud AL-Suhaibani
 */

/**
 * Section : IAR 
 * Question 2 Task 1
 * @author Batol Ahmed Alwagdani
 * @author Sarah Mohammed AlJumai
 * @author Joud Mohammed Alsuhiabani
 */

public class BipartiteMain {
     /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Bipartite Graph = new Bipartite(); //creating a graph through Bipartite class
        System.out.println("The Maximum number of applicants that can be assigned to hospitals: " + Graph.maxMatch() + "\n");
    }
    
}

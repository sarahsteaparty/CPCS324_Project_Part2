/*
 * CPCS-324 Algorithms and Data Structures II course project - Phase 2
 * It computes the all the shortest paths according to the distance matrix 
 * using Dijkstra Algorithm
 * Vertex A is source
 * Group members: Sarah AlJumai, Batol Al-Wagdani ,Joud AL-Suhaibani
 */

/**
 * Section : IAR 
 * @author Batol Ahmed Alwagdani
 * @author Sarah Mohammed AlJumai
 * @author Joud Mohammed Alsuhiabani
 */
import java.util.ArrayList;

public class Dijkstra {

    /**
     * a static value that will help calculate run time, which is the starting
     * of Dijkstra algorithm that starts with class
     */
    static double StartTime;
    /**
     * a static value to represent the maximum value to take part as infinity ထ
     */
    static int inf = Integer.MAX_VALUE;
    /**
     * Different weighted graphs to be tested on, first graph has 10 vertices,
     * second has 15 vertices third has 20 vertices, and the last has 25
     * vertices
     */
    //first matrix that consists of 10 vertices
    //  A    B    C    D    E    F    G    H    I    J 
//    static int[][] matrix = {{0, 10, inf, inf, inf, 5, inf, inf, inf, inf}, 
//    {inf, 0, 3, inf, 3, inf, inf, inf, inf, inf}, 
//    {inf, inf, 0, 4, inf, inf, inf, 5, inf, inf}, 
//    {inf, inf, inf, 0, inf, inf, inf, inf, 4, inf}, 
//    {inf, inf, 4, inf, 0, inf, 2, inf, inf, inf}, 
//    {inf, 3, inf, inf, inf, 0, inf, inf, inf, 2}, 
//    {inf, inf, inf, 7, inf, inf, 0, inf, inf, inf}, 
//    {inf, inf, inf, 4, inf, inf, inf, 0, 3, inf}, 
//    {inf, inf, inf, inf, inf, inf, inf, inf, 0, inf}, 
//    {inf, 6, inf, inf, inf, inf, 8, inf, inf, 0},   
//};
    /**
     * a static array to represent the graph's labels
     */
//   static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',}; //and the matrix labels
//second matrix that consists of 15 vertices
//    static int matrix[][] = {
//        {7, 23, 40, 3, 10, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
//        {inf, 0, inf, inf, inf, inf, inf, 21, inf, inf, inf, inf, inf, inf, inf},
//        {inf, inf, 11, inf, inf, 8, inf, inf, inf, inf, inf, inf, inf, inf, inf},
//        {inf, inf, inf, 0, inf, inf, 6, inf, inf, inf, inf, inf, inf, inf, inf},
//        {inf, inf, inf, inf, 0, inf, inf, inf, inf, inf, inf, 3, inf, inf, inf},
//        {inf, inf, inf, inf, inf, 4, inf, inf, inf, 9, inf, 4, inf, inf, inf},
//        {inf, inf, inf, inf, inf, inf, 2, inf, inf, 44, 2, inf, inf, inf, inf},
//        {inf, inf, inf, inf, inf, inf, inf, 1, 1, inf, inf, inf, inf, inf, inf},
//        {inf, inf, inf, inf, inf, inf, inf, inf, 6, 4, inf, inf, inf, inf, 3},
//        {inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, 6, 10, inf},
//        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 4, inf, inf},
//        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, 3, inf, inf},
//        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 23, 19, inf},
//        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 22, inf},
//        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 4, 0},};
    /**
     * a static array to represent the graph's labels
     */
//    static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',}; //and the matrix labels
//third matrix that consists of 20 vertices
//          static int matrix[][] = {
//           {4,0,0,20,11,inf, inf, inf,inf, inf, inf,inf, inf,inf,inf , inf, inf, inf, inf,inf},
//            {inf,4,inf, inf, inf,inf, inf, 21,inf, inf,inf, inf,inf,inf,inf, inf, inf, inf, inf,inf},
//            {inf, inf, 2, inf, inf,7, inf, inf,inf, inf,inf,inf,inf,inf,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, 30, inf,inf, 5, inf,inf, inf,inf,inf,inf,inf,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, 10,inf, inf, inf,inf, inf,inf,2,inf,inf,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,11, inf, inf,inf, 2,inf,4,inf,inf,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, 30, inf,inf, 5,33,inf,inf,inf,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, 0,1, inf,inf,inf,inf,inf,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,5, 12,inf,inf,inf,inf,25, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, 0,inf,inf,9,15,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,0,inf,4,inf,inf, inf, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,0,3,inf,inf, 1, inf, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,20,7,inf, inf, 5, 1, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,3,inf, inf, 8, inf, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,0,0, inf, inf, inf, 26,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,inf,inf, 10, inf, 5, inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,inf,inf, inf, 20, inf, 0,9},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,inf,inf, inf, inf, 10, inf,1},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,inf,inf, inf, inf, inf, 5,12},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,inf,inf, inf, inf, inf, inf,10},};
    /**
     * a static array to represent the graph's labels
     */
//         static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K','L','M','N','O','P','Q','R','S','T',}; //and the matrix labels
//
    //fourth matrix that consists of 25 vertices
    static int matrix[][] = {
        {0, 3, 4, 5, 1, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},//A
        {inf, 0, inf, inf, inf, inf, inf, 2, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},//B
        {inf, inf, 0, inf, inf, 7, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},//C
        {inf, inf, inf, 0, inf, inf, 6, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, 0, inf, inf, inf, inf, inf, inf, 3, inf, inf, inf, inf, inf, inf, inf, inf, 13, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, 0, inf, inf, inf, 2, inf, 4, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, 0, inf, inf, 10, 5, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, 0, 11, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, 0, 4, inf, inf, inf, inf, 2, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, 7, 10, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 4, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, 3, inf, inf, 13, inf, inf, inf, inf, 2, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, 8, inf, inf, 3, 2, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, 5, inf, inf, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 7, 0, inf, inf, inf, 6, inf, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 9, inf, inf, inf, 10, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 4, 6, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 12, inf, inf, 8, 11, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, 3, inf, inf, inf, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, inf, inf, inf, 3},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 14, inf, inf},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 9, 7},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, inf, 3},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0, 4},
        {inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, 0},};
    /**
     * a static array to represent the graph's labels
     */
    static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Z'}; //and the matrix labels
    /**
     * a static value to represent graph as it goes
     */
    static String Graph = "";
    /**
     * a static value to represent visited vertices
     */
    static String visited = "";
    /**
     * a static ArrayList to represent edges, so it would be more flexible when
     * adding
     */
    static ArrayList<edge> edge = new ArrayList();

    /**
     * this method is the main Dijkstra algorithm and is used in main,
     *
     * @param graph that is represented in an array format
     * @param source the graph's source to which will calculate distances from
     */
    public static void dijkstra(int[][] graph, int source) {
        StartTime = System.currentTimeMillis();
        int n = graph.length;
        boolean[] visitedVertex = new boolean[n]; //to check visited or not
        int[] distance = new int[n];
        //initialize visited and arrays
        for (int i = 0; i < n; i++) {
            visitedVertex[i] = false; //so far all aren't visited so false
            distance[i] = Integer.MAX_VALUE;
            edge.add(new edge(source));
        }

        //if there is a self loop it shall be 0
        distance[source] = 0;
        for (int i = 0; i < n; i++) {
            //to update the distance between neighbour vertex and source vertex
            int u = minimumDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            //update all the neighbouring vertex distances
            for (int v = 0; v < n; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && graph[u][v] != inf && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                    edge.get(v).setSource(u); //save the intermediate source
                    visited += vertex[v];  //save visited nodes labels

                }
            }
            //printing graph vertices
            System.out.println("\nGraph Vertices");
            Graph += vertex[u] + "(" + (matrix[source].equals(matrix[u]) ? "-" : vertex[edge.get(u).src]) + "," + distance[u] + ")\n";
            System.out.println(Graph);
            // printing remaining vertices
            System.out.println("Remaining Vertices");
            for (int j = 0; j < n; j++) {
                if (!visitedVertex[j]) { //to check wether there is a value to calculate or infinity
                    System.out.println(vertex[j] + "(" + (visited.equals(vertex[j]) ? vertex[edge.get(j).src] : "-") + "," + (distance[j] == inf ? "ထ" : distance[j]) + ")");
                }
            }
            System.out.println("\n******************************************************");

        }
        // printing final distances
        System.out.println("\nShortest distances from " + vertex[source] + " other vertices:");
        System.out.println();
        for (int i = 0; i < distance.length; i++) {
            if (!matrix[source].equals(matrix[i])) {
                System.out.println(String.format("Distance from %-6s to %-7s is %-4d", vertex[source], vertex[i], distance[i]));
            }
        }

    }

    //to find the minimum distance
    /**
     * this method is the main Dijkstra algorithm and is used in Dijkstra's
     * algorithm method to help calculate minimum distances
     *
     * @param distance to compare and figure minimum
     * @param visited that makes us aware of which is visited and which isn't
     */
    private static int minimumDistance(int[] distance, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = 0; //to help with comparison
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) { //if visited and current distance is not less than the min distance, 
                minDistance = distance[i]; //the min will be assigined to distace
                minDistanceVertex = i;

            }
        }
        return minDistanceVertex; //the found min distance's vertex is back
    }
    
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        int source = 0;
        Dijkstra.dijkstra(matrix, source); //gave the matrix to be "solved" and initial source (0) to the dijkstra class and to call the dijkstra method
        System.out.println();
        double FinishTime = System.currentTimeMillis();
        System.out.println("Total runtime of Dijkstra's Algorithm: " + (FinishTime - StartTime) + " ms.");
        System.out.println("");
    }

    //class edge to use in the array list, makes it easier to add each edge
    static class edge {

        /**
         * variable to represent vertex
         */
        int vert;
        /**
         * variable to represent source vertex
         */
        int src;

        /**
         * constructor
         *
         * @param vert = number of vertices
         * @param src = source
         */
        edge(int source) {
            this.src = source;
        }

        public int getVertex() {
            return vert;
        }

        public void setVertex(int vert) {
            this.vert = vert;
        }

        public int getSource() {
            return src;
        }

        public void setSource(int src) {
            this.src = src;
        }
    }

}

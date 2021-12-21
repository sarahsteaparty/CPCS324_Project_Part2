/*
 * CPCS-324 Algorithms and Data Structures II course project - Phase 2
 * using Floyd-Warshall 
 * Vertex A is source
 * Group members: Sarah AlJumai, Batol Al-Wagdani ,Joud AL-Suhaibani
 */

/**
 * Section : IAR
 * Question 1 
 * @author Batol Ahmed Alwagdani
 * @author Sarah Mohammed AlJumai
 * @author Joud Mohammed Alsuhiabani
 */

public class FloydWarshallMain {

    /**
     * a static value to represent the maximum value to take part as infinity ထ
     */
    static final int inf = Integer.MAX_VALUE;
    /**
     * Different weighted graphs to be tested on, first graph has 10 vertices,
     * second has 15 vertices third has 20 vertices, and the last has 25
     * vertices
     */
//    //first matrix that consists of 10 vertices
//    //  A    B    C    D    E    F    G    H    I    J 
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
     * a static value to represent the graph's size
     */
//    static int size = matrix.length;
    /**
     * a static array to represent the graph's labels
     */
//    static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',}; //and the matrix labels
//    

//second matrix that consists of 15 vertices
//    static int matrix[][] = {
//            {7,23,40,3,10,inf, inf, inf,inf, inf, inf,inf, inf,inf,inf},
//            {inf,0,inf, inf, inf,inf, inf, 21,inf, inf,inf, inf,inf,inf,inf},
//            {inf, inf, 11, inf, inf,8, inf, inf,inf, inf,inf,inf,inf,inf,inf},
//           {inf, inf, inf, 0, inf,inf, 6, inf,inf, inf,inf,inf,inf,inf,inf},
//           {inf, inf, inf, inf, 0,inf, inf, inf,inf, inf,inf,3,inf,inf,inf},
//           {inf, inf, inf, inf, inf,4, inf, inf,inf, 9,inf,4,inf,inf,inf},
//           {inf, inf, inf, inf, inf,inf, 2, inf,inf, 44,2,inf,inf,inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, 1,1, inf,inf,inf,inf,inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,6, 4,inf,inf,inf,inf,3},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, 0,inf,inf,6,10,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,0,inf,4,inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,0,3,inf,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,23,19,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,22,inf},
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,4,0},
//        };
    /**
     * a static value to represent the graph's size
     */
//    static int size = matrix.length;
    /**
     * a static array to represent the graph's labels
     */
//         static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K','L','M','N','O',}; //and the matrix labels
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
//           {inf, inf, inf, inf, inf,inf, inf, inf,inf, inf,inf,inf,inf,inf,inf, inf, inf, inf, inf,10},
//           };
    /**
     * a static value to represent the graph's size
     */
//    static int size = matrix.length;
    /**
     * a static array to represent the graph's labels
     */
//     static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K','L','M','N','O','P','Q','R','S','T',}; //and the matrix labels
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
     * a static value to represent the graph's size
     */
    static int size = matrix.length;
    /**
     * a static array to represent the graph's labels
     */
    static char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Z'}; //and the matrix labels

    /**
     * main method
     *
     * @param args
     */
    public static void main(String args[]) {
        double StartTime = System.currentTimeMillis();
        System.out.println("******************************************************");
        System.out.println("Shortest path for each iteration in following matrices\n");
        //first will print D(0) which is equivalent to the adjency matrix so the matrix isn't changed 
        System.out.print("D(0)=\n\t");
        for (int i = 0; i < size; i++) {
            System.out.print(vertex[i] + "\t"); //labels to print
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(vertex[i] + "\t"); //labels to print
            for (int j = 0; j < size; j++) {
                System.out.print((matrix[i][j] == inf ? "ထ" : matrix[i][j]) + (size - 1 == j ? "\n" : "\t")); //if the value is written as inf print the symbol
            }
        }
        System.out.println();
        floydWarshall(matrix, size, vertex); //calling floyd-warshall algorithm with the graph, it's labels and size as parameters
        /**
         * a static value to represent the ending time of algorithm
         */
        double FinishTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Total runtime of FLoyd Warshall's Algorithm: " + (FinishTime - StartTime) + " ms.");
        System.out.println("");
    }

    /**
     * this method is used in main,
     *
     * @param matrix that is represented in an array format
     * @param size the graph's size
     * @param vertex the graph's labels
     */
    public static void floydWarshall(int matrix[][], int size, char vertex[]) {
        for (int i = 0; i < size; i++) {
            System.out.print("D(" + (i + 1) + ")=\n\t"); //the stage number to be printed
            //extra loop for printing the vertices labels 
            for (int k = 0; k < size; k++) {
                System.out.print(vertex[k] + "\t");
            }
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(vertex[j] + "\t");
                for (int k = 0; k < size; k++) {
                    //following the algorithm
                    if (matrix[j][k] > matrix[j][i] + matrix[i][k] && matrix[j][i] != inf && matrix[i][k] != inf) {
                        matrix[j][k] = matrix[j][i] + matrix[i][k];
                    }
                    System.out.print((matrix[j][k] == inf ? "ထ" : matrix[j][k]) + (size - 1 == k ? "\n" : "\t")); //check wether its infinity and if to check to go to next row
                }
            }

        }
    }

}

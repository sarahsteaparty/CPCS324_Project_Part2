/*
 * CPCS-324 Algorithms and Data Structures II course project - Phase 2
 * It computes the all the shortest paths according to the distance matrix 
 * using Dijkstra Algorithm
 * Vertex A is source
 * Group members: Sarah AlJumai, Batol Al-Wagdani ,Joud AL-Suhaibani
 */

/**
 * Section : IAR
 *
 * @author Batol Ahmed Alwagdani
 * @author Sarah Mohammed AlJumai
 * @author Joud Mohammed Alsuhiabani
 */
import java.util.ArrayList;

public class Bipartite {

    /**
     * a string array to represent the the applicants
     */
    String[] Applicants = {"Ahmed", "Mahmoud", "Eman", "Fatimah", "Kamel", "Nojood"};
    /**
     * a string array to represent the hospitals names
     */
    String[] Hospitals = {"King Abdelaziz University", "King Fahd", "East Jeddah", "King Fahad Armed Forces", "King Faisal Specialist", "Ministry of National Guard"};
    ArrayList<Integer> MatchSet = new ArrayList<>();
    /**
     * int values to represent both arrays' sizes
     */
    int NumOfApplicants = Applicants.length, NumOfHospitals = Hospitals.length;
    /**
     * main Bipartite graph
     */
    int bipartiteGraph[][] = new int[][]{
        {1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0, 1}
    };
    /**
     * graph with NumOfApplicants and NumOfHospitals
     */
    int[] AddApplicants = new int[NumOfHospitals];

    /**
     * function for checking if a matching for applicant is possible
     *
     * @param A
     * @param visited
     * @param assign
     * @return true if a match is found
     */
    boolean bipartiteMatch(int A, boolean visited[], int assign[]) {
        for (int H = 0; H < NumOfHospitals; H++) {    //for all hospital 
            if (bipartiteGraph[A][H] == 1 && !visited[H]) {    //when hospital H is not visited and A is interested
                visited[H] = true;    //mark hospital H as visited
                //when H is not assigned or previously assigned
                if (assign[H] < 0 || bipartiteMatch(assign[H], visited, assign)) {
                    assign[H] = A;    //assign hospital H to applicant A
                    System.out.println(Applicants[A] + " is assigned to " + Hospitals[H] + "\n");
                    MatchSet.set(A, H); // add the edge to matching set 
                    AddApplicants[H] = A;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * maximum matching method
     *
     * @return number of matching found in the graph
     */
    int maxMatch() {
        int assign[] = new int[NumOfHospitals];    //an array to track which hospital is assigned to which applicant
        for (int i = 0; i < NumOfHospitals; i++) {
            assign[i] = -1;    //initially set all jobs are available
            MatchSet.add(-1);     //initialize the MatchSet
        }
        int matchCount = 0; // counter for the match

        for (int a = 0; a < NumOfApplicants; a++) {    //for all applicants
            boolean visited[] = new boolean[NumOfHospitals];
            if (bipartiteMatch(a, visited, assign)) //when a get a hospital
            {
                System.out.println(" MatchSet: \n{");
                for (int i = 0; i < MatchSet.size(); i++) {
                    if (MatchSet.get(i) > -1) {
                        System.out.print("(" + Applicants[i] + " - " + Hospitals[MatchSet.get(i)] + ") \n");
                    }
                }
                System.out.println("}\n-----------------------------------------------------------------------");
                matchCount++;
            }
        }
        return matchCount;
    }
}

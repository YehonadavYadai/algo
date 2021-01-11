package TEST_2015_A_A;

import TEST_2015_A_B.Q3;

public class main {
    public static void main(String[] args) {
        int[][] islandGrid = new int[][] {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0}};
        Q1 q = new Q1(islandGrid);
        System.out.println(q.countIsland());

        }
}

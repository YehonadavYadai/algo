package TEST_2015_A_A;

public class Q1 {
    int[][] mat;
    int[][] firstMat;
    int count = 0;

    public Q1(int[][] input) {
        firstMat = input;
        int rows = firstMat.length + 2;
        int cols = firstMat[0].length + 2;
        this.mat = new int[rows][cols];
        for (int i = 1; i < mat.length - 1; i++) {
            for (int j = 1; j < mat[0].length - 1; j++) {
                mat[i][j] = firstMat[i - 1][j - 1];
            }
        }
    }

    public void burn(int i, int j) {
        // if we are in end of line check only down
        if (mat[i][j + 1] == 1) {
            mat[i][j + 1] = -1;
            burn(i, j + 1);
        }
        if (mat[i + 1][j] == 1) {
            mat[i + 1][j] = -1;
            burn(i + 1, j);
        }
        if (mat[i + 1][j - 1] == 1) {
            mat[i + 1][j - 1] = -1;
            burn(i + 1, j - 1);
        }
        if (mat[i + 1][j + 1] == 1) {
            mat[i + 1][j + 1] = -1;
            burn(i + 1, j + 1);
        }
    }
        public int countIsland () {
            for (int i = 1; i < mat.length - 1; i++) {
                for (int j = 1; j < mat.length - 1; j++) {
                    if (mat[i][j] == 1) {
                        count++;
                        this.burn(i, j);
                    }

                }

            }

            return count;
        }
    }

package TEST_2015_A_B;

public class Q2 {

    String x;
    String y;
    String lis;

    public Q2(String s1, String s2) {
        this.x = s1;
        this.y = s2;
    }

    public int[][] LisMatrix() {
        int row = x.length() + 1;
        int col = y.length() + 1;
        int[][] mat = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    mat[i][j] = (mat[i - 1][j - 1]) + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat;
    }

    public void maxSequnces() {
        int[][] mat = this.LisMatrix();
        int i = mat.length - 1;
        int j = mat[0].length - 1;
        int max = mat[i][j];
        int start = 0;
        String ans = "";
        while (start < max) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                ans = x.charAt(i - 1) + ans;

                i--;
                start++;
            } else {
                if (mat[i - 1][j] >= mat[i][j - 1]) i--;
                else j--;
            }
        }
        lis = ans;

    }
}

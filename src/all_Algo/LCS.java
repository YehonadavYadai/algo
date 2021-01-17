package all_Algo;

public class LCS {
    int mat[][];
    String s1;
    String s2;

    public String maxSequnces() {
        this.LCS_Mat();
        String ans = "";
        int row = mat.length;
        int col = mat[0].length;
        int i = row - 1;
        int j = col - 1;
        int count = mat[i][j];
        while (count > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                ans =  s1.charAt(i-1)+ans;
                count--;
                i--;
                j--;
            } else {
                if (mat[i-1][j]>=mat[i][j-1]) i--;
                else j--;

            }
        }


        System.out.println("the LCS Is "+ans);
        return ans;
    }
        public  LCS(String s1,String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
            public void LCS_Mat(){

        int row = s1.length() + 1;
        int col = s2.length() + 1;
        mat = new int[row][col];
        for (
                int i = 1;
                i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    mat[i][j] = (mat[i - 1][j - 1]) + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
            System.out.println("len of Lcs is "+mat[row-1][col-1]);
    }

    public static void main(String[] args) {
String x1="abcdddkfejsaf";
String x2="abcdddkfnsejkpsaf";
LCS q=new LCS(x1,x2);
q.maxSequnces();
    }
}


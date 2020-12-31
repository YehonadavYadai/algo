public class LisAlgo {


    private String x;
    private String y;


    public LisAlgo(String s1, String s2) {
        x = s1;
        y = s2;
    }

    public void Greeady() {
        int m = x.length();
        int n = y.length();
        int i = 0;
        int start = 0;
        int index = 0;
        String ans = "";
        while (i < m && index < n) {
            index = y.indexOf(x.charAt(i), start);
            if (index != -1) {//we found char i at "y".
                ans = ans + x.charAt(i);
                start = index + 1;
            }
            i++;
        }
        System.out.println("the Lis is : " + ans);
    }


    public int[][] LisMatrix() {
        int row = y.length() + 1;
        int col = x.length() + 1;
        int[][] mat = new int[row][col];
        for (int i = 1; i < row ; i++) {
            for (int j = 1; j < col ; j++) {
                if (y.charAt(i - 1) == x.charAt(j - 1)) {
                    mat[i][j] = (mat[i - 1][j - 1]) + 1;
                }
                else
                    {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat;
    }

    public String maxSequnces()
    {
        int [][] mat=this.LisMatrix();
        String ans="";
        int row =mat.length;
        int col=mat[0].length;
        int i =row-1;
        int j=col-1;
        int count=mat[i][j];
        while(count>=0)
        {
            if (x.charAt(i)==y.charAt(j))
            {
                ans=ans+x.charAt(i);
                count--;
                i--;
                j--;
            }
            else
            {
                i--;
            }
        }
        return ans;

    }

}




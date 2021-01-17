package all_Algo;

public class Mat_R {
    int[][] mat;
    int arr[] = new int[2];
    int max_count = 0;
    int count=0;

    public Mat_R(int[][] mat) {
this.mat=mat;
    }

    public int minThree(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public void count() {
        int row =mat.length;
        int cow=mat[0].length;
        int[][] ezer = new int[row][cow];
        //init first row
        for (int i = 0; i < mat.length; i++) {
            ezer[0][i] = mat[0][i];
        }
        //init first col
        for (int i = 0; i < mat[0].length; i++) {
            ezer[i][0] = mat[i][0];

        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                //if there is 1
                if (mat[i][j] == 1)
                {
                    ezer[i][j] = minThree(ezer[i][j - 1], ezer[i - 1][j - 1], ezer[i - 1][j]) + 1;
                    // check if is the max ribua and save him
                    if (ezer[i][j] > max_count) {
                        arr[0] = i;
                        arr[1] = j;
                        max_count=ezer[i][j];
                    }
                    //if its 0 put 0,
                } else ezer[i][j] = 0;
//            //check how many ribua 2*2 there is
//            if (ezer[i][j]>1)count++;
            }

        }
        System.out.println("number of ribua is "+(max_count*max_count));
       //System.out.println("number of 2*2 is : "+count);


    }

    public static void main(String[] args) {
         int mat[][]={{0,0,1,0,1},{0,1,1,1,1},{1,1,1,1,0},{0,1,1,1,1},{0,0,1,1,1}};
         Mat_R q =new Mat_R(mat);
         q.count();
    }


}

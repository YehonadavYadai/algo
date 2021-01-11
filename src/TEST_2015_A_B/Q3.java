package TEST_2015_A_B;

public class Q3 {
    Node mat[][];
    int count = 0;

    public Q3() {

    }

    public void ReWay(int i, int j) {

        if (i == 0 || j == 0){
            if (i == 0 && j == 0)
            {
                count++;
            }
            else if (i==0)ReWay(i , j-1);
            else ReWay(i-1, j );
        }

        else {
            int left = (mat[i][j - 1].cost);
            int up = mat[i - 1][j].cost;
            if (up == left) {//2 ways
                ReWay(i, j - 1);
                ReWay(i - 1, j);
            }
            if (left > up) {//faster is up
                ReWay(i - 1, j);
            }
            if (left < up) { //faster is left
                ReWay(i, j - 1);
            }
        }

    }


    public void matCost() {
        this.initMatOfNodes();
        int offer1 = 0;
        int offer2 = 0;
       
        for (int i = 1; i < mat.length ; i++) {
            mat[0][i].set(mat[0][i - 1].cost + mat[0][i-1].x);
            mat[i][0].set(mat[i - 1][0].cost + mat[i-1][0].y);
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                offer1 = mat[i - 1][j].cost + mat[i-1][j].y;
                offer2 = mat[i][j - 1].cost + mat[i][j-1].x;
                mat[i][j].set(Math.min(offer1, offer2));
            }

        }
        this.ReWay(3, 3);
        System.out.println(this.count);


    }

    public Node[][] initMatOfNodes() { // n = 4
        int n = 4;
        mat = new Node[n][n];
//the 1-st row
        mat[0][0] = new Node(1, 3);
        mat[0][1] = new Node(8, 4);
        mat[0][2] = new Node(3, 8);
        mat[0][3] = new Node(0, 4);
//the 2-nd row
        mat[1][0] = new Node(2, 5);
        mat[1][1] = new Node(5, 11);
        mat[1][2] = new Node(3, 1);
        mat[1][3] = new Node(0, 2);
//the 3-d row
        mat[2][0] = new Node(4, 10);
        mat[2][1] = new Node(3, 1);
        mat[2][2] = new Node(1, 4);
        mat[2][3] = new Node(0, 8);
//the 4-th row
        mat[3][0] = new Node(2, 0);
        mat[3][1] = new Node(3, 0);
        mat[3][2] = new Node(5, 0);
        mat[3][3] = new Node(0, 0);
        return mat;

    }


}

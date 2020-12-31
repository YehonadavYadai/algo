public class Q3_2016 {
    Node mat[][];
    int cost[][];
    int count = 0;
    Point p1;
    Point p2;

    public Q3_2016() {
        mat = initMatOfNodes();
        this.p1 = new Point(1, 1);
        this.p2 = new Point(2, 3);
    }

    public static Node[][] initMatOfNodes() { // n = 4
        int n = 4;
        Node mat[][] = new Node[n][n];
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

    public int convert(int a) {
        if (a == 3) return 0;
        if (a == 2) return 1;
        if (a == 1) return 2;
        if (a == 0) return 3;
        return 0;
    }

    public void settings() {
        int xConver = 0;
        int yConvert = 0;
        cost = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) { // mapping all cost at -1 in the start
            for (int j = 0; j < mat[0].length; j++) {
                // xConver = convert(i);
                // yConvert = convert(j);
                cost[i][j] = -1;
            }
        }
        for (int i = p1.x(); i < p2.x() + 1; i++) {
            for (int j = p1.y(); j < p2.y() + 1; j++) {
                xConver = convert(i);
                yConvert = j;
                cost[xConver][yConvert] = -10;
            }
        }
        cost[3][0] = 0;
        for (int i = 1; i < mat.length; i++) {//mapping first row

            cost[mat.length - 1][i] = cost[mat.length - 1][i - 1] + mat[mat.length - 1][i - 1].x;
        }
        for (int i = 1; i < mat.length; i++) {//mapping first cow
            xConver = convert(i);
            cost[xConver][0] = cost[xConver + 1][0] + mat[xConver + 1][0].y;
        }
    }

    public int min(int a, int b) {
        if (a < b) return a;
        else return b;
    }

    public int shortpath() {
        this.settings();
        int offer1 = 0;
        int offer2 = 0;
        int count = 0;
        int xConver = 0;
        int yConvert = 0;
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                xConver = convert(i);
                yConvert = j;
                if (cost[xConver][yConvert] == -10) ;
                else if (cost[xConver + 1][yConvert] == -10) {
                    cost[xConver][yConvert] = cost[xConver][yConvert - 1] + mat[xConver][yConvert - 1].x;
                } else if (cost[xConver][yConvert - 1] == -10) {
                    cost[xConver][yConvert] = cost[xConver + 1][yConvert] + mat[xConver + 1][yConvert].y;
                } else {
                    offer1 = cost[xConver][yConvert - 1] + mat[xConver][yConvert - 1].x;
                    offer2 = cost[xConver + 1][yConvert] + mat[xConver + 1][yConvert].y;
                    cost[xConver][yConvert] = min(offer1, offer2);


                }
            }
        }

        return cost[0][mat.length-1];


    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}

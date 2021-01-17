package all_Algo;


import com.sun.security.jgss.GSSUtil;

public class AirPlane_Algo {
    Node_Air[][] map;
    int n = 0;

    public AirPlane_Algo() {
        map = initMatOfNodes();
    }


    public Node_Air[][] initMatOfNodes() { // n = 4
        n = 4;
        map = new Node_Air[n][n];
//the 1-st row
        map[0][0] = new Node_Air(1, 3);
        map[0][1] = new Node_Air(8, 4);
        map[0][2] = new Node_Air(3, 8);
        map[0][3] = new Node_Air(0, 4);
//the 2-nd row
        map[1][0] = new Node_Air(2, 5);
        map[1][1] = new Node_Air(5, 11);
        map[1][2] = new Node_Air(3, 1);
        map[1][3] = new Node_Air(0, 2);
//the 3-d row
        map[2][0] = new Node_Air(4, 10);
        map[2][1] = new Node_Air(3, 1);
        map[2][2] = new Node_Air(1, 4);
        map[2][3] = new Node_Air(0, 8);
//the 4-th row
        map[3][0] = new Node_Air(2, 0);
        map[3][1] = new Node_Air(3, 0);
        map[3][2] = new Node_Air(5, 0);
        map[3][3] = new Node_Air(0, 0);
        return map;
    }

    public int BuildCosts(int x1,int y1,int x2,int y2) {
        int offer_x = 0;
        int offer_y = 0;
        int best = 0;
        //build the first row .
        for (int i = 1; i < n; i++) {
            //(0,1) will get cost of (0,0) +(0,0).x
            map[0][i].set(map[0][i - 1].cost + map[0][i - 1].y);
        }
            for (int i = 1; i < n; i++) {
            //(1,0) will get cost of (0,0)+(0,0).x
            map[i][0].set(map[i - 1][0].cost + map[i - 1][0].x);
        }
        for (int i = x1+1; i < x2+1; i++) {
            for (int j = y1+1; j < y2+1; j++) {
                //start from (1,1) will get min of cost+x/y.
                offer_x = map[i][j - 1].cost + map[i][j - 1].x();
                offer_y = map[i - 1][j].cost + map[i - 1][j].y();
                best = Math.min(offer_x, offer_y);
                map[i][j].set(best);


            }

        }
        //System.out.println(map[n - 1][n - 1].cost);
        int cost= map[x2][y2].cost;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j].set(0);

            }

        }
        System.out.println("the dis from ("+x1+ " "+y1+") to ("+x2+" "+y2+") is :"+cost);
        return cost;


    }

    public int BuildCosts_Max() {
        int offer_x = 0;
        int offer_y = 0;
        int best = 0;
        //build the first row .
        for (int i = 1; i < map.length; i++) {
            //(0,1) will get cost of (0,0) +(0,0).x
            map[0][i].set(map[0][i - 1].cost + map[0][i - 1].x);
            //(1,0) will get cost of (0,0)+(0,0).x
            map[i][0].set(map[i - 1][0].cost + map[i - 1][0].y);
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                //start from (1,1) will get min of cost+x/y.
                offer_x = map[i][j - 1].cost + map[i][j - 1].x();
                offer_y = map[i - 1][j].cost + map[i - 1][j].y();
                best = Math.max(offer_x, offer_y);
                map[i][j].set(best);


            }

        }
        System.out.println(map[n - 1][n - 1].cost);
        return map[n - 1][n - 1].cost;


    }

    public int checkIfPoss(int q1, int p1, int q2, int p2) {
        if (q1 > q2 && p1 > p2) return 1;
        if (q2 > q1 && p2 > p1) return 2;
        return 0;
    }
    public int best_path(int p1,int q1,int p2,int q2){
        int row=map.length;
        int col=map[0].length;
        for (int j = q1+1; j <= q2; j++) {
            map[p1][j].cost=map[p1][j-1].x+map[p1][j-1].cost;
            map[p1][j].path=1;
        }
        for (int i = p1+1; i <=p2 ; i++) {
            map[i][q1].cost=map[i-1][q1].y+map[i-1][q1].cost;
            map[i][q1].path=1;
        }
        // if the
        for (int i = p1+1; i <=p2; i++) {
            for (int j=q1+1 ; j <=q2 ; j++) {
                int a=map[i-1][j].cost+map[i-1][j].y;
                int b=map[i][j-1].cost+map[i][j-1].x;

                if(a<b){
                    map[i][j].cost=a;
                    map[i][j].path=map[i-1][j].path;
                }
                else if (a>b){
                    map[i][j].cost=b;
                    map[i][j].path=map[i][j-1].path;
                }
                else {
                    map[i][j].cost=a;
                    map[i][j].path=map[i][j-1].path+map[i-1][j].path;
                }

            }
        }
        return map[p2][q2].cost;
    }

        



    public static void main(String[] args) {
        AirPlane_Algo q = new AirPlane_Algo();
        System.out.println(q.best_path(0,1,1,2));
    }
}

package TEST_2015_A_B;
class Node_Air {
    int x, y, cost;

    public Node_Air(int x, int y) {
        this.x = x;
        this.y = y;
        cost = 0;
    }

    public void set(int x) {
        cost = x;
    }

    public int get(int x) {
       return cost;
    }
}
package TEST_2015_A_B;
class Node {
    int x, y, cost;

    public Node(int x, int y) {
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
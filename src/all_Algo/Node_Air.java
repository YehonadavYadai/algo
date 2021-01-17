package all_Algo;
class Node_Air {
    int x, y, cost,path;

    public Node_Air(int x, int y) {
        this.x = x;
        this.y = y;
        cost = 0;
    }

    public void set(int x) {
        cost = x;
    }

    public int get() {
       return cost;
    }

    public int x(){
        return x;
    }
    public int y(){
        return y;
    }
}
package object_orinted_test;

public class Pass_Q extends Thread {
    int low = 0;
    int high = 0;
    static String ans = null;
    static boolean notfoundyet =true;
    static int count=0;

    public Pass_Q(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public String getStringfromInt(int i, int l) {
        String s = String.valueOf(i);
        while (s.length() < l) {
            s = 0 + s;
        }
        return s;
    }

    public boolean findPass(String s) {
        String password = "999999";
        return s.equals(password);
    }

    synchronized public String search(int low, int high) {
        int i = low;
        while (ans == null & i < high) {
            count++;

            String test = getStringfromInt(i, 6);
            if (findPass(test)) ans = test;
            if (ans==null)System.out.println("checking : " + test);
            i++;
        }

        return ans;
    }

    public void run() {

        String ans = this.search(low, high);
        if (notfoundyet) {
            notfoundyet=false;
            System.out.println("we found the string! : " + ans);
            System.out.println("searche: "+count);
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Pass_Q t1 = new Pass_Q(0, 500000);
        Pass_Q t2 = new Pass_Q(500001, 1000000+2);
        t1.start();
        t1.join();
        t2.start();



    }


}

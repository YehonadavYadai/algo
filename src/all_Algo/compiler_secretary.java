package all_Algo;

import java.lang.reflect.Array;
import java.util.*;

public class compiler_secretary {
    prog[] a;

    public static class prog implements Comparable {
        double p;
        double l;

        public prog(double l, double p) {
            this.l = l;
            this.p = p;
        }

        public double time() {
            return l * p;
        }

        public double size() {
            return (p / l);
        }

        @Override
        public int compareTo(Object o) {
            double this_offer = this.p / this.l;
            prog other = (prog) o;
            double other_offer = other.p / other.l;

            if (this_offer > other_offer) return 1;
            else if (this_offer < other_offer) return -1;
            else return 0;
        }
    }

    public compiler_secretary(prog[] a) {
        this.a = a;
    }

    public compiler_secretary() {
    }

    public void secretary(int[] arr) {
        // i need to get the lowest s i assume i get sorteed?
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("client number " + (i + 1) + " is entering for : " + arr[i]);
            temp = arr[i] + temp + temp;
        }
        System.out.println("time of all clients is " + temp);
        System.out.println("avarge of client is :" + ((double) temp / arr.length));


    }

    public void compiler() {
        double temp = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print("size: " + a[i].size());
            System.out.println(" client number " + (i + 1) + " is entering for : " + a[i].time());
            //old temp + new temp how much everybody
            temp = a[i].time() + temp + temp;
        }
        System.out.println("time of all clients is " + temp);
        System.out.println("avarge of client is :" + ((double) temp / a.length));


    }

    public static void main(String[] args) {
//        compiler_secretary q=new compiler_secretary();
//        int []a={4,6,5,3,8,7,1};
//        Arrays.sort(a);
//        q.secretary(a);
//        Random rand = new Random();
//        for (int i = 0; i < a.length; i++) {
//            int randomIndexToSwap = rand.nextInt(a.length);
//            int temp1 = a[randomIndexToSwap];
//            a[randomIndexToSwap] = a[i];
//            a[i] = temp1;
//        }
//        q.secretary(a);
//    }

        int n = 10;
        prog[] arr = new prog[n];
        for (int i = 0; i < n; i++) {
            prog temp = new prog((double) i + 10, (double) i / 5);
            arr[i] = temp;
        }
        compiler_secretary q2 = new compiler_secretary(arr);
        q2.compiler();
    }
}

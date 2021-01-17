package all_Algo;

import java.util.Arrays;
import java.util.Random;

public class Midian {
    int []arr;
    
    public Midian(){}
    public void all_Midian_2_arrays(int []a,int[]b){
        Arrays.sort(a);
        Arrays.sort(b);
        //from big to low
//        for (int i = 0; i < b.length/2; i++) {
//            int temp=a[i];
//            b[i]=b[b.length-1-i];//swap first to last
//            b[b.length-1-i]=temp;
//
//        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("the midin is "+Math.max(a[i],b[b.length-1-i]));
        }
    }
    public  void find_Midian(int[]arr) {
        int max = 0;

        if (arr.length > 120) {
            for (int i = 0; i < 63; i++) {
                max = Math.max(arr[i], max);
            }

        } else {
            for (int i = 0; i < arr.length / 4; i++) {
                max = Math.max(arr[i], max);
            }
        }
        System.out.println("Midian is : "+max);
    }

    public static void main(String[] args) {
        int n=10;
        int []a=new int [n];
        int []b=new int [n];
        for (int j= 0; j< n; j++) {
            Random q=new Random();
            a[j]=q.nextInt(10000);
            b[j]=q.nextInt(10000);
            System.out.println(a[j]+"  "+b[j]);
        }
        Midian q=new Midian();
       // q.find_Midian(a);
        q.all_Midian_2_arrays(a,b);
    }
}

import java.lang.reflect.Array;
import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        //int[] arr1 = {4, 5, 3, 1};
        //NumberGame_Optimal v = new NumberGame_Optimal(arr1);
       // System.out.println(v.playYourBest());
//        LisAlgo a = new LisAlgo("abcbdab", "bdcaba");
//        a.Greeady();
//        System.out.println(a.LisMatrix().length);
//
        int[] arr = {0, 5, 6, 3, 2, 1, 4, 8, 17, 6, 3, 101, 877, 6, 4, 2, 7, 566, 56, 4, 64, 646, 646, 446};
       int []arr2={10,11,12,13,1,2,3,4,5,198,197,196,195};
//       int []s=Arrays.copyOf(arr2,arr2.length);
//       Arrays.sort(s);
      Q3_2016 t=new Q3_2016();
        System.out.println(t.shortpath());



    }


    public int MaxAndMin_Original(int[] a) {
        int max = a[0];
        int min = a[0];
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            count++;
            if (a[i] < min) {
                min = a[i];
            }
            count++;

        }
        return count;
    }

    public static int MaxAndMin_LessStep(int arr[]) {
        int max = arr[0];
        int min = arr[0];
        int count = 0;
        for (int i = 1; i < (arr.length) - 1; i = i + 2) {
            count++;
            if (arr[i] >= arr[i + 1]) {
                count = count + 2;
                if (arr[i] > max) max = arr[i];
                if (arr[i + 1] < min) min = arr[i + 1];
            } else {
                count = count + 2;
                if (arr[i + 1] > max) max = arr[i + 1];
                if (arr[i] < min) min = arr[i];
            }

        }
        return count;

    }
}





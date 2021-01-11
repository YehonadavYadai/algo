public class Q2_2016 {
    int[] arr;


    public Q2_2016(int[] arr) {
        this.arr = arr;

    }

    public int IndexForLis(int[][] mat, int endline, int value) {
        int index = 0;
        if (mat[endline - 1][endline - 1] > value) {
            return endline;
        }
        if (mat[0][0] < value) return 0;

        int low = 0;
        int high = endline - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (low == high) {
                return low; // האיבר לא נמצא באלכסון, ולכן יוחזר האינדקס המתאים
            } else {
                if (mat[mid][mid] == value) return mid; // האיבר נמצא
                if (value > mat[mid][mid]) high = mid;
                else low = mid + 1;

            }
        }
        return -1;
    }
public void piapu(int [][]mat,int endline){
        for(int j=0;j<endline;j++){
            mat[endline][j]=mat[endline-1][j];
        }
}
    public int LisForInt() {
        int[][] v = new int[arr.length][arr.length];// buid
        v[0][0] = arr[0];
        int endline = 1;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            index = this.IndexForLis(v, endline, arr[i]);
                v[index][index]=arr[i];
                piapu(v,index);
            if (index==endline){// we found another 1
                endline++;}

            }
        return endline;

        }

    }


package all_Algo;

public class Num_game_S {

    int[] arr;
    int[][] mat;
    int n = 0;

    public Num_game_S(int[] arr) {
        this.arr = arr;
        n = arr.length;
    }

    public void buildmat() {

        mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            mat[i][i] = arr[i];
        }


        for (int i = n - 2; i >-1; i--) {
            for (int j = i + 1; j < n; j++) {
                mat[i][j] = Math.max(arr[i] - mat[i + 1][j], arr[j] - mat[i][j - 1]);
            }

        }
    }

    public void turns() {
        int i = 0;
        int j = n - 1;
        int a = 0;
        int b = 0;
        buildmat();

        for (int k = 1; k < (n / 2) + 1; k++) {

            if (arr[i] - mat[i + 1][j] > arr[j] - mat[i][j - 1]) {
                System.out.println("turn num: " + k + " first took :" + arr[i]);
                a += arr[i];
                i++;
            } else {
                System.out.println("turn num: " + k + " first took :" + arr[j]);
                a += arr[j];
                j--;
            }

            if (i != j) {

                if ((arr[i] - mat[i + 1][j]) > (arr[j] - mat[i][j - 1])) {
                    System.out.println("turn num: " + k + " second took :" + arr[i]);
                    b += arr[i];
                    i++;
                } else {
                    System.out.println("turn num: " + k + " second took :" + arr[j]);
                    b += arr[j];
                    j--;
                }
            } else {
                b += arr[j];
                System.out.println("turn num: " + k + " second took :" + arr[j]);
            }

        }
        System.out.println("first count his:" + a);
        System.out.println("2nd count his:" + b);
    }
    public void turns_cycle(int num) {
        int i = 0;
        int j = n - 1;
        int a = num;
        int b = 0;
        buildmat();
        int k;
        for ( k = 1; k < (n / 2) + 1; k++) {

            if (arr[i] - mat[i + 1][j] > arr[j] - mat[i][j - 1]) {
                System.out.println("turn num: " + k + " second took :" + arr[i]);
                b += arr[i];
                i++;
            } else {
                System.out.println("turn num: " + k + " second took :" + arr[j]);
                b += arr[j];
                j--;
            }

                if ((arr[i] - mat[i + 1][j]) > (arr[j] - mat[i][j - 1])) {
                    System.out.println("turn num: " + k + " first took :" + arr[i]);
                    a += arr[i];
                    i++;
                } else {
                    System.out.println("turn num: " + k + " first took :" + arr[j]);
                    a += arr[j];
                    j--;
                }

            }
        b += arr[j];
        System.out.println("turn num: " + k + " second took :" + arr[j]);


        System.out.println("first count his:" + a);
        System.out.println("2nd count his:" + b);
        System.out.println("first won in : "+(a-b));
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 4, 7, 2,8};
        Num_game_S game = new Num_game_S(arr);
        game.turns();
        for (int i = 0; i < arr.length; i++) {
            int chosen=arr[i];
            int a2[]=new int [arr.length-1];
            //build new array O(n)
            int k=0;
            for (int j = 0; j < arr.length; j++) {

                //if not chosen
                if (arr[j] != chosen) {
                    //add to new
                    a2[k] = arr[j];
                    k++;
                }
            }
                Num_game_S gamecycle = new Num_game_S(a2);
            System.out.println("first took rom cycle " +chosen);
                gamecycle.turns_cycle(chosen);



        }
    }
}

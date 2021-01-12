package TEST_2015_A_B;

public class Q1 {
    int steps=0;
    int min = 0;
    int max = 0;
    int max_count=0;
    int max_count_value=0;
int []a;


public Q1(int []arr){
a=arr;
}
     private void checkrad() {
        max = a[0];
         min = a[0];
         int times=0;

        for (int i = 1; i < a.length - 1; i = i + 2) {
            if (a[i] > a[i + 1]) {
                max = Math.max(a[i], max);
                min = Math.min(a[i + 1], min);
            } else {
                max = Math.max(a[i + 1], max);
                min = Math.min(a[i], min);
                steps+=2;
            }
        }


    }
    public  void countarray(){
    checkrad();
        int index=0;
        int rad=max-min;
        int []count=new int [rad+1];
        steps+=rad+1;
        for (int i = 0; i < a.length; i++) {
            index=a[i]-min;
            count[index]++;
            steps+=1;
            if (count[index]>max_count){
                max_count=count[index];
                max_count_value=a[i];
                steps+=1;
            }
        }



    }
    public void print(){
    if (max_count>(a.length/2)){
        System.out.println(max_count_value);

    }
    else System.out.println(0);

    }


}

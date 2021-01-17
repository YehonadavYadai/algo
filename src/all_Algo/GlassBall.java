package all_Algo;


import java.util.Arrays;
import java.util.Random;

public class GlassBall {


    public static void useFloorPotenial(int a,int []arr){

        int num=1;
        int numOfFloors=arr.length;
        //init our "p"
        while(numOfFloors>num*(num+1)/2){
            num++;
        }
        int jump=num;//start at p
        int step=num-1;//next step will be p-1 and so on.

        while(arr[jump]<a){
            jump=jump+step;
            step--;
        }
        //congres your broke the first one.

        System.out.println("first broken at "+jump+" floor");

        int floor=jump-(step+1);
        while (arr[floor]<a){
            floor++;
            // we have 1 one more ball so we check one after onw
        }
        System.out.println("the second ball broken this is your lowest floor: "+ floor);


    }

    public static void main(String[] args) {
        int []arr=new int[20];
        for (int i = 0; i < 20; i++) {
            Random q=new Random();
            arr[i]=q.nextInt(1000);
        }
        Arrays.sort(arr);
        useFloorPotenial(800,arr);
    }
}
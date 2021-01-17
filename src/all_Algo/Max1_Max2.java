package all_Algo;

import java.util.Random;
import java.util.Stack;

public class Max1_Max2 {
//    int max1 = 0;
//    int max2 = 0;
//    int[] a;



    public  Max1_Max2(int[] a) {
        int max1 = a[0];
        int max2 = a[1];
        int n = a.length;
        int count=0;

        for (int i = 2; i < a.length -1 ; i = i + 2) {
            //if a[i] bigger
            count++;
            int x=a[i];
            int y=a[i+1];
            if (a[i] > a[i + 1]) {

                //if a[i] bigger then max2
                count++;
                if (a[i] > max2) {

                    //if a[i] bigger then max1
                    count++;
                    if (a[i] > max1) {


                        count++;
                        max2 = Math.max(a[i + 1], max1);
                        max1 = a[i];
                    }
                    //if max1 bigger then a[i]
                    else {
                        max2 = a[i];
                    }
                }
                //if a[i] lower then max2;
                else {
                    //do nothing
                }
            }
            //if a[i+1] bigger then a[i]
            else {
                count++;
                if (a[i + 1] > max2) {
                    //if a[i+1] bigger then max1
                    count++;
                    if (a[i + 1] > max1) {

                        count++;
                        max2 = Math.max(a[i], max1);
                        max1 = a[i + 1];
                    }
                    //if max1 bigger then a[i+1]
                    else {
                        max2 = a[i + 1];
                    }

                }

            }
        }
        count++;
        if (a.length % 2 == 1) {
            //i its odd we check the last that wasnt in the oor loop
            //if bigger then max2
            count++;
            if (a[a.length - 1] > max2) {
                //if bigger then max1
                count++;
                count++;
                if (a[n - 1] > max1) {
                    max2 = max1;
                    max1 = a[n - 1];
                }
                //he is bigger only from max2
                else {
                    max2 = a[n - 1];
                }
            }
        }
        //else is lower from max2 *do nothing*
        System.out.println("num of check is : "+count);
        System.out.println("max 1 is:"+max1+" max 2 is : "+max2);
    }
    public int maxMax2(Node a[],int low,int high){
        int index=0;
        int mid=0;
        if (low<high){
            index=0;
            mid=(low+high)/2;
            int i=maxMax2(a,low,mid);
            int j=maxMax2(a,mid+1,high);
            if(a[i].num>a[j].num){
                a[i].st.push(a[j].num);
                index=i;
            }
            else{
                a[j].st.push(a[i].num);
                index=j;
            }
            return index;}

            else{
                return low;
            }

        }

    public Max1_Max2(int a[],int n) {
        int index = 0;
        int max2 = 0;
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(a[i]);
        }
            index = maxMax2(arr, 0, n - 1);
            max2 = arr[index].st.pop();
            while (!(arr[index].st.isEmpty())) {
                max2=Math.max(max2,arr[index].st.pop());

            }
            System.out.println("max 1 is: "+arr[index].num+" max 2 is : "+max2);

        }

    class Node {
        int num = 0;
        Stack<Integer> st = new Stack<Integer>();

        public Node(int num) {
            this.num = num;
        }
    }



    public static void main(String[] args) {
        int n=50;
        int []arr=new int[n];
        //make random array
        for (int i = 0; i < 10; i++) {
        for (int j= 0; j< n; j++) {
            Random q=new Random();
            arr[j]=q.nextInt(10000);
        }
        arr[n-1]=999;
//        arr[n-2]=990;


            System.out.print("normal is: ");
            Max1_Max2 q = new Max1_Max2(arr);

            System.out.print("stack is : ");
            Max1_Max2 q2 = new Max1_Max2(arr, n);
        }
    }


}
import jdk.dynalink.NamedOperation;

public class ParkingProb {

    public static void main(String[] args) {


        ListPark l= new ListPark();
        int len=0;

        l.add(0);
        l.add(5);
        l.add(3);
        l.add(7);
        l.add(6);
        l.head.data=1;

        NodePark temp=l.head.next;
        boolean ans=false;

        while(!ans) {
            int count = 1;// i count num of cars.
            while (temp.data != 1) { // as long i havent reaches the start.
                temp = temp.next;
                count++;
            }

            temp.data = 0; // point that suspected to be the start we will mark it on 0.

            len = count;// count so far
            while (count < 0) {
                temp = temp.prev;
                count--;
            }
            if (temp.data == 0) ans = true;
            else temp = temp.next;
        }
        System.out.println("the num of cars is "+ len);

            }
        }



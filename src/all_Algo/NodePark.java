package all_Algo;

public class NodePark {
    int count = 0;
    LinkedListc l = new LinkedListc();

    node head=null;
    final char v = 'v';
    final char w = 'w';

    
    public void set_arm(int num){
        head=new node();
        node arm=head;
        for (int i = 0; i < num-1; i++) {
            arm.next=new node();
            arm.next.prev=arm;
            arm=arm.next;
        }
        arm.next=l.head;
    }


    public int countcars() {
        if (l.head.next==null)
        {

            count=0;
            return count;
        }
        l.head.set('v');//put v on the first car
       node current = l.head.next;
        count = 0;

        boolean flag = true;
        while (flag) {

            if (current.data == v) {// if we found v we wil go back
                current.set(w);
                int i = count+1;
                while (i > 0) {
                    current = current.prev;
                    i--;//numver of step prev
                }
                if (current.data == w) flag = false;// we had the head
                else {
                    count = 0;
                    current=l.head.next;//we didint reached head
                }
            } else {
                count++;
                System.out.println(count);
                current = current.next;
            }


        }
        System.out.println("num of counts is :"+count);
        return count;

    }


    public static void main(String[] args) {
        //build linked list
        NodePark a = new NodePark();
        for (int i = 0; i <30; i++) {
            a.l.addnode();
        }
        a.set_arm(20);

        a.countcars();



    }


}
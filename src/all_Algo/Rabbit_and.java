package all_Algo;

public class Rabbit_and {
LinkedListc l=new LinkedListc();
node head= new node();
int count =0;
node tail_arm;
node tertel;
node rabbit;
node bot;

public Rabbit_and()
{
head=l.head;
}
    public void set_arm(int num){
        head=new node();
        node arm=head;
        for (int i = 0; i < num-1; i++) {
            arm.next=new node(i+30);
            arm.next.prev=arm;
            arm=arm.next;
        }
        tail_arm=arm;
        tail_arm.next=l.head;
    }
    public void check_cycle(){
    node r=rabbit;
    node t=tertel;
   r=r.next.next;
    t=t.next;
    int c=0;
    while(r.data1!=t.data1){
        r=r.next.next;
        t=t.next;
        c++;
    }
        System.out.println("num of car in cycle is : "+c);
    }
public void check_arm(){
    node t=tertel;
    node v=head;
    int c=0;
    while(t.data1!=v.data1){
        v=v.next;
        t=t.next;
        c++;
    }
    System.out.println("number of arm is : "+c);

}
    public boolean ifCycle(){
        boolean flag=true;
        boolean ans=false;
        int count=0;
        head.data='1';
        tertel=head;
         rabbit=head;

        while (flag){

            if(tertel.next()==null||rabbit.next()==null||rabbit.next().next()==null){
                System.out.println("no cycle");
                flag=false;
                ans=false;
            }
            else {
                tertel=tertel.next();
                rabbit=rabbit.next.next;
                count++;
                //System.out.println( "num of moves: "+ count);
                if(tertel.data1== rabbit.data1){
                    check_arm();
                    check_cycle();
                    System.out.println( "k is: "+ count);
                    System.out.println("is cycle");
                    flag=false;
                    ans=true;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Rabbit_and a=new Rabbit_and();
        for (int i = 0; i < 20; i++) {
            a.l.addnode(i+1000);
        }
        a.set_arm(29);

        System.out.println(a.ifCycle());
    }
}


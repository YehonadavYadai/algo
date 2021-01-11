package all_Algo;

public class Rabbit_and {
LinkedListc l=new LinkedListc(150);
node head= new node(200);
int count =0;

public Rabbit_and(){
    node current=head;
    for (int i = 0; i < 4; i++) {
        node k =new node(i);
        current.next=k;
        current = current.next;
    }
    current.next=l.head;
    for (int i = 0; i < 768; i++) {
        this.l.addnode(i+10);
    }
}


    public boolean ifCycle(){
        boolean flag=true;
        boolean ans=false;
        int count=0;
        head.data='1';
        node tertel=head;
        node rabbit=head;

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
                System.out.println( "num of moves: "+ count);
                if(tertel.data2== rabbit.data2){
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
        System.out.println(a.ifCycle());
    }
}


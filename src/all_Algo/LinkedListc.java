package all_Algo;

public class LinkedListc
{
node head;


public LinkedListc(){
    node c=new node();
    head=c;
   head.next=c;
   head.prev=c;


}
public void addnode(){
    node tail=new node();
    node old_tail=head.prev;
    //set head.
    head.prev=tail;
    //set new node
    tail.next=head;
    tail.prev=old_tail;
    // set old_tail
    old_tail.next=tail;

    }
    public void addnode(int v){
        node tail=new node(v);
        node old_tail=head.prev;
        //set head.
        head.prev=tail;
        //set new node
        tail.next=head;
        tail.prev=old_tail;
        // set old_tail
        old_tail.next=tail;

    }








}

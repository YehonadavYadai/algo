package all_Algo;

public class LinkedListc
{
node head;


public LinkedListc(int a){
    node c=new node(a);
    head=c;
    head.next=c;
    head.prev=c;



}
public void addnode(int a){
    node v=new node(a);
    v.prev=head.prev;
    v.next=head;
    v.prev.next=v;
    head.prev=v;


    }








}

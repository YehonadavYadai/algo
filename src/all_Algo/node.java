package all_Algo;

public class node{
    char data;
    int data2;
   node next;
   node prev;

    public node (int a){
        data2=a;
        data=' ';
        next=null;
        prev=null;
    }

    public node next(){
        return this.next;
    }
    public node getPrev(){
        return prev;
    }
    public void set(char c){
        this.data=c;
    }
}

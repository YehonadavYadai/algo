package all_Algo;

public class node {
    node next;
    node prev;
    char data=' ';
    int data1=0;

    public node ( ){
    next=null;
    }
    public node (int a){
        next=null;
        data1=a;
    }
    public void set(char c){
        this.data=c;
    }
    public node next(){
        return next;
    }
    public node prev(){
        return prev;
    }

}

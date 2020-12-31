public class findMax1Max2_withStack {



    public static StackNodeCircle initalize(int arr[]) {

        StackNodeCircle head=new StackNodeCircle(arr[0],null,null);
        int size =arr.length;
        StackNodeCircle tempNode=head;
        StackNodeCircle nowNode=null;

        for (int i = 1; i < size; i++) {
            nowNode=new StackNodeCircle(arr[i],tempNode,null);
            tempNode.next=nowNode;
            nowNode.prev=tempNode;
            tempNode=tempNode.next;
        }
        nowNode.next=head;//make it circle
        head.prev=nowNode;//make it circle.
        return head;

    }


}

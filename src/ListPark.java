public class ListPark {
    NodePark head;
    NodePark tail;
    public ListPark() {
        tail = null;
        head = tail;
    }
    public void add(int a) {
        if (head==null) {
            head = new NodePark(a);
            head.next = head;
            head.prev = head;
            tail = head;
        } else {
            NodePark n = new NodePark(a);
            n.next = head;
            n.prev = tail;
            head.prev = n;
            tail.next = n;
            tail = tail.next;
        }
    }
}
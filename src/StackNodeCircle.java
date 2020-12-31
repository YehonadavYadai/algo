import java.util.Stack;
public class StackNodeCircle {
    StackNodeCircle next;
    StackNodeCircle prev;
    int max1; // הערך של האיבר מהמערך נכנס לתוך משתנה העצם הזה: -
    Stack <Integer> stackOfNode;
    // ניתן היה לבנות כאן בנאי ברירת מחדל, אך ניתן להסתדר גם אם בנאי בודד
    public StackNodeCircle(int data, StackNodeCircle n, StackNodeCircle p){
        max1 = data;
        next = n;
        prev = p;
        stackOfNode = new Stack<Integer>(); // הצהרה על מחסנית חדשה
    }
}
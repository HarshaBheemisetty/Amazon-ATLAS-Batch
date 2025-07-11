package DSA;
class Node13
{
    int data;
    Node13 next;
    Node13(int val)
    {
        data=val;
        next=null;
    }
}
public class ReverseLL_Iterative
{
    static Node13 reverseList(Node13 head)
    {
        Node13 curr2 = head, prev=null,next;
        while(curr2!=null)
        {
            next=curr2.next;
            curr2.next=prev;
            prev=curr2;
            curr2=next;
        }
        return prev;
    }
    static void PrintList(Node13 node)
    {
        while(node!=null)
        {
            System.out.print(" "+ node.data);
            node=node.next;
        }
    }

    public static void main(String[] args)
    {
        Node13 head = new Node13(1);
        head.next = new Node13(2);
        head.next.next = new Node13(3);
        head.next.next.next = new Node13(4);
        head.next.next.next.next = new Node13(5);
        System.out.print("Given Linked List : ");
        PrintList(head);
        head=reverseList(head);
        System.out.print("\nReversed Linked List : ");
        PrintList(head);
    }
}

package DSA;
import java.util.LinkedList;
import java.util.*;
class Node
{
    int data; // Stores the value of the node.
    Node next;//Stores a reference to the next node in the list.
    Node(int x) //The constructor Node(int x) sets the data to x and initializes next to null.
    {
        this.data=x;
        this.next=null;
    }
}
public class InsertionAtFirst
{
    Node head;
    public void insertStart(int data)
    {
        Node newNode= new Node(data); // create new node
        newNode.next=head; //Point newNode.next to current
        head=newNode; //Update head to newNode
    }
    public void insertLast(int data)
    {
        Node newNode=new Node(data);
        if(head==null) //If the list is empty or there is no node in linkedlist at all
        {
            head=newNode;
            return;
        }

        Node temp = head; // starting from head
        while(temp.next!=null) // tranverse till the last node
        {
            temp=temp.next;
        }
        temp.next=newNode; // Link lastnode to the newNode

    }
    public void insertPosition(int data, int pos)
    {
        if(pos<=0)
        {
            System.out.println("Invalid Position");
            return;
        }
        Node newNode=new Node(data);
        //insert at beginning
        if(pos==1)
        {
            newNode.next=head;
            head=newNode;
            return;
        }
        //insert at middle or end
        Node temp=head;
        for(int i=1;i<pos-1&&temp!=null;i++)
        {
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;


    }
}

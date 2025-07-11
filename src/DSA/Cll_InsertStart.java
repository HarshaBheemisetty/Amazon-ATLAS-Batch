package DSA;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node11{

    int data;
    Node11 next;

    Node11(int x)
    {
        data = x;
        next = null;
    }
}
class Cll_InsertStart{

    static Node11 insert (Node11 head, int data)
    {
        Node11 newNode = new Node11(data);

        // if this is the first node
        if (head == null)
        {
            newNode.next = newNode;
            return newNode;
        }
        // add element just after the head node
        // swap data values of new_node and head node
        newNode.next = head.next;
        head.next = newNode;
        int temp = head.data;
        head.data = newNode.data;
        newNode.data = temp;

        return head;
    }

    static void display2(Node11 head)
    {

        if (head == null)
            return;
        Node11 temp = head;
        do
        {
            System.out.print (temp.data + " ");
            temp = temp.next;
        }
        while (temp != head);
    }


    public static void main (String args[])
    {

        Node11 head = null;

        head = insert (head, 12);
        head = insert (head, 16);
        head = insert (head, 20);
        head = insert (head, 24);
        head = insert (head, 30);
        head = insert (head, 22);

        System.out.println (head.data);
        display2 (head);

    }
}
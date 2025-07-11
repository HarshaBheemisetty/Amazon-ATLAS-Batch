package DSA;
import java.util.*;
import java.io.*;
import java.lang.*;

class Node10
{
    int data;
    Node10 next;

    Node10(int x)
    {
        data=x;
        next=null;
    }
}

public class CircularLinkedList_InsertLast
{
    static Node10 insertLast(Node10 head, int data) {
        Node10 newNode = new Node10(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        newNode.next = head.next;
        head.next = newNode;
        int temp = head.data;
        head.data = newNode.data;
        newNode.data = temp;
        head = newNode;
        return head;
    }
    static void display4(Node10 head)
    {
        if(head==null)
        {
            return;
        }
        Node10 temp=head;
        do
        {
            System.out.print (temp.data + " ");
            temp = temp.next;
        }
        while (temp != head);
    }

    public static void main(String args[])
    {
        Node10 head = null;

        head = insertLast (head, 1);
        head = insertLast (head, 2);
        head = insertLast (head, 3);
        head = insertLast (head, 4);
        head = insertLast (head, 5);
        head = insertLast (head, 6);

        System.out.println (head.data);
        display4(head);

    }
}

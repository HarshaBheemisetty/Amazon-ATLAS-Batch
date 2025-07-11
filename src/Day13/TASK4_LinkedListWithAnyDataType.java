package Day13;

import java.util.*;
import java.util.ArrayList;
class Node1<T> {
    T data;
    Node1<T> next;

    public Node1(T data) {
        this.data = data;
        this.next = null;
    }
}
public class TASK4_LinkedListWithAnyDataType<T> {
    private Node1<T> head;
    private int size = 0;

    public void add(T data) {
        Node1<T> newNode = new Node1<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node1<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        Node1<T> newNode = new Node1<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    public T get(int index) {
        checkBounds(index);
        Node1<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}


class Task004_DS_CustomLinkedList {
    public static void main(String[] args) {
        TASK4_LinkedListWithAnyDataType<String> liobj = new TASK4_LinkedListWithAnyDataType<>();
        liobj.add("Anitha");
        liobj.add("Verma");
        liobj.addFirst("Jack");

        System.out.println("First Element: " + liobj.get(0));
        System.out.println("Size: " + liobj.size());

        liobj .removeFirst();

        System.out.println("First Element after removal: " + liobj.get(0));
        System.out.println("Size after removal: " + liobj.size());
    }
}

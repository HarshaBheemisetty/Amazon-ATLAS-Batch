package Day14;

class Node6{
    int data;
    Node6 next;

    Node6(int data) {
        this.data = data;
        this.next = null;
    }
}

public class TASK1 {
    Node6 head;

    public void push(int data) {
        Node6 newNode = new Node6(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node6 curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    public void display() {
        Node6 current = head;
        System.out.print("Linked List Elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TASK1 list = new TASK1();

        // Push 4 elements
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);

        // Display the list
        list.display();
    }
}


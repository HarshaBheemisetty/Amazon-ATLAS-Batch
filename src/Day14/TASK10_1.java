package Day14;

class Node9{
    int data;
    Node9 next;

    Node9(int data) {
        this.data = data;
        this.next = null;
    }
}

public class TASK10_1 {
    Node9 front = null;
    Node9 rear = null;
    int size = 0;
    int maxSize = 5;  // Optional: set a maximum queue size

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == maxSize;
    }

    // Enqueue (add to rear)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }

        Node9 newNode = new Node9(data);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println("Enqueued: " + data);
    }

    // Dequeue (remove from front)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        System.out.println("Dequeued: " + front.data);
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }
    }

    // Peek (see front element)
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    // Display all elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        Node9 current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        TASK10_1 queue = new TASK10_1();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Should show full message

        queue.display();

        queue.peek(); // Front element

        queue.dequeue();
        queue.display();

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Is queue full? " + queue.isFull());
    }
}

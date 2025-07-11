package Day14;

public class TASK10_QueueOperations {
    int front = -1;
    int rear = -1;
    int size;
    int[] queue;

    public TASK10_QueueOperations(int size) {
        this.size = size;
        queue = new int[size];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    // Check if the queue is full
    public boolean isFull() {
        return rear == size - 1;
    }

    // Enqueue (add element)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear++;
        queue[rear] = data;
        System.out.println("Enqueued: " + data);
    }

    // Dequeue (remove element)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        System.out.println("Dequeued: " + queue[front]);
        front++;
    }

    // Peek (front element)
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    // Display all elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        TASK10_QueueOperations q = new TASK10_QueueOperations(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.peek();         // Show front
        q.dequeue();      // Remove front
        q.display();      // After dequeue

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);    // Should fill the queue
        q.enqueue(70);    // Should say "Queue is full"

        q.display();
        System.out.println("Is queue full? " + q.isFull());
        System.out.println("Is queue empty? " + q.isEmpty());
    }
}

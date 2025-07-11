package Day13;

// Node class (Generic)
class Node2<T> {
    T data;
    Node2<T> next;

    public Node2(T data) {
        this.data = data;
        this.next = null;
    }
}

// Generic Linked List
class LinkedList2<T> {
    private Node2<T> head;
    private int size;

    public LinkedList2() {
        head = null;
        size = 0;
    }

    // Add element at end
    public void add(T value) {
        Node2<T> newNode = new Node2<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node2<T> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    // Remove node by value
    public void remove(T value) {
        if (head == null) return;

        if (head.data.equals(value)) {
            head = head.next;
            size--;
            return;
        }

        Node2<T> current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        } else {
            System.out.println("Element not found: " + value);
        }
    }

    // Display all elements
    public void display() {
        Node2<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Return size
    public int getSize() {
        return size;
    }

    // Get value by index (with index check)
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);

        Node2<T> temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.data;
    }
    public class TASK5_LinkedListWithOpertaions {
        public static void main(String[] args) {
            LinkedList2<String> list = new LinkedList2<>();

            list.add("Apple");
            list.add("Banana");
            list.add("Cherry");

            System.out.println("List elements:");
            list.display();  // Apple → Banana → Cherry → NULL

            list.remove("Banana");
            System.out.println("After removing Banana:");
            list.display();  // Apple → Cherry → NULL

            System.out.println("Size of list: " + list.getSize());  // 2

            try {
                System.out.println("Element at index 1: " + list.get(1));  // Cherry
                System.out.println("Element at index 5: " + list.get(5));  // Throws exception
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

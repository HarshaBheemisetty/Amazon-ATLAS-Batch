package Day14;

import java.util.ArrayList;

class Node {
    int data;

    Node(int data) {
        this.data = data;
    }
}

public class TASK_1 {
    public static void main(String[] args) {
        ArrayList<Node> List = new ArrayList<>();

        List.add(new Node(10));
        List.add(new Node(20));
        List.add(new Node(30));
        List.add(new Node(40));

        // Step 3: Traverse and display each node's data
        System.out.print("Node Data in ArrayList: ");
        for (int i = 0; i < List.size(); i++) {
            System.out.print(List.get(i).data + " ");
        }
    }
}

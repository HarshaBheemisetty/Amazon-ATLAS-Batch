package Day13;

import java.util.LinkedList;
class TASK9_UpdateNewElement
{
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Grapes");
        System.out.println("LinkedList elements: " + fruits);
        fruits.set(1, "Fig");
        System.out.println("LinkedList elements After Updating : " + fruits);
        for(String s : fruits)
        {
            System.out.println(s);
        }

    }

}

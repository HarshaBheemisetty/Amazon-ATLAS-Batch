class Node12
{
    int data;
    Node12 left;
    Node12 right;

    Node12(int val)
    {
        data=val;
        left=right=null;
    }
}
public class Day15_InOrderTraversal
{
    public static void InOrder(Node12 root)
    {
        if(root!=null)
        {
            InOrder(root.left);
            System.out.println(root.data+" ");
            InOrder(root.right);
        }
    }

    public static void main(String[] args)
    {
        Node12 root = new Node12(10);
        root.left = new Node12(20);
        root.right= new Node12(30);
        root.right.left=new Node12(40);
        root.right.right=new Node12(50);
        InOrder(root);

    }
}

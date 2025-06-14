public class TASK034
{
    void add(int x, int y)
    {
        System.out.println(x+y);
    }
    void add(int x, int y, int z)
    {
        System.out.println(x+y+z);
    }

    public static void main(String[] args)
    {
        TASK034 T = new TASK034();
        T.add(10,20);
        T.add(20,30,24);

    }
}

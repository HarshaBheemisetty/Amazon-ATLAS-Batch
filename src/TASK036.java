public class TASK036
{
    void add(int x, float y)
    {
        System.out.println(x+y);
    }
    void add(float x, int y)
    {
        System.out.println(x+y);
    }

    public static void main(String[] args)
    {
        TASK036 T = new TASK036();
        T.add(10, 20.45f);
        T.add(20.45f, 30);

    }
}

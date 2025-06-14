public class TASK035
{
    void add(char x, char y)
    {
        System.out.println(x+y);
    }
    void add(int x, int y)
    {
        System.out.println(x+y);
    }

    public static void main(String[] args)
    {
        TASK035 T = new TASK035();
        T.add('h','a');
        T.add(20,30);

    }
}

public class TASK7
{
    public static void fun() throws IllegalAccessException
    {
        System.out.println("Inside fun()");
        throw new IllegalAccessException("Demo Exception in fun method.");
    }

    public static void main(String[] args)
    {
        try
        {
            fun();
        }
        catch(IllegalAccessException e)
        {
            System.out.println("Caught in Main."+e.getMessage());
        }
    }

}

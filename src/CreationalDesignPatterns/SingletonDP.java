package CreationalDesignPatterns;
class orderIDGenerator
{
    private static orderIDGenerator instance;
    private int counter=0;

    private orderIDGenerator()
    {
        //The constructor is private, so other classes cannot call new OrderIdGenerator().
        // This is essential to enforce the singleton: only this class controls instance creation.
    }
    public static synchronized orderIDGenerator getInstance()
    {
        if(instance==null)
        {
            instance=new orderIDGenerator();
        }
        return instance;
    }
    public synchronized int getNextOrderID()
    {
        return ++counter;
    }
}
public class SingletonDP
{
    public static void main(String[] args) {
        System.out.println("=== Food Ordering App ===");

        orderIDGenerator gen1 = orderIDGenerator.getInstance();
        orderIDGenerator gen2 = orderIDGenerator.getInstance();

        System.out.println("Order 1 ID: " + gen1.getNextOrderID());
        System.out.println("Order 2 ID: " + gen2.getNextOrderID());

        // Both gen1 and gen2 are same instance
        System.out.println("Same object? " + (gen1 == gen2));
    }

}

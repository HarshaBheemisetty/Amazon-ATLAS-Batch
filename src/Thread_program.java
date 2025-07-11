public class Thread_program extends Thread
{
    public static void main(String[] args) {
        Thread_program thread = new Thread_program();
        thread.start();
        System.out.println("Outside of the thread");
    }

    public void run()
    {
        System.out.println("This code is running a thread");
    }
}

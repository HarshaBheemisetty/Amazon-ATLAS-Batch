class Resource {
    public synchronized void methodA(Resource r2) {
        System.out.println(Thread.currentThread().getName() + " is executing methodA");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " trying to call methodB");
        r2.methodB(this);
    }

    public synchronized void methodB(Resource r1) {
        System.out.println(Thread.currentThread().getName() + " is executing methodB");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println(Thread.currentThread().getName() + " trying to call methodA");
        r1.methodA(this);
    }
}

public class Day10_TASK10 {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        Thread t1 = new Thread(() -> r1.methodA(r2), "Thread-1");
        Thread t2 = new Thread(() -> r2.methodB(r1), "Thread-2");

        t1.start();
        t2.start();
    }
}

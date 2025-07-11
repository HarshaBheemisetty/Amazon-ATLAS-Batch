class Counter4 {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
class ThreadDemo4 extends Thread {
    Counter counter;

    ThreadDemo4(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

public class Day10_TASK8 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadDemo4 t1 = new ThreadDemo4(counter);
        ThreadDemo4 t2 = new ThreadDemo4(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}

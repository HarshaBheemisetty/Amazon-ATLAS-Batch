class Test extends Thread{
    public void run(){
        System.out.println("thread started.");
    }
}
public class Day10_TASK18 {
    public static void main(String args[]){

        Test t1 = new Test();
        t1.run(); //not t1.start
    }
}

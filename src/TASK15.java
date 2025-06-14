class OuterClass4 {
    int x = 10;
    static class InnerClass {
        static int y = 5;
    }
}
public class TASK15 {
    public static void main(String[] args) {
        OuterClass4.InnerClass myInner = new OuterClass4.InnerClass();
        System.out.println(myInner.y);
        System.out.println(OuterClass4.InnerClass.y);


    }
}

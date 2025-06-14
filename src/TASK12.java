class OuterClass6 {
    int x = 10;
    private class InnerClass {
        int y = 5;
    }
}

public class TASK12 {
    public static void main(String[] args) {
        OuterClass6 myOuter = new OuterClass6();
        //OuterClass6.InnerClass myInner = myOuter.new InnerClass();
        //System.out.println(myInner.y + myOuter.x);
    }
}

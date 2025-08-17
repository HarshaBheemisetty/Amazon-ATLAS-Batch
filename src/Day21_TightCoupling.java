class Student1 {
    public int roll_no = 10;
    //private int roll_no = 10;
    public int getRoll() {
        System.out.println("getRoll method");
        return roll_no;
    }
    public void setRoll(int roll) {
        if(!(roll > 100))
            roll_no = roll;
    }
}
class Day21_TightCoupling {
    public static void main(String[] args) {
        Student1 sobj = new Student1();
        //sobj.roll_no = 10;
        sobj.roll_no = 110;
        System.out.println("the roll no of student is "+ sobj.roll_no); // 110
    }
}

class Student {
    private int roll_no = 0;

    public int getRoll() {
        System.out.println("getRoll method");
        return roll_no;
    }

    public void setRoll(int roll) {
        if (!(roll > 100)) {  // ✅ Missing closing parenthesis fixed
            roll_no = roll;
        }
    }
}
class Day21_LooseCoupling {
    public static void main(String[] args) {
        Student sobj = new Student();  // ✅ Object created

        sobj.setRoll(10);  // ✅ Valid value passed

        System.out.println("The roll no of student is " + sobj.getRoll());  // ✅ Print correctly
    }
}

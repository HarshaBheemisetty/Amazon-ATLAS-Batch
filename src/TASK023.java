class Student1
{
    public int roll_no;
    public String name;
    Student1(int Roll_no, String Name)
    {
        this.roll_no = Roll_no;
        this.name = Name;
    }
}
class TASK023
{
    public static void main( String[] args)
    {
        Student1[] arr = new Student1[5];
        arr[0] = new Student1(1, "aman");
        arr[1] = new Student1(2, "vaibhav");
        arr[2] = new Student1(3, "shikar");
        arr[3] = new Student1(4, "dharmesh");
        arr[4] = new Student1(5, "mohit");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Element at " + i + " " + arr[i].roll_no + " " + arr[i].name+" ");
        }
    }

}


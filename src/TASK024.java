class Student2{
    public String name;
    Student2(String name)
    {
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
public class TASK024
{
    public static void main(String[] args)
    {
        Student2[] myStudents = new Student2[]{ new Student2("Dharma"),new Student2("sanvi"),new Student2("Rupa"),new Student2("Ajay")};
        for(Student2 m:myStudents)
        {
            System.out.println(m);
        }
    }
}

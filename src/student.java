class student{
    public String name;
    student(String name){
        this.name = name;
    }
}

class Main{
    public static void main (String[] args){

        // declares an Array and initializing the
        // elements of the array
        student[] myStudents = new student[]{
                new student("Dharma"),new student("sanvi"),
                new student("Rupa"),new student("Ajay")
        };
        // accessing the elements of the specified array
        for(student m:myStudents){
            System.out.println(m.toString());
        }
    }
}
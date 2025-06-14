class Task033_1{
    int var;
    Task033_1(int var){
        this.var = var;
    }
    public void getVar(){
        System.out.println("var value in super class is "+ var);
    }
}

class Derived extends Task033_1{
    Derived(int var) {
        super(var);
    }
    public static void main(String[] args){
        Derived sobj = new Derived(100);
        sobj.getVar();
    }
}
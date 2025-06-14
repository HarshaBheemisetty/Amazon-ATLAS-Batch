class Customer1{
    int cost = 40;
    String items = "Tomatoes";
    Customer1(){
        System.out.println("Constructor called");
    }
    void purchage_list(){
        System.out.println("cost of tomatoes in Customer class is "+ cost);
    }
}
class Task033 extends Customer1 {

    void billing(){
        String items = "onions";
        int cost = 30;

        super.items = "Potatoes";
        super.cost = 50;
        super.purchage_list();

        System.out.println(items);
        System.out.println(cost);
        System.out.println("***************************");
        System.out.println(super.items);
        System.out.println(super.cost);
        // return 0;
    }
    public static void main(String[] args){
        Customer1 cobj =new Customer1();
        cobj.purchage_list();
        Task033 tobj = new Task033();
        tobj.billing();

    }

}
class Customer {
    String items= "Tomatoes";
    int cost=40;
/*void billing(){
	//	cost = 40;
	//	items = “Tomatoes”;
	}
*/
}

class Mart extends Customer {
    String items2;
    int cost2;
    void billing(){
        items2 = "onions";
        cost2 = 30;
        System.out.println(items2);
        System.out.println(cost2);
        super.items ="potatoes";
        super.cost = 50;
        //  items2= super.items;
        System.out.println(super.items);
        System.out.println(super.cost);
    }

    public static void main(String[] args) {
        Mart m1= new Mart();
        m1.billing();
    }
}
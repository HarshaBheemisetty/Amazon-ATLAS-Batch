interface Pizza
{
    void prepare();
    void bake();
    void cut();
    void box();
}
class PepperoniPizza implements Pizza
{
    @Override
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Pepperoni Pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Pepperoni Pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Pepperoni Pizza...");
    }
}
interface PizzaFactory {
    Pizza createPizza();  // Factory Method
}
class PepperoniPizzaFactory implements PizzaFactory
{
    @Override
    public Pizza createPizza() {
        return new PepperoniPizza();  // Factory Method implementation
    }
}
public class Day23_FactoryMethod
{
    public static void main(String[] args) {
        PizzaFactory factory = new PepperoniPizzaFactory();
        Pizza pizza = factory.createPizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}

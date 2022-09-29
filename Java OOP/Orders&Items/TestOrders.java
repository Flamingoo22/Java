import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item mocha = new Item("mocha", 4.75);
        Item latte = new Item("latte", 5.5);
        Item dripCoffee = new Item("drip coffee", 2.0);
        Item cappuccino = new Item("capuccino", 5.5);
        // Order variables -- order1, order2 etc.
        ArrayList<Item> firstOrder =new ArrayList<Item>();
        firstOrder.add(mocha);
        ArrayList<Item> secondOrder =new ArrayList<Item>();
        secondOrder.add(latte);
        secondOrder.add(dripCoffee);
        ArrayList<Item> thirdOrder =new ArrayList<Item>();
        thirdOrder.add(cappuccino);
        ArrayList<Item> forthOrder =new ArrayList<Item>();
        forthOrder.add(cappuccino);

        Order order1 = new Order("Cindhuri", false, firstOrder);

        Order order2 = new Order("Jimmy", true, secondOrder);

        Order order3 = new Order("Noah", true, thirdOrder);

        Order order4 = new Order("Sam", true, forthOrder);


        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total());
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Order details: %s\n", order1.items);

        System.out.printf("Total for order 3: %s\n", order3.total());
        System.out.printf("Order details: %s\n", order3.items);
        order3.addOrder(cappuccino);
        System.out.printf("New total for order 3: %s\n", order3.total());
        System.out.printf("Order details: %s\n", order3.items);


        // System.out.printf("Total: %s\n", order4.total());
        order4.addOrder(latte);
        // System.out.printf("Total: %s\n", order4.total());

        order1.ready = true;

        System.out.printf("Order details: %s\n", order4.items);
        System.out.printf("Total for order4: %s\n", order4.total());
        order4.addOrder(latte);
        order4.addOrder(latte);
        System.out.printf("Order details: %s\n", order4.items);
        System.out.printf("New total for order4: %s\n", order4.total());

        // System.out.printf("Order details: %s\n", order2.items);
        // System.out.printf("Order details: %s\n", order3.items);
    }
}
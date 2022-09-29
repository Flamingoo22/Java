import java.util.ArrayList;
import java.util.Random;

public class TestOrder {
    public static void main (String[] args){
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("John");
        Order order4 = new Order("Steve");
        Order order5 = new Order("Sam");

        Item item1 = new Item("mocha", 4.75);
        Item item2 = new Item("latte", 5.5);
        Item item3 = new Item("drip coffee", 2.0);
        Item item4 = new Item("capuccino", 5.5);

        // int randomNum = new Random().nextInt(3);
        // ArrayList<Item> itemList = new ArrayList<Item>();

        // itemList.add(item1);
        // itemList.add(item2);
        // itemList.add(item3);
        // itemList.add(item4);
        
        // Item randomItem = itemList.get(randomNum);

        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item3);
        order2.addItem(item4);
        order3.addItem(item3);
        order3.addItem(item2);
        order4.addItem(item2);
        order4.addItem(item4);
        order5.addItem(item3);
        order5.addItem(item1);

        System.out.println(order1.getStatusMessage());
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());

        System.out.println(order1.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}

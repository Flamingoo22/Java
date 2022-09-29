import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    private static int numItems = 0;

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public int getNumItems(){
        return numItems;
    }

    public void addMenuItem(String name, double price){
        // String itemName = "item" + (char) getNumItems();
        Item item = new Item(name, price);
        this.menu.add(item);
        numItems++;
    }

    public void displayMenu(){
        for(Item item: this.menu){
            System.out.printf("%d %s -- %.2f \n", this.menu.indexOf(item), item.getName(), item.getPrice());
        }
    }

    public void newOrder(){
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        if(!name.equals("Fan")){
            // Your code:
            // Create a new order with the given input string
            // Show the user the menu, so they can choose items to add.
            Order order = new Order(name);
            this.displayMenu();
            
            // Prompts the user to enter an item number
            System.out.println("Please enter a menu item index or q to quit:");
            String itemNumber = System.console().readLine();
            
            // Write a while loop to collect all user's order items
            while(!itemNumber.equals("q")) {
                
                // Get the item object from the menu, and add the item to the order
                // Ask them to enter a new item index or q again, and take their input
                int itemNum = Integer.parseInt(itemNumber);
                Item item = this.menu.get(itemNum);
                order.addItem(item);
                System.out.println("Please enter a menu item index or q to quit:");
                itemNumber = System.console().readLine();
            }
            // After you have collected their order, print the order details 
            // as the example below. You may use the order's display method.
            order.display();
        }
        else
        {
            admin();
        }
    }

    private void admin(){
        System.out.println("Hi Fan, What would you like to do today? \n1 Add Item on the menu \n2 Change Item on the menu \n3 Change Order for customer \nPress Anyother key to Exit");
        String option = System.console().readLine();
        System.out.println("\n");
        switch(option){
            case "1":
                System.out.println("What would you like to add to the menu? \nPlease enter the name of the new item:");
                String name = System.console().readLine();
                System.out.println("\n");
                System.out.println("What is the price for the new item:");
                double price = Double.parseDouble(System.console().readLine());
                System.out.println("\n");
                addMenuItem(name, price);
                adminCont();
                break;
            case "2":
                break;
                
            default:
                System.out.println("Have a good day \n\n");
        }
    }

    private void adminCont(){
        System.out.println("Would you like to continue?");
        String option = System.console().readLine();
        System.out.println("\n");
        switch(option){
            case "1":
                admin();
                break;
            default:
                System.out.println("Have a good day \n\n");
        }
    }
}
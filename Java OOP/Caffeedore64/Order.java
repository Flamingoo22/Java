import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        this.name = "Guest";
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<Item>();
    }

    public String getName(){
        return this.name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void changeOrder(Item prevItem, Item newItem){
        int index = this.items.indexOf(prevItem);
        this.items.set(index, newItem);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public double getOrderTotal(){
        if(items.size() > 0){
            double total = 0;
            for(Item item: items){
                double price = item.getPrice();
                total += price;
            }
            return total;
        }
        return 0;
    }

    public void display(){
        System.out.printf("Customer Name: %s \n", this.name);
        for(Item item: items){
            String name = item.getName();
            double price = item.getPrice();
            System.out.printf("%s - $%.2f \n", name, price);
        }
        System.out.printf("Total: %.2f \n\n\n", this.getOrderTotal());
    }

}

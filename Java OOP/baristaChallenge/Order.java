import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
    this.name = "Guest";
    this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void setReady(boolean isReady){
        this.ready = isReady;
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        }
        else{
            return "Thank you for waiting, your order will be ready soon.";
        }
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

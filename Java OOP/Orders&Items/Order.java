import java.util.ArrayList;

public class Order {
    String name;
    double total;
    boolean ready;
    ArrayList<Item>items;

    public Order(String name, boolean ready, ArrayList<Item>items){
        this.name = name;
        this.ready = ready;
        this.items = items;
    }

    public double total(){
        double sum = 0;
        for (Item item : this.items){
            sum += item.price;
        }
        return sum;
    }

    public void addOrder(Item item){
        this.items.add(item);
    }

}


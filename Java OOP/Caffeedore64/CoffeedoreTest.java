
public class CoffeedoreTest {
    public static void main(String[] args){
        CoffeeKiosk system = new CoffeeKiosk();
        for(int i = 0; i < 5; i++){
            system.newOrder();
            System.out.println("\n");
        }
    }
}

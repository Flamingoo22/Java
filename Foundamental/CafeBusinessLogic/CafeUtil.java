import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(){
        int sum = 0;
        for ( int i = 1; i<=10; i++){
            sum += i;
        }
        return sum;
    }
    public int getOrderTotal(double[] lineItems){
        int sum = 0;
        for (int i = 0; i < lineItems.length; i++){
            sum += lineItems[i];
        }
        return sum;
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        double sum = price;
        for (int i = 1; i <= maxQuantity; i++){
            System.out.format("%d - $%.2f \n", i, sum);
            // price -= 0.5;
            sum += price - 0.5;
        }
    }


    public boolean displayMenu(ArrayList<String> menu, ArrayList<Double> prices){
        if (menu.size() == prices.size()){
            for ( String drink : menu){
                int index = menu.indexOf(drink);
                double price = prices.get(index);
                System.out.format("%d %s -- $%.2f \n",index, drink, price);
            }
            return true;
        }
        return false;
    }

    public String addCustomer(ArrayList<Object> customers){
        int index;
        System.out.println("Please enter your name: \nEnter 'g' if it's group order.");
        String userName = System.console().readLine();

        if (userName.equals("g")){
            ArrayList<String> group = new ArrayList <String>();
            while (!userName.equals("q")){
                System.out.println("Please enter the the name: \nEnter q when finished");
                userName = System.console().readLine();
                if(userName.equals("q")){
                    break;
                }
                System.out.println("Hello, "+ userName);
                group.add(userName);
            }
            customers.add(group);
            index = customers.indexOf(group);
        }
        else
        {
            System.out.println("Hello, "+ userName);
            customers.add(userName);
            index = customers.indexOf(userName);
        }
        System.out.format("There are %d orders in front of you \n\n", index);
        System.out.println(customers);
        return "What does it mean no need to return anything? how do I do that";
    }
}
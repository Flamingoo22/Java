
public class Greeter{
    public String greet(String name){
        return createGreeting(name);
    }    

    public String greet(){
        return createGreeting("World");
    }

    public String greet(String firstName, String lastName){
        return createGreeting(firstName + " " + lastName);
    }
    private String createGreeting(String toBeGreeted){
        return "Greeting " + toBeGreeted + ", welcome to dojo.";
        //private can only be initilize within the class;
    }

    public static void testGreeting(String name){
        System.out.println("This is a testing message");
        // static method can be call in main method without instantiate the object
    }
}

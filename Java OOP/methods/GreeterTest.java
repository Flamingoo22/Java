
public class GreeterTest {
    public static void main (String[] args){
        Greeter g = new Greeter();

        String greeting = g.greet();
        String greetingWithName1 = g.greet();
        String greetingWithName2 = g.greet("Steve");
        String greetingWithName3 = g.greet("Steve", "S");
        System.out.println(greetingWithName1);
        System.out.println(greetingWithName2);
        System.out.println(greetingWithName3);

        // if (greeting.equals())

    }    
}

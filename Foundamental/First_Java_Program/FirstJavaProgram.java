package First_Java_Program;

public class FirstJavaProgram {
    public static void main(String[] args){
        String name = "Yifan";
        int age = 24;
        String location = "Fujian";
        String sf1 = String.format("My name is %s", name);
        String sf2 = String.format("I am %d years old", age);
        String sf3 = String.format("My hometown is %s", location);
        System.out.println(sf1);
        System.out.println(sf2);
        System.out.println(sf3);

        int seven = 7;

        System.out.println(seven > 10 ? "The number is greater than 10." : "The number is less than 10.");
    }
}

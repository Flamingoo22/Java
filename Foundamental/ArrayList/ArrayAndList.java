
import java.util.ArrayList;

class ArrayAndList {
    public static void main (String[] args){
        int[] myArray = new int[5];

        ArrayList<Integer>myList = new ArrayList<Integer>();
        System.out.println(myList);

        myList.add(10);
        myList.add(11);
        myList.add(12);
        System.out.println(myList);
        //getters and setters
        Integer num = myList.get(0);
        System.out.println(num);
        myList.set(0,9);
        Integer numNew = myList.get(0);
        System.out.println(numNew);

        ArrayList<Object> things = new ArrayList<Object>();
        things.add(10);
        things.add("HELLO");
        things.add(new ArrayList<Integer>());
        things.add(12.5);
        System.out.println(things);
    }
}

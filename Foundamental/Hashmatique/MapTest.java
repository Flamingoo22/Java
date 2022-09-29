import java.util.HashMap;
import java.util.Set;


public class MapTest {
    
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("MONTERO", "Cocaine and drinkin' with your friend, You live in the dark, boy, I cannot pretend, I'm not fazed, only here to sin, If Eve ain't in your garden, you know that you can");
        trackList.put("Old Town Road","You know what? I'm done, done, done");
        trackList.put("Panni","I thought you want this for my life. For my life. Said you wanted to see me thrive. You lied");
        trackList.put("INDUSTRY BABY","And this one is for the champions. I ain't lost since I began, yuh");

        Set<String> keys = trackList.keySet();
        
        for(String key : keys) {
            // System.out.println(key);
            // System.out.println(trackList.get(key));    
            String lyrics = trackList.get(key);
            System.out.printf("%s : %s  \n", key, lyrics);
        }
    
    }
}

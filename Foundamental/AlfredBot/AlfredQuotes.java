import java.util.Date;
import java.util.Calendar;

public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    // public String guestGreeting(String name) {
    //     // YOUR CODE HERE
    //     String greeting = String.format("Hello, %s. Lovely to see you.", name);
    //     return greeting;
    // }
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String greets;
        if (hour < 5 ){
            String greeting = String.format("Dear %s, You should get some rest now. Goodnight.", name);
            return greeting;
        }

        else if (hour < 12){
            greets = "Morning";
        }
        else if (hour < 17){
            greets = "Afternoon";
        }
        else{
            greets = "Evening";
        }
        String greeting = String.format("Good %s, %s. Lovely to see you.", greets, name);
        return greeting;
    }

    public String guestGreeting(String name, String time) {
        // YOUR CODE HERE
        String greeting = String.format("Good %s, %s. Lovely to see you.", time, name);
        return greeting;
    }

    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        String greeting = String.format("It is currently", date);
        // String greeting = String.format("It is currently %t.", date); %t
        return greeting;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if ( conversation.indexOf("Alexis") >= 0 ){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if ( conversation.indexOf("Alfred") >= 0 ){
            return "At your service. As you wish, naturally.";
        }
        else {
            return "Right. And with that I shall retire." ;
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}
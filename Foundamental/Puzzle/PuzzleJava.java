import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int index = 0;
        while(index < 11){
            int number = new Random().nextInt(21);
            numList.add(number);
            index ++;
        }
        return numList;
    }

    public char getRandomLetter(){
        Random r = new Random();
        return(char)(r.nextInt(26)+'A');
        // what does r.nextInt(26)+'A' return?
    } 

    public char getRandomLetterAll(){
        int r = new Random().nextInt(52);
        char letter = (r < 26) ? 'A' : 'a';
        return (char) (letter + r%26);
    }

    public String generatePassword(){
        String password = "";
        int num = 8;
        while(num > 0){
            password +=getRandomLetterAll();
            num --;
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int num){
        ArrayList<String> passwordSet = new ArrayList<String>();
        while(num > 0){
            passwordSet.add(generatePassword());
            num --;
        }
        return passwordSet;
    }

    public ArrayList<String> shuffleArray(ArrayList<String>passwordSet){
        // int random = new Random().nextInt(passwordSet.size());
        Collections.shuffle(passwordSet);
        return passwordSet;
    }
}

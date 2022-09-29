import java.util.ArrayList;

public class TestPuzzle {
    public static void main(String[] args){
        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
        
        char randomLetter = generator.getRandomLetter();
        System.out.println(randomLetter);
        
        char randomLetterAll = generator.getRandomLetterAll();
        System.out.println(randomLetterAll);
        
        String password = generator.generatePassword();
        System.out.println("Generated password: "+ password);
        
        ArrayList<String> passwordSet = generator.getNewPasswordSet(6);
        System.out.println(passwordSet);

        ArrayList<String> newPasswordSet1 = generator.shuffleArray(passwordSet);
        System.out.println(newPasswordSet1);
        ArrayList<String> newPasswordSet2 = generator.shuffleArray(passwordSet);
        System.out.println(newPasswordSet2);
        ArrayList<String> newPasswordSet3 = generator.shuffleArray(passwordSet);
        System.out.println(newPasswordSet3);

    }

    
}

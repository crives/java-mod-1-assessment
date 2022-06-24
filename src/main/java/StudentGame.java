import java.util.Random;
import java.util.Scanner;

public class StudentGame {
    public static int randInt;
    public static int gameLevel;
    public static String easy = "1.) Easy: If your number is higher or equal - (you win). If it's lower - (computer wins)";
    public static String medium = "2.) Medium: If your number is higher - (you win). If it's lower or equal - (computer wins).";
    public static String hard = "3.) Hard: If your number is equal - (you win). If it's not - (you lose).";
    public static String[] skillLevels = {easy, medium, hard};
    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Running...");
        chooseSkillLevel();
        game();
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        randInt = random.nextInt(10);
        return randInt;
    }

    public static void chooseSkillLevel() {

        System.out.println("This game has different skill levels.");
        System.out.println("Each level will have you guess a number against the program's number.");
        System.out.println("Please select a skill level below (1-3) ");
        System.out.println("");


        // Loop through array to print out message
        // Do a switch case to match number with level
        // Create game rule logic accordingly
        for (int i = 0; i < skillLevels.length; i++) {
            System.out.println(skillLevels[i]);
        }
        System.out.println("");
        System.out.println("Please choose a skill level by typing (1-3) corresponding to the skill level you'd like:");
        // Prompt user to choose skill level
        int chosenSLevel = inputScanner.nextInt();

    }

    public static void game() {
        boolean repeat = true;

        while(repeat) {
            System.out.println("Enter an integer between 0 and 10:");
            
            // switch (gameLevel) {
            //     case :

            // }


            try {
                int userInt = inputScanner.nextInt();
                randInt = generateRandomNumber();

                if (userInt > 10 || userInt < 1) {
                    throw new Exception();
                } else if (userInt >= randInt) {
                    System.out.println("You guessed " + userInt + " and the system picked " + randInt + ".");
                    System.out.println("You won!");
                    repeat = false;
                } else if (userInt < randInt) {
                    System.out.println("You guessed " + userInt + " and the system picked " + randInt + ".");
                    System.out.println("You lost!");
                    repeat = false;
                }

            } catch (Exception e) {
                String str = inputScanner.nextLine();
                System.out.println("|");  
                System.out.println("**Error!! Please only enter an integer between 0 and 10!**");  
                System.out.println("|");  
                System.out.println("|");   
                System.out.println("V");    
            }
        }
    }
}

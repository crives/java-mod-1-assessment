import java.util.Random;
import java.util.Scanner;

public class StudentGame {
    public static int randInt;
    public static int start;
    public static int end;
    public static String gameLevel;
    public static boolean repeat = true;
    public static boolean won = false;
    public static final String EASY = "1.) Easy: If your number is higher or equal - (you win). If it's lower - (computer wins)";
    public static final String MEDIUM = "2.) Medium: If your number is higher - (you win). If it's lower or equal - (computer wins).";
    public static final String HARD = "3.) Hard: If your number is equal - (you win). If it's not - (you lose).";
    public static String[] skillLevels = {EASY, MEDIUM, HARD};
    public static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Running...");
        chooseSkillLevel();
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        randInt = random.nextInt(10);
        return randInt;
    }

    // Loop through array to print out message
    // Do a switch case to match number with level
    // Include a try/catch for user input validation
    public static void chooseSkillLevel() {
        start = 1;
        end = skillLevels.length;

        System.out.println("This game has different skill levels.");
        System.out.println("Each level will have you guess a number against the program's number.");
        System.out.println("Please select a skill level below (1-3) ");
        System.out.println("");

        for (int i = 0; i < skillLevels.length; i++) {
            System.out.println(skillLevels[i]);
        }

        // Do try catch for user input
        while (repeat) {
            System.out.println("");
            System.out.println("Please choose a skill level by typing (1-3) corresponding to the skill level you'd like:");
            try {
                int chosenSLevel = inputScanner.nextInt();
                gameLevel = skillLevels[chosenSLevel - 1];
                if (chosenSLevel < skillLevels.length || chosenSLevel < 1) {
                    throw new Exception();
                } else {
                    game();
                    repeat = false;
                }
            } catch (Exception e) {
                outOfBoundsException(start, end);
                repeat = true;
            }
        }
    }

    public static void game() {
        start = 0;
        end = 10;

        while(repeat) {
            System.out.println("Enter an integer between " + start + " and " + end + ":");

            try {
                int userInt = inputScanner.nextInt();
                randInt = generateRandomNumber();
            
                switch (gameLevel) {
                    case EASY:
                        won = (userInt >= randInt) ? true : 
                            (userInt < randInt) ? false : true; 
                        break;
                    case MEDIUM:
                        won = (userInt > randInt) ? true : 
                            (userInt <= randInt) ? false : true;
                    case HARD:
                        won = (userInt == randInt) ? true : false; 
                }

                if (userInt > 10 || userInt < 0) {
                    throw new Exception();
                } else if (won) {
                    printResultsMessage(userInt);
                    repeat = false;
                } else if (!won) {
                    printResultsMessage(userInt);
                    repeat = false;
                }

            } catch (Exception e) {
                outOfBoundsException(start, end);
            }
        }
    }

    public static void printResultsMessage(int userInt) {
        System.out.println("You guessed " + userInt + " and the system picked " + randInt + ".");
        String message = won ? "You won!" : "You lost!";
        System.out.println(message);
    }

    public static void outOfBoundsException(int start, int end) {
        String str = inputScanner.nextLine();
        System.out.println("|");  
        System.out.println("**Error!! Please only enter an integer between " + start + " and " + end + "!**");  
        System.out.println("|");  
        System.out.println("V");    
    }
}

import java.util.Random;
import java.util.Scanner;

public class StudentGame {
    public static int randInt;
    public static void main(String[] args) {
        System.out.println("Running...");
        Scanner inputScanner = new Scanner(System.in);

        boolean repeat = true;
        while(repeat) {
            System.out.println("Enter an integer between 0 and 10:");
            try {
                int userInt = inputScanner.nextInt();
                randInt = generateRandomNumber();

                if (userInt > 10 || userInt < 1) {
                    throw new Exception();
                } else if (userInt > randInt) {
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

    public static int generateRandomNumber() {
        Random random = new Random();
        randInt = random.nextInt(10);
        return randInt;
    }
}

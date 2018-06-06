import java.util.Random;

public class RockPaperScissorsGame {


    //static methods
    public static int getRandom() {
        Random rnd = new Random();
        return 1 + rnd.nextInt(3);
    }

    public static String playGame(int choice) {
        yourChoice(choice);
        return whoWon(choice,computerChoice(getRandom()));
    }

    /**
     * This function processes user's choice.
     *
     * @param choice is an integer based on user's input
     */

    public static void yourChoice(int choice) {

        switch (choice) {
            case (1):
                System.out.println("***You picked rock.***");
                break;
            case (2):
                System.out.println("***You picked paper.***");
                break;
            default:
                System.out.println("***You picked scissors.***");
        }
    }

    /**
     * This function processes compuiter's choice.
     *
     * @param number is an integer based on random number chosen by the function
     */

    public static int computerChoice(int number) {
        switch (number) {
            case (1):
                System.out.println("***Computer picked rock.***");
                return 1;
            case (2):
                System.out.println("***Computer picked paper.***");
                return 2;
            default:
                System.out.println("***Computer picked scissors.***");
                return 3;
        }
    }

    /**
     * This function decides the winner of the game.
     *
     * @param choice is an integer based on user's input*
     * @param number is an integer based on the random number chosen by the computer
     */

    public static String whoWon(int choice, int number) {
        if (number == choice) {
           return "***It's a draw.***";
        } else if (choice == 1 && number == 2 ||
                   choice == 2 && number == 3 ||
                   choice == 3 && number == 1) {
            return "***Computer won.***";

        } else return "***Congratulations, you won!***";
    }
}

import java.util.Scanner;
import java.util.Random;
public class Eliza {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String prompt = "";
        System.out.print("Good day. What is your problem? " );
        while (!prompt.equals("Q") || !prompt.equals("q")) {
            System.out.print("Enter your response here or Q to quit: ");
            prompt = in.nextLine();
            if (prompt.equals("Q") || prompt.equals("q"))  break;
                System.out.println(respond(prompt));
        }

    }

    private static String respond(String prompt) {
        String response = prompt;
        Random rnd = new Random();
        int responseType = rnd.nextInt(3);
        if (responseType == 1) {
            response = replacePronouns(response);
            response = addQualifier(response, rnd);
        }
        else {
            response = hedge(rnd);
        }
        return response;
    }

    private static String hedge(Random rnd) {
        String response;
        String [] hedges = {"Please tell me more", "Many of my patients tell me the same thing", "It is getting late, maybe we had better quit"};
        response = hedges [rnd.nextInt(hedges.length)];
        return response;
    }

    private static String addQualifier(String response, Random rnd) {
        String [] qualifiers = {"Why do you say that", "You seem to think that", "So, you are concerned that"};
        response =  qualifiers [rnd.nextInt(qualifiers.length)]+ " " + response + "?";
        return response;
    }

    private static String replacePronouns(String response) {
        String [] responses = {"me", "my", "I", "am"};
        String [] replacements = {"you", "your", "you", "are"};
        for (int i = 0; i < responses.length; i++) {
            response = response.replace(responses[i], replacements[i]);
        }
        return response;
    }
}

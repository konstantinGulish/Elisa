import java.util.*;

public class Eliza {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String prompt = "";
        System.out.print("Good day. What is your problem? " );
        int counter = 0;
        while (!prompt.equals("Q") || !prompt.equals("q")) {
            System.out.print("Enter your response here or Q to quit: ");
            prompt = in.nextLine();
            if (prompt.equalsIgnoreCase("game")) {
                int userChoice; // represents rock, paper, scissors
                System.out.print("This is a basic text-based rock, paper, scissors game. \n" +
                        "You are playing against Eliza. \nPlease enter:\n\t(1) for rock\n\t(2) for paper\n\t(3) for scissors\n" +
                        "Your choice: ");
                userChoice = in.nextInt();
                System.out.println();
                    while (userChoice < 1 || userChoice > 3) {
                        System.out.print("Your choice is invalid.\nPlease enter a whole number between 1 and 3.\nYour choice: ");
                        System.out.println();
                        userChoice = in.nextInt();
                    }
                System.out.println(RockPaperScissorsGame.playGame(userChoice));
                break;
            }

            else if (prompt.equals("Q") || prompt.equals("q"))  break;
            String finalResponse = respond(prompt);
            System.out.println(finalResponse);
            counter++;
                if (counter==8) {
                    System.out.println("It is getting late, maybe we had better quit.");
                    break;}
        }
    System.exit(0);
    }

    private static String respond(String prompt) {
        String response = prompt;
        Random rnd = new Random();
        int responseType = 1 + rnd.nextInt(2);
        if (responseType == 1) {
            response = replacePronouns(response);
            response = addQualifier(response, rnd);
        }
        else if(responseType == 2){
            response = hedge(rnd);
        }
        if (prompt.equals("pig latin")){
            PigLatin pig = new PigLatin();
            return pig.create(response);
        }
        if (prompt.equalsIgnoreCase ("caps")) return response.replaceAll ("caps", "").toUpperCase();
        else if (prompt.equalsIgnoreCase ("lower case")) return response.replaceAll ("lower case", "").toLowerCase();
        else if (prompt.equalsIgnoreCase ("red")) {
            RedText rd = new RedText();
            return rd.makeRed(response);
        }
        else return response;
    }

    private static String hedge(Random rnd) {
        String [] hedgesA = {"Please tell me more",
                             "Many of my patients tell me the same thing",
                             "It is getting late, maybe we had better quit"};
        ArrayList<String> hedges = new ArrayList<String>(Arrays.asList(hedgesA));
        HashSet<String> hedgesHash = new HashSet<>(hedges);
        Iterator it = hedgesHash.iterator();
        String hedge = "";
        int responseId = rnd.nextInt(hedgesHash.size());
        for (int i = 0; i <= responseId; i++) {
            if (it.hasNext()) hedge = it.next().toString();
        }
        return hedge;
    }

    private static String addQualifier(String response, Random rnd) {
        String [] qualifiersA = {"Why do you say that", "You seem to think that", "So, you are concerned that"};
        ArrayList<String> qualifiers = new ArrayList<String>(Arrays.asList(qualifiersA));
        HashSet<String> qualifiersHash = new HashSet<>(qualifiers);
        Iterator it = qualifiersHash.iterator();
        int responseId = rnd.nextInt(qualifiersHash.size());
        String qualifier = "";
        for (int i = 0; i <= responseId; i++) {
            qualifier = it.next().toString();
        }
        return qualifier + " " + response + "?";
    }

    private static String replacePronouns(String response) {
        String [] responsesA = {"me", "my", "I", "am"};
        ArrayList<String> responses = new ArrayList<String>(Arrays.asList(responsesA));
        HashMap<String, String> replacementResponses = new HashMap();
        String [] replacementsA = {"you", "your", "you", "are"};
        //ArrayList<String> replacements = new ArrayList<String>(Arrays.asList( replacementsA));
        for (int i = 0; i < responsesA.length; i++){
                replacementResponses.put(responsesA[i],replacementsA[i]);
        }
        for (int i = 0; i < replacementResponses.size(); i++) {
            if (response.contains (" " + responses.get (i) )|| response.contains(responses.get(i) + " ") || response.equals(responses.get (i))) {
                response = response.replaceAll(responsesA[i], replacementResponses.get(responsesA[i]));
            }
        }
        return response;
    }
}

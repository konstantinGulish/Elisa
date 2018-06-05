import java.util.*;

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
        int responseType = 1; //rnd.nextInt(3);
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
        String [] hedgesA = {"Please tell me more", "Many of my patients tell me the same thing", "It is getting late, maybe we had better quit"};
        ArrayList<String> hedges = new ArrayList<String>(Arrays.asList(hedgesA));
        response = hedges.get (rnd.nextInt(hedges.size()));
        return response;
    }

    private static String addQualifier(String response, Random rnd) {
        String [] qualifiersA = {"Why do you say that", "You seem to think that", "So, you are concerned that"};
        ArrayList<String> qualifiers = new ArrayList<String>(Arrays.asList(qualifiersA));
        response =  qualifiers.get(rnd.nextInt(qualifiers.size()))+ " " + response + "?";
        return response;
    }

    private static String replacePronouns(String response) {
        String [] responsesA = {"me", "my", "I", "am"};
        ArrayList<String> responses = new ArrayList<String>(Arrays.asList(responsesA));
        HashMap<String, String> replacementResponses = new HashMap();
        String [] replacementsA = {"you", "your", "you", "are"};
        ArrayList<String> replacements = new ArrayList<String>(Arrays.asList( replacementsA));
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

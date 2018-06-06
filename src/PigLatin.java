public class PigLatin {

    // Constructor
    public PigLatin (){
    }

    //instance methods
    public String create (String userPrompt) {
        String [] words = userPrompt.split(" ");
        StringBuffer [] wordsBuffer = new StringBuffer[words.length];
        for (int i=0; i < words.length; i++) {
            wordsBuffer[i] = new StringBuffer(words[i]);
            if     (wordsBuffer[i].charAt(0) == 'a' ||
                    wordsBuffer[i].charAt(0) == 'e' ||
                    wordsBuffer[i].charAt(0) == 'o' ||
                    wordsBuffer[i].charAt(0) == 'u' ||
                    wordsBuffer[i].charAt(0) == 'i') {
                wordsBuffer[i].append("ay");
            }
            else {
                char first = wordsBuffer[i].charAt(0);
                first = Character.toLowerCase(first);
                wordsBuffer[i].replace(0, 1, "");
                wordsBuffer[i].append(first + "ay");
            }
        }
        String pigLatin = "";
        for (int i = 0; i < wordsBuffer.length; i++) {
            pigLatin += wordsBuffer[i].toString() + " ";
        }


        return pigLatin.replaceAll("\\p{Punct}+", "").toLowerCase();
    }
}
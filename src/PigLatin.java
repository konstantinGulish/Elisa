public class PigLatin {

    // Constructor
    public PigLatin (){
    }

    //instance methods
    public String create (String userPrompt) {
        //split input into a string array of words
        String [] words = userPrompt.split(" ");

        //create a StringBuffer array to hold the words to be changed
        StringBuffer [] wordsBuffer = new StringBuffer[words.length];
        for (int i=0; i < words.length; i++) {
            wordsBuffer[i] = new StringBuffer(words[i]);

        // check if words start with a vowel and append "ay"
            if     (wordsBuffer[i].charAt(0) == 'a' ||
                    wordsBuffer[i].charAt(0) == 'e' ||
                    wordsBuffer[i].charAt(0) == 'o' ||
                    wordsBuffer[i].charAt(0) == 'u' ||
                    wordsBuffer[i].charAt(0) == 'i') {
                wordsBuffer[i].append("ay");
            }

        // remove first later, append it at the end before the "ay"
            else {
                char first = wordsBuffer[i].charAt(0);
                first = Character.toLowerCase(first);
                wordsBuffer[i].replace(0, 1, "");
                wordsBuffer[i].append(first + "ay");
            }
        }
        StringBuilder pigLatin = new StringBuilder();

        // loop through the array and turn the elements back into a string
        for (int i = 0; i < wordsBuffer.length; i++) {
            pigLatin.append(wordsBuffer[i]).append(" ");
        }
        // remove punctuation and turn everything into lower case
        return pigLatin.toString().replaceAll("\\p{Punct}+", "").toLowerCase();
    }
}
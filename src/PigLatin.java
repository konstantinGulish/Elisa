public class PigLatin {

 public PigLatin (){

}
public String create (String userPrompt) {
     String [] words = userPrompt.split(" ");
     StringBuffer [] wordsBuffer = new StringBuffer[words.length];
     for (int i=0; i < words.length; i++) {
         wordsBuffer[i] = new StringBuffer(words[i]);
         StringBuffer original = wordsBuffer[i];
         if (original.charAt(0) == 'a' ||
                 original.charAt(0) == 'e' ||
                 original.charAt(0) == 'o' ||
                 original.charAt(0) == 'u' ||
                 original.charAt(0) == 'i') {
             original.append("ay");

         }
         else {
             char first = original.charAt(0);
             original.replace(0, 1, "");
             original.append(first + "ay");
         }
         wordsBuffer[i] = original;
     }
     String pigLatin = "";
    for (int i = 0; i < wordsBuffer.length; i++) {
        pigLatin = wordsBuffer[i].toString() + " ";
    }


    return pigLatin;

 }
}
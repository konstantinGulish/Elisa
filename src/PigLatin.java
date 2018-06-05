import javax.swing.plaf.PanelUI;

public class PigLatin {

 PigLatin (String userPrompt) {
    this.create (userPrompt);
}
public String create (String userPrompt) {
    StringBuffer orginal = new StringBuffer(response);
    if (    orginal.charAt(0)=='a'||
            orginal.charAt(0)=='e'||
            orginal.charAt(0)=='o'||
            orginal.charAt(0)=='u'||
            orginal.charAt(0)=='i') {
        orginal.append("ay");
    }
    else {
        char first = orginal.charAt(0);
        orginal.replace(0, 1, "");
        orginal.append(first + "ay");
    }

    return orginal. toString();

 }
}
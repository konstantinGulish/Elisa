class RedText {

    // Constants
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    // Constructors
    public RedText () {}
    public RedText (String text) {
        this.makeRed (text);
    }

    // Instance methods
    public String makeRed (String text) {
        return ANSI_RED + text + ANSI_RESET;
    }


}

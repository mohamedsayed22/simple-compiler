package compiler;

/**
 *
 * @author Mdhem
 */
public class Scanner {
    /**
     * A string attribute that contains the input line
     */
    private String line;
    
    /**
     * An array of strings that contains lexemes.
     * For example:
     * if the input is "mul 3 sub 2 sum 1 3 4" 
     * the resultant lexemes array will be:
     * 
     * ---------------------------------------
     * | mul | 3 | sub | 2 | sum | 1 | 3 | 4 |
     * ---------------------------------------
     */
    private String[] lexemes;
    
    
    /**
     * A constructor with a single String param.
     * @param line 
     */
    public Scanner(String line) {
        
        // Build the language
        this.language();
        
        // Extract lexemes.
        this.lexemes(line);
    }
    
    /**
     * Builds our language.
     * //TODO Complete this method implementation
     */
    private void language(){
        
        /**
         * ------------------------------------------
         * Required Task
         * ------------------------------------------
         * 
         * Write down the regex that match the following strings 
         * as mentioned in our Class and as declared in each variable name.
         */
        
        String number = "\\d+";
        String mul = "\\bmul\\b";
        
        /**
         * Complete the Following.
         */
        String sub = "\\sub\\";
        String sum = "\\sum\\";
        /**
         * The legal identifier:
         * ----------------------
         * 1- Begins with a letter or an underscore.
         * 2- The Subsequent characters may be letters or digits or underscores
         * 
         * @link https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html
         */
        String id = "([a-zA-Z]|_)([a-zA-Z]+|[0-9]+|_+)";
        
    }
    
    /**
     * Converts the input string to an array of strings. 
     * Check the comment on line 18
     * 
     * @param String line
     * 
     */
    private void lexemes(String line){
        
        /**
         * 1- Uncomment the following statement.
         * 
         * 2- Complete the following statement to perform what is required to
         * split the String line into an array of strings.
         */
        
        this.lexemes = line.split(" ");
        
    }
    
    
    
}

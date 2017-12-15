package compiler;

public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * The input line
         */
        String line = "mul 3 sub 2 sum 1 3";
        
        /**
         * Creating a Scanner object
         */
        Scanner scanner = new Scanner( line );
        
        Parser parser = new Parser( scanner.getSymbolTable() );
        
    }
    
}

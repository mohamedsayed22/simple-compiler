package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scanner {
    
    /**
     * @var String line
     * Holds the input line
     */
    private String line;
    /**
     * @var List<HashMap>
     * holds the symbol table 
     */
    private List<HashMap> symbolTable = new ArrayList<>();
    /**
     * @var List<HashMap>
     * Holds the language
     */
    private List<HashMap> language = new ArrayList<>();
    
    
    /**
     * A constructor with a single String parameter
     * @param line holds the input line
     */
    public Scanner(String line) {
        
        // Set tha line attribute
        this.line = line;
        
        // Build the language
        this.language();
        
        // Extract lexemes and build symbole table with tokens
        this.tokens();
    }
    
    /**
     * Builds our language.
     * //TODO Complete this method implementation
     */
    private void language(){
        
        HashMap number  = new HashMap();
        HashMap mul     = new HashMap();
        HashMap div     = new HashMap();
        HashMap sum     = new HashMap();
        HashMap sub     = new HashMap();
        HashMap id      = new HashMap();
        
        // Build the regex of numbers
        number.put("type", "number");
        number.put("regex", "\\d+");
        this.language.add( number );
        
        // Build the regex of Multiplication operation
        mul.put("type", "operation");
        mul.put("regex", "\\bmul\\b");
        this.language.add( mul );
        
        // Build the regex of division
        div.put("type", "operation");
        div.put("regex", "\\bdiv\\b");
        this.language.add( div );
        
        // Build the regex of addition
        sum.put("type", "operation");
        sum.put("regex", "\\bsum\\b");
        this.language.add( sum );
        
        // Build the regex of subtraction
        sub.put("type", "operation");
        sub.put("regex", "\\bsub\\b");
        this.language.add( sub );
        
        // Build the regex of identifier
        id.put("type", "identifier");
        id.put("regex", "([a-zA-Z]|_)([a-zA-Z]+|[0-9]+|_+)");
        this.language.add( id );
        
        
    }
    
    /**
     * Extract lexemes and build symbol table with tokens
     * 
     * @param String line
     * 
     */
    private void tokens(){
        
        for(String lexeme : this.line.split(" ")){
            
            HashMap token = new HashMap();
            token.put("lexeme", lexeme);
            
            String lexemeType = this.getLexemeType( lexeme );
            
            token.put("type", lexemeType );
            
            if( "operation".equals(lexemeType) || "number".equals(lexemeType)){
                
                token.put( "value", lexeme );
                
            }else{
                
                token.put( "value", "" );
                
            }
            
            this.symbolTable.add( token );
           
        }
         
    }
    
    /**
     * Gets the lexeme type form the language map
     * @param String lexeme
     * @return String
     */
    private String getLexemeType(String lexeme){
        
        for(HashMap word : this.language){
            
            if( lexeme.matches( word.get("regex").toString() ) ){
                
               return word.get("type").toString();
               
            }
            
        }
    
        return "UNKNOWN";
        
    }
    
    /**
     * Gets the symbol table
     * @return List<HashMap> The symbol table accessor/ Getter
     */
    public List getSymbolTable(){
        
        return this.symbolTable;
        
    }
    
    
}

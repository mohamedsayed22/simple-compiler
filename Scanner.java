package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mdhem
 */
public class Scanner {

    private String line;
    private List<HashMap> symboleTable = new ArrayList<>();
    private List<HashMap> language = new ArrayList<>();
    
    
    /**
     * A constructor with a single String param.
     * @param line 
     */
    public Scanner(String line) {
        
        // Build the language
        this.language();
        
        // Extract lexemes and build tokens
        this.tokens(line);
    }
    
    /**
     * Builds our language.
     * //TODO Complete this method implementation
     */
    private void language(){
        
        HashMap digits  = new HashMap();
        HashMap mul     = new HashMap();
        HashMap div     = new HashMap();
        HashMap sum     = new HashMap();
        HashMap sub     = new HashMap();
        HashMap id      = new HashMap();
        
        // Build the regex of digits
        digits.put("type", "digit");
        digits.put("regex", "\\d+");
        this.language.add( digits );
        
        // Build the regex of Multiplication operation
        mul.put("type", "operation");
        mul.put("subType", "mul");
        mul.put("regex", "\\bmul\\b");
        this.language.add( mul );
        
        // Build the regex of division
        div.put("type", "operation");
        div.put("subType", "div");
        div.put("regex", "\\bdiv\\b");
        this.language.add( div );
        
        // Build the regex of addition
        sum.put("type", "operation");
        sum.put("subType", "sum");
        sum.put("regex", "\\bsum\\b");
        this.language.add( sum );
        
        // Build the regex of subtraction
        sub.put("type", "operation");
        sub.put("subType", "sub");
        sub.put("regex", "\\bsub\\b");
        this.language.add( sub );
        
        // Build the regex of identifier
        id.put("type", "identifier");
        id.put("regex", "([a-zA-Z]|_)([a-zA-Z]+|[0-9]+|_+)");
        this.language.add( id );
        
        
    }
    
    /**
     * Converts the input string to an array of strings. 
     * Check the comment on line 18
     * 
     * @param String line
     * 
     */
    private void tokens(String line){
        
        for(String lexeme : line.split(" ")){
            
            HashMap token = new HashMap();
            token.put("lexeme", lexeme);
            
            String lexemeType = this.getLexemeType( lexeme );
            
            token.put("type", lexemeType );
            
            if( lexemeType == "operation" || lexemeType == "digit"){
                
                token.put( "value", lexeme );
                
            }else{
                
                token.put( "value", "" );
                
            }
            
            this.symboleTable.add( token );
           
        }
        
        System.out.println( symboleTable );
         
    }
    
    /**
     * Gets the lexeme type form the language map
     * @param lexeme
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
    
    
}

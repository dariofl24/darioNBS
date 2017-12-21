
package evaluatorv2.pkg0;

import java.util.ArrayList;

/**
 *
 * @author Dario
 */
public class EvaluatorV20 {

    
    public static void main(String[] args) {
        
        EvaluatorV2 ev = new EvaluatorV2();
        
        boolean error;
        ArrayList<String> expression;
        
        error = ev.expressionToList("1.0+sin( tan ( sin( y@11 ) )+20.010+3.1) / [ log( 22xy-17xx ) ] ");
        
        expression = ev.getExpression();
        
        System.out.println("------------------------------");
        
        for(String s:expression){
            System.out.println(s);
        }//for
        
        System.out.println("------------------------------");
        
        if(error){
            System.out.println( ev.getError() );
        }else{
            System.out.println("Expression OK");
        }//if - else
        
        
        
        
    }//main 
    
    
}//class

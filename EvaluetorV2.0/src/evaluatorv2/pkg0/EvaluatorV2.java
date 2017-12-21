
package evaluatorv2.pkg0;

import java.util.ArrayList;


public class EvaluatorV2 {
    
    private final String OPERATION= "+-*/@";
    private final String NUMBER= "1234567890";
    private final String MINUS="-";
    private final String POINT=".";
    
    private final String SIN="sin",COS="cos",TAN="tan",CSC="csc",SEC="sec",COT="cot",LOG="log",EXP="exp";
    private final String OPEN= "({[";
    private final String CLOSE=")}]";
    private final String VARIABLE="xyz";
    
    private final String FUNCTION_START="sctle"; // start of "sin cos tan csc sec cot log exp"
    private final String FUNCTION_END="nsctgp";
    
    private final String START=NUMBER+FUNCTION_START+OPEN+VARIABLE+POINT+MINUS;
    private final String END=NUMBER+CLOSE+VARIABLE;
    
    //** AFT's
    
    private final String NUMBER_AFT= NUMBER+POINT+OPEN+OPERATION;
    private final String VARIABLE_AFT= OPERATION + OPEN +NUMBER + VARIABLE;
    private final String OPEN_AFT=OPEN+OPERATION+FUNCTION_END+CLOSE+NUMBER;
    private final String CLOSE_AFT= CLOSE+NUMBER+VARIABLE;
    private final String OPERATION_AFT=NUMBER+VARIABLE+CLOSE;
    
    
    //**
    
    private String errorM;
    private int errorIn;
    private boolean isError=false;
    
    private ArrayList<String> expression;
    private ArrayList<Integer> index;
    
    /**
     * Check and parse to list
     * @param exp
     * @return 
     */
    public boolean expressionToList(String exp){//private
        
        char[] expArr= exp.toCharArray();
        
        this.expression= new ArrayList<String>();
        this.index= new ArrayList<Integer>();
        
        ArrayList<String> expression= new ArrayList<String>();
        
        
        String cur;
        
        for(int i=0;i<expArr.length;i++){
            
            cur= expArr[i]+"";
            
            if(!cur.trim().isEmpty()){
                expression.add(cur);
                this.index.add(i);
            }//if
            
        }//for
        
        StringBuffer numBuff= new StringBuffer();
        int Points=0;
        String bef="",aft1="",aft2="",aft3="";
        ArrayList<String> opens= new ArrayList<String>();
        
        for(int i=0;i<expression.size();i++){
            
            cur= expression.get(i); System.out.println("\n\n\n"+"*** cur='"+cur+"' ; i="+i);
            
            aft1= ( (i+1) < expression.size() )?expression.get(i+1):""; System.out.println("aft1: "+aft1);
            aft2= ( (i+2) < expression.size() )?expression.get(i+2):""; System.out.println("aft2: "+aft2);
            aft3= ( (i+3) < expression.size() )?expression.get(i+3):""; System.out.println("aft3: "+aft3);
            
            // ***
            
            if(i==0){ //check start of expression
                
                if(!START.contains(cur)){
                    this.setError("Ilegal start of expression", index.get(i));
                    return false;
                }//if
                
                if(cur.equals("-")){ //checks if the expression starts with -
                    
                    if( !this.NUMBER.contains(aft1) && !this.VARIABLE.contains(aft1) 
                            && !this.OPEN.contains(aft1) && !this.FUNCTION_START.contains(aft1) ){        
                        this.setError("Ilegal start of expression", index.get(i));
                        return false;
                    }//if
                    
                    this.expression.add(cur);
                    bef=cur;
                    continue;
                }// if (-)
                
                if(FUNCTION_START.contains(cur)){
                    
                    if( !(cur+aft1+aft2).equals(this.SIN) 
                            && !(cur+aft1+aft2).equals(this.COS) 
                            && !(cur+aft1+aft2).equals(this.TAN)
                            && !(cur+aft1+aft2).equals(this.CSC) 
                            && !(cur+aft1+aft2).equals(this.SEC) 
                            && !(cur+aft1+aft2).equals(this.COT) 
                            &&!(cur+aft1+aft2).equals(this.LOG)
                            &&!(cur+aft1+aft2).equals(this.EXP)){
                        
                        this.setError("Ilegal start of expression", index.get(i));
                        return false;
                    }//if
                    
                    this.expression.add(cur+aft1+aft2);
                    i=i+2;
                    bef=aft2; System.out.println("function bef: "+bef);
                    continue;
                }//if (sctl)
                
                if(this.NUMBER.contains(cur)){
                    numBuff.append(cur);
                }else{
                    this.expression.add(cur);    
                }//if - else
                
                bef=cur;
                continue;
            }//if (start)
            
            if(i== (expression.size()-1)){
                
                if( !END.contains(cur) ){
                    this.setError("Ilegal end of expression",index.get(i));
                    return false;
                }//if
                
            }//if (last)
            
            //*******
            
            if(this.NUMBER.contains(cur)){ // NUMBER
                
                if(!this.NUMBER_AFT.contains( bef )){
                    this.setError("Ilegal number character", index.get(i));
                    return false;
                }//if
                
                numBuff.append(cur);
                bef=cur;
                continue;
            }else{
                
                
                if(numBuff.length()>0 && !this.POINT.contains(cur)){
                    System.out.println("NUMBER: "+numBuff.toString());
                    this.expression.add( numBuff.toString() );
                    numBuff= new StringBuffer();
                    Points=0;
                }//if
                
            }//if - else
            
            
            if( this.POINT.contains(cur) ){ // POINT
                
                System.out.println("@@ >>>>>>>>>>>>>>>>>>>>>>>>>>"+Points);
                
                if( !this.NUMBER.contains(bef) || !this.NUMBER.contains(aft1) || (Points>=1) ){
                    this.setError("Point out of context",index.get(i));
                    return false;
                }//if
                
                numBuff.append(cur);
                Points+=1;
                bef=cur;
                continue;
            }//if
            
            if(this.VARIABLE.contains(cur)){ //VARIABLE
                
                if(!this.VARIABLE_AFT.contains(cur)){
                    this.setError("Variable out of context",index.get(i));
                    return false;
                }//if
                
                this.expression.add(cur);
                bef=cur;
                continue;
            }//if
            
            
            if(this.OPEN.contains(cur)){ //OPEN
                
                if(!this.OPEN_AFT.contains(bef)){
                    this.setError("Open symbol out of context",index.get(i));
                    return false;
                }else{
                    opens.add(cur);
                }//if - else
                
                this.expression.add(cur);
                bef=cur;
                continue;
            }//if
            
            if(this.CLOSE.contains(cur)){ //CLOSE
                
                if(!this.CLOSE_AFT.contains(bef) || opens.isEmpty() ){
                    this.setError("Close symbol out of context",index.get(i));
                    return false;
                }//if
                
                if( this.CLOSE.indexOf(cur) != this.OPEN.indexOf( opens.get( opens.size()-1 ) ) ){
                    this.setError("Close symbol out of context '"+cur+"'",index.get(i));
                }//
                
                opens.remove(opens.size()-1);
                
                this.expression.add(cur);
                bef=cur;
                continue;
            }//if
            
            
            if(this.OPERATION.contains(cur)){ // OPERATION 
                
                if( !this.OPERATION_AFT.contains(bef) && (!(this.MINUS.contains(cur) && this.OPEN.contains(bef))) ){
                    this.setError("Operation symbol out of context",index.get(i));
                    return false;
                }//if
                
                this.expression.add(cur);
                bef=cur;
                continue;
            }//if
            
            
            if( this.FUNCTION_START.contains(cur) ){ // FUNCTION
                
                if( !(cur+aft1+aft2).equals(this.SIN) 
                            && !(cur+aft1+aft2).equals(this.COS) 
                            && !(cur+aft1+aft2).equals(this.TAN)
                            && !(cur+aft1+aft2).equals(this.CSC) 
                            && !(cur+aft1+aft2).equals(this.SEC) 
                            && !(cur+aft1+aft2).equals(this.COT) 
                            &&!(cur+aft1+aft2).equals(this.LOG)
                            &&!(cur+aft1+aft2).equals(this.EXP)){
                    this.setError("Ilegal Function expression", index.get(i));
                    return false;    
                }//if
                
                this.expression.add(cur+aft1+aft2);
                i=i+2;
                bef=aft2; System.out.println("function bef: "+bef);
                continue;
            }//if
                
            this.setError("Ilegal character in expression", index.get(i));
            return false;
        }//for
        
        if( !opens.isEmpty() ){
            this.setError("General braket error. Needs to close or open a braket set",0);
            return false;
        }//if
        
        System.out.print( "\n" );
        for(String s:this.expression)
        System.out.print( s );
        
        System.out.print( "\n" );
        
        return true;
    }//expressionToArray
    
    
    
    public ArrayList<String> getExpression(){
        return this.expression;
    }//getExpression
    
    
    private void setError(String msj,int index){
        isError = true;
        this.errorM= msj;
        this.errorIn=index;
        System.out.println("Error: "+msj+" @"+index);
    }//setError
    
    
    public String getError(){
       
        if(this.isError){
            return "Error: "+this.errorM+" @"+this.errorIn;
        }else{
            return "";
        }//if - else
        
    }//getError
    
}//class

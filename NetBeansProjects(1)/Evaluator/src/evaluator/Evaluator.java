

package evaluator;

/**
 *
 * @author Dario
 */
public class Evaluator {//  2x ; xy ; )( ;  sin()cos()

    private String operation= "+-*/@";
    private String number= "1234567890";
    private String point=".";
    private String times="*";
    private String funtion="sin cos tan csc sec cot log";
    private String open= "({[";
    private String close=")}]";
    private String variable="xyz";


    private String operationAFT= number+close+variable;
    private String numberAFT= operation+number+open+point;
    private String pointAFT=operation+number+open;
    private String funtionAFT=operation+open+close;
    private String openAFT= operation+"nsctg"+open+close;
    private String closeAFT=number+close+variable;
    private String variableAFT=operation+number+open+variable;

    private String START=number+"sctl"+open+variable+point;
    private String END=number+close+variable;

    int errorindex;
    String ecu; //private
    String emsj="";
    Lista_dob<String> parsed= new Lista_dob<String>();
    boolean errorp= false;
    boolean ok= true;
    boolean set= false;


    public double evaluate(double xx,double yy,double zz){
        double[] vals= {xx,yy,zz};
        Pila<String> pil= new Pila<String>();
        String sim;
        double a,b,result;
        emsj="";

        if(!set){ return 0;}

        parsed.primero();

        for(int i=1; i<= parsed.lenght;i++){

            ok= true;
            sim= parsed.elemento();

            if((number+".").contains(sim.charAt(0)+"")){
                pil.push(sim);
                parsed.avanza();
                continue;
            }//if

            if(variable.contains(sim)){
                pil.push(vals[ variable.indexOf(sim) ]+"");
                parsed.avanza();
                continue;
            }//if

            if(operation.contains(sim)){

                try{
                        a= Double.parseDouble( pil.pop() );
                        b= Double.parseDouble( pil.pop() );

                }catch( NullPointerException e ){
                    ok=false; emsj="evaluate: operation: parsedouble: null "+i+" "+sim;
                    return 0;
                }//try-catch

                switch(sim.charAt(0)){

                    case '+':
                        pil.push((a+b)+"");
                        break;
                    case '-':
                        pil.push( (b-a)+"" );
                        break;
                    case '*':
                        pil.push( (a*b)+"" );
                        break;
                    case '@':
                        pil.push( Math.pow(b, a)+"" );
                        break;
                    case '/':
                        if(a!=0) pil.push( (b/a)+"" );
                        else{ ok=false; emsj="evaluate: operation: /: div 0"; return 0; }//
                        break;
                }//switch

                parsed.avanza();
                continue;
            }//if

            if(funtion.contains(sim)){

                try{
                    if(variable.contains(pil.top())){
                        a= vals[variable.indexOf(pil.pop())];
                    }else{
                        a= Double.parseDouble( pil.pop() );
                    }//if-else

                }catch( NullPointerException e ){
                    ok= false; emsj="evaluate: operation: parsedouble: null(2)";
                    return 0;
                }catch(NumberFormatException e){
                    ok= false; emsj="evaluate: operation: parsedouble: number format(2)";
                    return 0;
                }//try-catch

                //funtion="sin cos tan csc sec cot log"

                
                if(sim.equals("sin"))
                    pil.push(Math.sin(a)+"");

                if(sim.equals("cos"))
                    pil.push(Math.cos(a)+"");

                if(sim.equals("tan"))
                    pil.push(Math.tan(a)+"");

                try{
                    if(sim.equals("csc"))
                        pil.push( (1/Math.sin(a))+"" );

                    if(sim.equals("sec"))
                        pil.push( (1/Math.cos(a))+"" );

                    if(sim.equals("cot"))
                        pil.push( (1/Math.tan(a))+"" );

                }catch(java.lang.ArithmeticException e){
                    ok=false; emsj="evaluate: operation: /: div 0"; return 0;
                }//try-catch

                if(sim.equals("log")){
                    if(a>0) pil.push(Math.log(a)+"");
                    if(a<=0){
                        ok= false;
                        return 0;
                    }//if

                }//if

                parsed.avanza();
                continue;
            }//if

            ok=false;
        }//for

        try{
            result= Double.parseDouble(pil.pop());
        }catch(NumberFormatException e){
            ok= false; emsj="Not defined result";
            return 0;
        }//try-catch

        return result;
    }//evaluate



    public boolean set(String exp){
        if(!check(exp))return false;
        if(!parse()) return false;
        set= true;
        return true;
    }//set

    public boolean parse(){//private

        Pila<String> pil= new Pila<String>();
        char c;
        String buf="";
        String op=""; errorindex=-1;

        for(int i=0;i<ecu.length();i++){

            c= ecu.charAt(i);
            if(c==' ') continue;

            if((number+".").contains(c+"")){
                buf= buf+c;
                continue;
            }//if

            if(buf.length()!=0){

                if(buf.length()>20){
                    parsed.insertarUltimo(buf.substring(0,21));
                }else{
                    parsed.insertarUltimo(buf);
                }//if

                buf="";
            }//if

            if(variable.contains(c+"")){
                parsed.insertarUltimo(c+"");
                continue;
            }//if

            if(open.contains(c+"")){
                pil.push(c+"");
                continue;
            }//if

            if(operation.contains(c+"")){
                pil.push(c+"");
                continue;
            }//if


            if(close.contains(c+"")){
                op= open.charAt( close.indexOf(c) )+"";

                while(!pil.top().equals(op) ){
                    parsed.insertarUltimo(pil.pop());
                }//while

                op=pil.pop();

                if(!pil.empty())
                if(funtion.contains(pil.top()))
                    parsed.insertarUltimo(pil.pop());

                continue;
            }//if


            if("sctl".contains(c+"")){
                pil.push(ecu.substring(i,i+3));
                i=i+2;
                continue;
            }//if

            emsj="Error at parse ecuation";
            
            return false;
        }//for

        if(buf.length()!=0) parsed.insertarUltimo(buf);

        if(!pil.empty()){
            while(!pil.empty())
                parsed.insertarUltimo(pil.pop());
        }//if

        return true;
    }//parse


    public boolean check(String exp){ //private

        Pila<String> pars= new Pila<String>();
        ecu="";
        String c;
        emsj="";
        int lp=-2;
        int par=0;

        for(int i=0;i<exp.length();i++){
            errorindex= i;

            c= exp.charAt(i)+"";

            if(c.equals(" ")) continue;

            lp=lp+1;

            if(i==0){
                if(START.contains(c)){

                    if("sctl".contains(c)){

                        try{
                            c=exp.substring(i,i+3);
                        }catch(IndexOutOfBoundsException e){
                            emsj="Ilegal funtion declararion: "+c; return false;
                        }//try-catch

                        if(!funtion.contains(c)){emsj="Ilegal funtion declararion: "+c; return false;}
                        i=2;lp=1;
                    }//if

                    if(open.contains(c)) pars.push(c);

                    ecu=c;
                    continue;
                }//if

                emsj="Ilegal start of expression: "+c;
                return false;
            }//if

            if(i==(exp.length()-1)){
                if(!END.contains(c)){
                    emsj="Ilegal end of expession: "+c;
                    return false;
                }//if
                
            }//if

            if(operation.contains(c)){
                if(operationAFT.contains(ecu.charAt(lp)+"")   ){ecu= ecu+c; continue;}
                emsj="Ilegal character: "+c;
                return false;
            }//if

            if(number.contains(c)){
                if(numberAFT.contains(ecu.charAt(lp)+"")){ecu= ecu+c; continue;}
                emsj="Ilegal character: "+c;
                return false;
            }//if

            if(point.contains(c)){
                if(pointAFT.contains(ecu.charAt(lp)+"")){ecu= ecu+c; continue;}
                emsj="Ilegal character: "+c;
                return false;
            }//if

            if("sctl".contains(c)){

                try{
                    c=exp.substring(i,i+3);
                }catch(IndexOutOfBoundsException e){
                    emsj="Ilegal funtion declararion: "+c; return false;
                }//try-catch


                if(funtion.contains(c)&&funtionAFT.contains(ecu.charAt(lp)+"")){

                    if(close.contains(ecu.charAt(lp)+"")){ ecu=ecu+"*"; lp+=1; }

                    ecu= ecu+c;
                    i=i+2;lp=lp+2;
                    continue;
                }//if

                emsj="Ilegal funtion declararion: "+c;
                return false;
            }//if


            if(open.contains(c)){
                par=i;
                pars.push(c);
                if(openAFT.contains(ecu.charAt(lp)+"")){

                    if(close.contains(ecu.charAt(lp)+"")){ecu= ecu+"*"; lp+=1;}

                    ecu= ecu+c;
                    continue;
                }//if

                emsj="Ilegal character: "+c;
                return false;
            }//if

            if(close.contains(c)){
                if(pars.empty()){emsj="Not opened: "+c;  return false;}
                if( close.indexOf(c)!= open.indexOf(pars.pop()) ){emsj="Not closed correctli: "+c;  return false;}

                if(closeAFT.contains(ecu.charAt(lp)+"")){ ecu= ecu+c; continue;}//if

                emsj="Ilegal character: "+c;
                return false;
            }//if

            if(variable.contains(c)){

                if(variableAFT.contains( ecu.charAt(lp)+"" )){

                    if(variable.contains( ecu.charAt(lp)+"" )||number.contains(ecu.charAt(lp)+"") ){
                        ecu= ecu+"*";
                        lp+=1;
                    }//if
                    ecu= ecu+c;
                    continue;
                }//if

                emsj="Ilegal character: "+c;
                return false;
            }//if

            emsj="ABSOLUTE ILEGAL CHARACTER FOR EXPESSIONS: "+c;
            return false;//***
        }//for

        if(!pars.empty()){emsj="Not closed"; errorindex=par; return false;}

        return true;
    }//check





}//class

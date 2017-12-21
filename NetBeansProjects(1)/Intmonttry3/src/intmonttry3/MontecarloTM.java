

package intmonttry3;

/**
 *
 * @author DarioF
 */
public class MontecarloTM {
    
    Iboxt box;
    double pi2=(6.28318530717),pi=3.1415926535;
    
    public void launch(double rma, double rmb,double ts, double lim,int infint,double u){
        box = new Iboxt(infint);
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        double as; //area de cada Th
        double ra, rb; //radios de cada Th
        
        as= ( (32.0/945.0)*(pi*pi*pi*pi)*(Math.pow(rmb,9)-Math.pow(rma,9)) )/ts;
        ra=rma;
        
        for(double i=1; i<=ts;++i){
            
            rb= Math.pow( ((945.0/(32.0*pi*pi*pi*pi))*as)+Math.pow(ra,9) ,1/9.0);
            
            if(rb>rmb){ rb=rmb; }
            lm.insertarUltimo(new MontecarloP(new FunctionR9(u),ra,rb,lim,box,ts,i));
            //new MontecarloP(new FunctionR2(),ra,rb,lim,box,ts).run();
            
            ra=rb;
        }//for
        
        lm.primero();
        
        for(int i=1; i<=ts;++i){
            lm.elementoav().run();
        }//for
        
        
    }//launch
    
    
    public void launchThs(double rma,double lim,double asm,double tot,int maxth,int infint,double u){
       
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        MontecarloP maux;
        double as; //area de cada Th
        double ra, rb; //radios de cada Th
        
        if(maxth>tot){System.out.println("Error: maxth > tot *****");
            return;
        }//if
        
        box = new Iboxt(infint);
        as= ( (32.0/945.0)*pi*pi*pi*pi )/(asm);
        
        ra=rma;
        
        for(double i=1; i<=tot;++i){
            rb= Math.pow( ((945.0/(32.0*pi*pi*pi*pi))*as)+Math.pow(ra,9) ,1/9.0);
            lm.insertarUltimo(new MontecarloP(new FunctionR9(u),ra,rb,lim,box,tot,lm,i));
            //System.out.println("rl:"+i);
            ra=rb; 
        }//for
        
        lm.primero();
        System.out.println("to run:");
        for(int i=1;i<=maxth;++i){
            maux=lm.elementoav();
            
            if(maux!=null) maux.start();
            
            System.out.println("L:"+i);
        }//for
        System.out.println("Main ths L");
    }//launchThs
    
    
    
    
}//class

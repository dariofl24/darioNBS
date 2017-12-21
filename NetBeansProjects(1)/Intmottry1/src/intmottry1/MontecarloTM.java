

package intmottry1;

/**
 *
 * @author DarioF
 */
public class MontecarloTM {
    
    Iboxt box;
    double pi2=(6.28318530717),pi=3.1415926535;
    
    public void launch(double rma, double rmb, int ts, int lim){
        box = new Iboxt();
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        double as; //area de cada Th
        double ra, rb; //radios de cada Th
        
        as= (pi*((rmb*rmb)-(rma*rma)))/ts;
        ra=rma;
        
        for(int i=1; i<=ts;++i){
            
            rb= Math.sqrt( ((1/pi)*as) +(ra*ra) );
            if(rb>rmb){ rb=rmb; }
            lm.insertarUltimo(new MontecarloP(new FunctionR2(),ra,rb,lim,box,ts));
            //new MontecarloP(new FunctionR2(),ra,rb,lim,box,ts).run();
            
            ra=rb;
        }//for
        
        lm.primero();
        
        for(int i=1; i<=ts;++i){
            lm.elementoav().run();
        }//for
        
        
    }//launch
    
    
    public void launchThs(double rma,int lim,int asm,int tot,int maxth){
       
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        MontecarloP maux;
        double as; //area de cada Th
        double ra, rb; //radios de cada Th
        
        if(maxth>tot){System.out.println("Return");
            return;
        }//if
        
        box = new Iboxt();
        as= pi/asm;
        
        ra=rma;
        System.out.println("1");
        for(int i=1; i<=tot;++i){
            rb= Math.sqrt( ((1/pi)*as) +(ra*ra) );
            lm.insertarUltimo(new MontecarloP(new FunctionR2(),ra,rb,lim,box,tot,lm));
            //System.out.println("rl:"+i);
            ra=rb; 
        }//for
        
        lm.primero();
        System.out.println("to run:");
        for(int i=1;i<=maxth;++i){
            maux=lm.elementoav();
            
            if(maux!=null) maux.run();
            
            System.out.println("rr:"+i);
        }//for
        System.out.println("Launched");
    }//launchThs
    
    
    
}//class

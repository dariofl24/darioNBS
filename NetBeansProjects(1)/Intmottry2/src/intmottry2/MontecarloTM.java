

package intmottry2;

/**
 *
 * @author DarioF
 */
public class MontecarloTM {
    
    Iboxt box;
    double pi2=(6.28318530717),pi=3.1415926535;
    
    public void launch(double rma, double rmb, int ts, double lim){
        box = new Iboxt();
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        double as; //area de cada Th
        double ra1,ra2,ra3; //radios de cada Th
        double rb1,rb2,rb3;
        double[] ra= new double[3];
        double[] rb= new double[3];
        
        as= ((4.0/3.0)*pi*((rmb*rmb*rmb)-(rma*rma*rma)))/ts;
        ra1=rma;
        
        for(int i=1; i<=ts;++i){
            
            rb1= Math.pow( ((3.0*as)/(4.0*pi))+(ra1*ra1*ra1) ,1/3.0);
            if(rb1>rmb){ rb1=rmb; }//if
            
            
            ra2=rma;
            for(int j=1;j<=ts;++j){
                rb2= Math.pow( ((3.0*as)/(4.0*pi))+(ra2*ra2*ra2) ,1/3.0);
                if(rb2>rmb){ rb2=rmb; }//if
                
                ra3=rma;
                for(int k=1;k<=ts;++k){
                    rb3= Math.pow( ((3.0*as)/(4.0*pi))+(ra3*ra3*ra3) ,1/3.0);
                    if(rb3>rmb){ rb2=rmb; }//if
                    ra[0]=ra1; ra[1]=ra2; ra[2]=ra3;
                    rb[0]=rb1; rb[1]=rb2; rb[2]=rb3;
                    
                    lm.insertarUltimo(new MontecarloP(new FunctionR9(),ra,rb,lim,box,(ts*ts*ts)));
                    
                    ra3=rb3;
                }//for
                
                ra2=rb2;
            }//for
            
            //lm.insertarUltimo(new MontecarloP(new FunctionR9(),ra1,rb1,lim,box,ts));
            ra1=rb1;
        }//for
        
        lm.primero();
        
        for(int i=1; i<=(ts*ts*ts);++i){
            lm.elementoav().run();
        }//for
        
        
    }//launch
    
    
    public void launchThs(double rma,double lim,int asm,int tot,int maxth){
       /**
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        MontecarloP maux;
        double as; //area de cada Th
        double ra, rb; //radios de cada Th
        
        if(maxth>tot){System.out.println("Return");
            return;
        }//if
        
        box = new Iboxt();
        as= ((4.0/3.0)*pi)/asm;
        
        ra=rma;
        System.out.println("1");
        for(int i=1; i<=tot;++i){
            rb= Math.pow( ((3.0*as)/(4.0*pi))+(ra*ra*ra) ,1/3.0);
            lm.insertarUltimo(new MontecarloP(new FunctionR9(),ra,rb,lim,box,tot,lm));
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
        */
    }//launchThs
    
    
    
}//class

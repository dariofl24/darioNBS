

package intmonttry321a;

/**
 *
 * @author DarioF
 */
public class MontecarloTM {
    
    Iboxt box;
    double pi2=(6.28318530717),pi=3.1415926535;
    
    public void launch(double rma, double rmb,double asm, double lim,int infint,double u,double maxth,String fn){
        box = new Iboxt(infint,fn);
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        double as; //area de cada Th
        double ra=0, rb=0; //radios de cada Th
        double tt;
        
        if(rmb<=rma){ System.out.println("rmb<rma"); return; }//if
        
        as= ( (32.0/945.0)*pi*pi*pi*pi )/(asm);
        tt= ( (32.0/945.0)*(pi*pi*pi*pi)*(Math.pow(rmb,9)-Math.pow(rma,9)) )/as;
        
        if(tt<1.0){ System.out.println("tt<1"); return; }//if
        
        tt= (double) Math.round(tt); System.out.println("\n***Total de capas:"+tt);
        ra=rma;
        
        for(int i=1;i<=tt;++i){
            rb= Math.pow( ((945.0/(32.0*pi*pi*pi*pi))*as)+Math.pow(ra,9) ,1/9.0);
            lm.insertarUltimo(new MontecarloP(new FunctionR9(u),ra,rb,lim,box,tt,lm,i));
            ra=rb;
        }//for
        
        System.out.println("\n"+"Launch inf \n"+"Rmin= "+rma+"\n"+"Rmax= "+rb+"\n"+"asm="+asm+"\n"+"tot="+tt+"\n");
        
        lm.primero();
        
        for(int i=1; i<=maxth;++i){
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
            rb= Math.pow( ((945.0/(32.0*pi*pi*pi*pi))*as)+Math.pow(ra,9) ,1.0/9.0);
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

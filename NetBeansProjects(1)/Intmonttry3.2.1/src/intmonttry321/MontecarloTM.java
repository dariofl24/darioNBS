

package intmonttry321;

/**
 *
 * @author DarioF
 */
public class MontecarloTM {
    
    Iboxt box;
    double pi2=(6.28318530717),pi=3.1415926535;
    
    
    
    
    public void launchThs(double rma,double lim,double asm,double tot,int maxth,int infint,double u){
       
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        MontecarloP maux;
        double as; //area de cada Th
        double ra, rb; //radios de cada Th
        
        if(maxth>tot){System.out.println("Error: maxth > tot *****");
            return;
        }//if
        
        box = new Iboxt(infint);
        //box = new Iboxt(infint,file);
        as= ( (32.0/945.0)*pi*pi*pi*pi )/(asm);
        
        ra=rma;
        
            
        for(double i=1; i<=tot;++i){
            rb= Math.pow( ((945.0/(32.0*pi*pi*pi*pi))*as)+Math.pow(ra,9.0) ,1.0/9.0);
            lm.insertarUltimo(new MontecarloP(new FunctionR9(u),ra,rb,lim,box,tot,lm,asm,i));
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
    
    public void launchThsPl(double rma,Lista_dob<Double> liml,Lista_dob<Double> asml,Lista_dob<Double> IDbl,double tot,int maxth,int infint,double u,String file){
        
        
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        MontecarloP maux;
        double as; //area de cada Th
        double ra, rb; //radios de cada Th
        
        if(maxth>tot){System.out.println("Error: maxth > tot *****");
            return;
        }//if
        IDbl.primero();
        asml.primero();
        liml.primero();
        
        box = new Iboxt(infint,file);        
        ra=rma;
        
        for(double k=1;k<IDbl.lenght;++k){
        
        as= ( (32.0/945.0)*pi*pi*pi*pi )/(asml.elemento());
            
        for(double i=IDbl.elemento()+1; i<=IDbl.elementosig();++i){
            rb= Math.pow( ((945.0/(32.0*pi*pi*pi*pi))*as)+Math.pow(ra,9) ,1.0/9.0);
            lm.insertarUltimo(new MontecarloP(new FunctionR9(u),ra,rb,liml.elemento(),box,tot,lm,asml.elemento(),i));
            //System.out.println("rl:"+i);
            ra=rb; 
        }//for
            System.out.println("IDab:"+(IDbl.elemento()+1)+" ; "+IDbl.elementosig());
            System.out.println("asm:"+asml.elemento());
            System.out.println("lim:"+liml.elemento());
            System.out.println("-----------------------------------------------------");
        IDbl.avanza();
        asml.avanza();
        liml.avanza();
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

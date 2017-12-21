

package intmonttry3d2_2;

/**
 *
 * @author DarioF
 */
public class MontecarloTM {
    
    Iboxt box;
    double pi2=(6.28318530717),pi=3.1415926535;
    
    public void launch(double rma1,double rma2, double rmb1,double rmb2,double asm1,double asm2, double lim1,double lim2,int str,double u,double maxth,String fn){
        box = new Iboxt(1,fn);
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        double as1,as2; //area de cada Th
        double ra=0, rb=0; //radios de cada Th
        double tt1,tt2;
        MontecarloP maux;
        
        if(rmb1<=rma1){ System.err.println("rmb1<rma1"); return; }//if
        if(rmb2<=rma2){ System.err.println("rmb2<rma2"); return; }//if
        
        as1= ( (4.0/3.0)*pi )/(asm1);
        tt1= ( (4.0/3.0)*pi*(Math.pow(rmb1,3)-Math.pow(rma1,3)) )/as1;
        tt1= (double) Math.floor(tt1);
        
        as2= ( (4.0/3.0)*pi )/(asm2);
        tt2= ( (4.0/3.0)*pi*(Math.pow(rmb2,3)-Math.pow(rma2,3)) )/as2;
        tt2= (double) Math.floor(tt2);
        
        if(tt1<1.0){ System.err.println("tt1<1"); return; }//if
        if(tt2<1.0){ System.err.println("tt2<1"); return; }//if
        
        ra=rma1;
        
        for(int i=1;i<=tt1;++i){
            rb= Math.pow( ((3.0/(4.0*pi))*as1)+Math.pow(ra,3) ,1.0/3.0);
            
            if(i==str){
                lm.insertarUltimo(new MontecarloP(new FunctionR(u,rma2,asm2,lim2,tt2),ra,rb,lim1,box,tt1,lm,i,tt1*as1));
                str=(int)(str + maxth);
            }//if
            
            ra=rb;
        }//for
        
        lm.primero();
        box.settime();
        
        maux= lm.elementoav(); 
        if(maux!=null) maux.start();
        
        
         
    }//launch
    
    
}//class

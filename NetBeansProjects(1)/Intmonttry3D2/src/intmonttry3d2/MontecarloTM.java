

package intmonttry3d2;

/**
 *
 * @author DarioF
 */
public class MontecarloTM {
    
    Iboxt box;
    double pi2=(6.28318530717),pi=3.1415926535;
    
    public void launch(double rma1,double rma2, double rmb1,double rmb2,double asm1,double asm2, double lim1,double lim2,int infint,double u,double maxth,String fn){
        box = new Iboxt(infint,fn);
        Lista_dob<MontecarloP> lm= new Lista_dob<MontecarloP>();
        double as1,as2; //area de cada Th
        double ra=0, rb=0; //radios de cada Th
        double tt1,tt2;
        MontecarloP maux;
        
        if(rmb1<=rma1){ System.out.println("rmb1<rma1"); return; }//if
        if(rmb2<=rma2){ System.out.println("rmb2<rma2"); return; }//if
        
        as1= ( (4.0/3.0)*pi )/(asm1);
        tt1= ( (4.0/3.0)*pi*(Math.pow(rmb1,3)-Math.pow(rma1,3)) )/as1;
        tt1= (double) Math.round(tt1);
        
        as2= ( (4.0/3.0)*pi )/(asm2);
        tt2= ( (4.0/3.0)*pi*(Math.pow(rmb2,3)-Math.pow(rma2,3)) )/as2;
        tt2= (double) Math.round(tt2);
        
        if(tt1<1.0){ System.out.println("tt1<1"); return; }//if
        if(tt2<1.0){ System.out.println("tt2<1"); return; }//if
        
        System.out.println("\n***Total de capas Principales:"+tt1);
        ra=rma1;
        
        for(int i=1;i<=tt1;++i){
            rb= Math.pow( ((3.0/(4.0*pi))*as1)+Math.pow(ra,3) ,1.0/3.0);
            //FunctionR(double v,double ra,double subm,double Lim,double TT)
            lm.insertarUltimo(new MontecarloP(new FunctionR(u,rma2,asm2,lim2,tt2),ra,rb,lim1,box,tt1,lm,i));
            ra=rb;
        }//for
        
        System.out.println("\n"+"Launch inf \n"+"Rmin1= "+rma1+"\n"+"Rmax1= "+rb+"\n"+"asm="+asm1+"\n"+"tot="+tt1+"\n");
        System.out.println("\n"+"Rmin= "+rma1+"\n"+"\n"+"asm2="+asm2+"\n"+"tot2="+tt2+"\n");
        lm.primero();
        
        for(int i=1; i<=maxth;++i){
            maux= lm.elementoav();
            if(maux!=null) maux.start();
        }//for
         
    }//launch
    
    
}//class

/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 21 de junio de 2011, 03:07 PM
 */

#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>

#define pi 3.1415926535
#define pi2 6.28318530717
using namespace std;

double x=0,y=0;
int RP;
time_t tta,tca,tcb;
double seg=0,mn=0,hor=0,dia=0;

double Random(){
    double r;
    
    r=rand()/((double)RAND_MAX);
    
    return r;
}//Random

double RandomN(int l){
    
    double num=0,div=1,r;
    
    for(int i=1;i<=l;i++){
        div= div/10.0;
        r=(double)(rand()%10);
        num=num+( div*r );
        //cout<<r;
    }//for
    //cout<<""<<endl;
    
    return num;
}//RandomN_s

double randomR(double r,double ra,double rb){
    double x,y;
    
    x= ra*ra*ra; //cout<<"sx:"<<x<<endl;
    y= (pow(rb,3)-pow(ra,3))/(rb-ra); //cout<<"sy:"<<y<<endl;
    
    return pow(x + (y*(r-ra)), 1.0/3.0);
}//randomR

string getDate(){
    time_t rawtime;
    struct tm * timeinfo;
    
    time ( &rawtime );
    timeinfo = localtime ( &rawtime );
    
    return asctime (timeinfo);
}//getDate

void get_time(double time){
    
    time= floor(time);
    
    seg= fmod(time,60.0);
    
    mn= fmod(floor((time/60)),60.0);
    hor= floor((time/3600));
    dia= floor(hor/24);
    hor= fmod(hor,24.0);
    
}//get_time

void storeF(int ID,double ival,double lim,double ra,double rb){
    ofstream wff;
    wff.setf(ios::fixed,ios::floatfield);
    wff.precision(18);
    
    wff.open("IntVal.dat",ios::app);
    
    if(wff.is_open()){
        
        wff<<ID<<endl;
        wff<<ival<<endl;
        wff<<getDate()<<" @ ";
        
        get_time( difftime(tcb,tta) );
        if(dia!=0) wff<<((int)dia)<<" dia, ";
        if(hor!=0) wff<<((int)hor)<<" hor, ";
        if(mn!=0) wff<<((int)mn)<<" min, ";
        if(seg!=0) wff<<((int)seg)<<" seg ";
        wff<<" ;";
        wff<<"Tiempo capa: ";
        get_time( difftime(tcb,tca) );
        if(dia!=0) wff<< ((int)dia) <<" dia, ";
        if(hor!=0) wff<< ((int)hor) <<" hor, ";
        if(mn!=0) wff<<((int)mn)<<" min, ";
        if(seg!=0) wff<<((int)seg)<<" seg "; 
        wff<<" ;;";
        
        wff<<"Capa ID: "<<ID<<";";
        wff<<"N pns: "<<((int)lim)<<";";
        wff<<"Rmin= "<<ra<<" ;";
        wff<<"Rmax= "<<rb<<" ;";
        wff<<"*Integral(capa)= "<<ival<<" ;"<<endl;
        
        
    }else{
        cout<<"error: ff"<<endl;
        sleep(1);
        storeF(ID,ival,lim,ra,rb);
    }//if-else
    
    
    wff.close();
    
}//storef

double Kf(double x){
    double r,xp;
    xp=x*x;
    
    if( fabs(x)<=0.5 ){
        
        r= 1.0+((xp)/6.0);
            xp= xp*x*x;//4
            r= r+(xp/120.0);
            xp= xp*x*x;//6
            r= r+(xp/5040.0);
            xp= xp*x*x;//8
            r= r+(xp/362880.0);
            xp= xp*x*x;//10
            r= r+(xp/39916800.0);
            xp= xp*x*x;//12
            r= r+(xp/6227020800.0);
            
            xp= xp*x*x;//14
            r= r+(xp/1307674368000.0);
            
            //xp= xp*x*x;
            //16
            //r= r+(xp/355687428096000.0);
            
            //xp= xp*x*x;
            //18
            //r= r+(xp/121645100408832000.0);
            
            //xp= xp*x*x;
            //20
            //r= r+(xp/51090942171709440000.0);
            
            return (2.0)*r;
    }else{
        
        return (2.0)*( sinh(x)/x );
        
    }//if-else
    
}//kf

//**
//**

double funB(double R,double T,double P,double q21,double q22,double q23,double u){
    double r,q11=0,q12=0,q13=0;
    
    q11= R*(sin(P))*(cos(T));
    q12= R*(sin(P))*(sin(T));
    q13= R*cos(P);
    
    r=0;
    //Exp[-0.25*(1 + (2*u - 1)^2)*((q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2)]
        r= exp( -0.25*(1+((2*u-1)*(2*u-1)))*(((q11 + q21)*(q11 + q21)) + ((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23)) ) );   
        
        //Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 – u*q23)^2]
        r=r*sqrt( pow((1 - u)*q11 - u*q21,2)+ pow((1 - u)*q12 - u*q22,2)+pow((1 - u)*q13 - u*q23,2)  );
        
        //Exp[-(((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 - u*q23)^2)]
        r=r*exp( -( pow((1 - u)*q11 - u*q21,2) + pow((1 - u)*q12 - u*q22,2) + pow((1 - u)*q13 - u*q23,2) ) );
        
        //k[(2 u – 1)* Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 -u*q23)^2]*Sqrt[(q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2]]
        r=r* Kf( (2*u - 1)*sqrt( pow((1 - u)*q11 - u*q21, 2)+ pow((1 - u)*q12 - u*q22, 2)+ pow((1 - u)*q13 -u*q23,2))* sqrt( ((q11 + q21)*(q11 + q21))+((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23))) );
        
        //Exp[-0.5*(q11^2 + q12^2 + q13^2)]
        r=r*exp( -0.5*( (q11*q11) + (q12*q12) + (q13*q13) ) );
        
        return r; 
}//funB

double funC(double R,double T,double P,double q21,double q22,double q23,double u){
    double x1,x2,x3;
    double r,q11=0,q12=0,q13=0;
    //
    
    q11= R*(sin(P))*(cos(T));
    q12= R*(sin(P))*(sin(T));
    q13= R*cos(P);
    
    x1=-0.25*(1+((2*u-1)*(2*u-1)))*(((q11 + q21)*(q11 + q21)) + ((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23)) );
    x2=-( pow((1 - u)*q11 - u*q21,2) + pow((1 - u)*q12 - u*q22,2) + pow((1 - u)*q13 - u*q23,2) ) ;
    x3=-0.5*( (q11*q11) + (q12*q12) + (q13*q13) );
    
    r=0;
    //Exp[-0.25*(1 + (2*u - 1)^2)*((q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2)]
        r= exp( x1+x2+x3 );   
        
        //Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 – u*q23)^2]
        r=r*sqrt( pow((1 - u)*q11 - u*q21,2)+ pow((1 - u)*q12 - u*q22,2)+pow((1 - u)*q13 - u*q23,2)  );
        
        //Exp[-(((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 - u*q23)^2)]
        
        //k[(2 u – 1)* Sqrt[((1 - u)*q11 - u*q21)^2 + ((1 - u)*q12 - u*q22)^2 + ((1 - u)*q13 -u*q23)^2]*Sqrt[(q11 + q21)^2 + (q12 + q22)^2 + (q13 + q23)^2]]
        r=r* Kf( (2*u - 1)*sqrt( pow((1 - u)*q11 - u*q21, 2)+ pow((1 - u)*q12 - u*q22, 2)+ pow((1 - u)*q13 -u*q23,2))* sqrt( ((q11 + q21)*(q11 + q21))+((q12 + q22)*(q12 + q22))+((q13 + q23)*(q13 + q23))) );
        
        //Exp[-0.5*(q11^2 + q12^2 + q13^2)]
        
        return r;
}//funC

double integrateB(double ra,double rb,double lim2,double x1,double x2,double x3,double as2,double u){
    double r=0,t=0,p=0;
    double sum,fv=0,prom=0,ival=0;
    
    sum=0;
    
    for(int i=1;i<=lim2;++i){
        r= randomR( ((rb-ra)*Random())+ra  ,ra,rb);
        t= pi2*Random();
        p= pi*Random();
        
        fv= funC(r,t,p,x1,x2,x3,u); 
        
        sum= sum+fv;
    }//for
    
    prom= sum/lim2;
    ival= prom*as2;
    
    return ival;
}//integrateB

double funA(double r,double t,double p,double u,double rma2,double as2,double lim2,double tt2){
    double x1,x2,x3,tib;
    double ra=0,rb=0;
    
    
    x1= r*(sin(p))*(cos(t));
    x2= r*(sin(p))*(sin(t));
    x3= r*cos(p);
    
    tib=0;
    ra=rma2;
    
    for(int j=1;j<=tt2;++j){
        rb= pow( ((3.0/(4.0*pi))*as2)+pow(ra,3) ,1.0/3.0);
        tib= tib+ integrateB(ra,rb,lim2,x1,x2,x3,as2,u);
        ra=rb; //cout<<"k: "<<j<<endl;
    }//for
    
    return pow(tib,2);
    //return 1;
}//valuate


void integrateA(double ra,double rb,double as1,double lim1,double u,int ID,double rma2,double as2,double lim2,double tt2){
    double r=0,t=0,p=0;
    double sum,fv=0,prom=0,ival=0;
    
    sum=0;
    
    time(&tca);
    
    for(int i=1;i<=lim1;++i){
        
        r= randomR( ((rb-ra)*Random())+ra  ,ra,rb);
        t= pi2*Random();
        p= pi*Random();
        
        fv= funA(r,t,p,u,rma2,as2,lim2,tt2);
        
        sum= sum+fv;
    }//for
    
    prom= sum/lim1;
    ival= prom*as1;
    //storef(int ID,double ival,double lim,double ra,double rb)
    
    time(&tcb);
    storeF(ID,ival,lim1,ra,rb);
    
    cout<<ival<<endl;
}//integrate


void launch(double rma1,double rmb1,double lim1,double asm1,double rma2,double rmb2,double lim2,double asm2,int str,double u,double maxth){
    double tt1,tt2,as1,as2,ra,rb;
    
    if( (rmb1<=rma1)||(rmb1<=rma1) ) cout<<"***error: rmb<=rma"<<endl;
    
    as1= ( (4.0/3.0)*pi )/(asm1);
    tt1= ( (4.0/3.0)*pi*(pow(rmb1,3)-pow(rma1,3)) )/as1; cout<<"tt1: "<<tt1<<endl;
    tt1= (double) floor(tt1); cout<<"tt1: "<<tt1<<endl;
    
    as2= ( (4.0/3.0)*pi )/(asm2);
    tt2= ( (4.0/3.0)*pi*(pow(rmb2,3)-pow(rma2,3)) )/as2; cout<<"tt2: "<<tt2<<endl;
    tt2= (double) floor(tt2); cout<<"tt2: "<<tt2<<endl;
    
    if(tt1<1.0) cout<<"***error: tt1<1"<<endl;
    if(tt2<1.0) cout<<"***error: tt2<1"<<endl;
    
    time(&tta);
    ra=rma1;
    
    for(int i=1;i<=tt1;++i){
        rb=pow( ((3.0/(4.0*pi))*as1)+pow(ra,3) ,1.0/3.0);
        
        if(i==str){ //cout<<"i:"<<i<<", ra:"<<ra<<" , "<<"rb:"<<rb<<endl;
            integrateA(ra,rb,as1,lim1,u,i,rma2,as2,lim2,tt2); 
            str=str+ (int) maxth; cout<<"cp: "<<i<<endl;
        }//if
        
        ra=rb;
    }//for
            
    
}//launch



//***********
int PID=0;
/*
 * 
 */
int main(int argc, char** argv) {
    
    double rma1=0,rmb1=0,asm1=0,lim1=0;
    int str=0;
    double u=0,maxth=0;
    double rma2=0,rmb2=0,asm2=0,lim2=0;
    string line;
    ifstream reader;
    string fn="com_dat";
    
    RP=12;
    cout<<"RP: "<<RP<<endl;
    
    //reader.setf(ios::fixed,ios::floatfield);
    //reader.precision(22);
    cout.setf(ios::fixed,ios::floatfield);
    cout.precision(22);
    
    if(argc>1){
        fn=fn+argv[1];
        fn=fn+".dat";
        reader.open(fn.c_str());
        cout<<"op:1"<<endl;
    }else{
        reader.open("com_dat1.dat");
        cout<<"op:2"<<endl;
    }//if-else
    
    
    if(reader.is_open()){ 
        
        getline(reader,line);
        rma1=atof(line.c_str()); cout<<"rma1: "<<rma1<<endl;
        
        getline(reader,line);
        rmb1=atof(line.c_str()); cout<<"rmb1: "<<rmb1<<endl;
        
        getline(reader,line);
        lim1=atof(line.c_str()); cout<<"lim1: "<<lim1<<endl;
        
        getline(reader,line);
        asm1=atof(line.c_str()); cout<<"asm1: "<<asm1<<endl;
        //
        getline(reader,line);
        rma2=atof(line.c_str()); cout<<"rma2: "<<rma2<<endl;
        
        getline(reader,line);
        rmb2=atof(line.c_str()); cout<<"rmb2: "<<rmb2<<endl;
        
        getline(reader,line);
        lim2=atof(line.c_str()); cout<<"lim2: "<<lim2<<endl;
        
        getline(reader,line);
        asm2=atof(line.c_str()); cout<<"asm2:"<<asm2<<endl;
        
        getline(reader,line);
        maxth=atof(line.c_str()); cout<<"maxth: "<<maxth<<endl;
        
        getline(reader,line);
        u=atof(line.c_str()); cout<<"u: "<<u<<endl;
        
        getline(reader,line);
        str=atoi(line.c_str()); cout<<"str: "<<str<<endl;
        PID=str;
        
        reader.close();
    }else{
        cout<<"***error: com_dat file Not opened (main)"<<endl;
    }//if-else
    
    
      
    srand(time(NULL)+PID);
    sleep(PID);
    launch(rma1,rmb1,lim1,asm1,rma2,rmb2,lim2,asm2,str,u,maxth);
    
    return 0;
}//




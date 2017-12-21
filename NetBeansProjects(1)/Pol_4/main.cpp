
#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>

using namespace std;

double func(double x){
    double res;
    double p1;
    
    p1=(27.0*x*x)+(58.0*x)+31;
    
    res=(pow(( (sqrt(27)*sqrt(p1))+(27*x)+ 29),1.0/3.0))/(3.0*pow(2.0,1.0/3.0));
    res= res + ( (pow(2.0,1.0/3.0))/(3.0*pow(( (sqrt(27)*sqrt(p1))+(27*x)+ 29),1.0/3.0) ) )+(1.0/3.0);
    
    return res;
}//func

int main(int argc, char** argv) {
    
    int its;
    double x0,x1,dif;
    
    do{
       cout<<"Valor inicial (>0)"<<endl;
       cin>>x0; 
    }while(x0<=0);
    
    
    cout<<"Numero de iteraciones:"<<endl;
    cin>>its;
    
    cout<<"\n"<<endl;
    
    for(int i=1;i<=its;++i){
        x1= func(x0);
        dif=x0-x1;
        cout<<x1<<" ; "<< dif <<endl;
        x0=x1;
    }//for
    
    cout<<"\n"<<endl;
    
    cout<<"Punto fijo: "<< x1 <<endl;
    cout<<"Diferencia: "<< dif<<endl;
    
    return 0;
    
    
    return 0;
}//main


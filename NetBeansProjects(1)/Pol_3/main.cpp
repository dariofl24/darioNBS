
#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>

using namespace std;

int main(int argc, char** argv) {
    
    double x0,x1,dif;
    int its;
    
    cout<<"Valor inicial (1<x<2^(1/3))"<<endl;
    cin>>x0;
    
    cout<<"Numero de iteraciones:"<<endl;
    cin>>its;
    
    cout<<"\n"<<endl;
    
    for(int i=1;i <= its;++i){
        
        x1= ((-4.0/27.0)*x0*x0*x0) + x0 + (8.0/27.0);
        dif=x1-x0;
        
        cout<<x1<<" ; "<<dif<<endl;
        x0=x1;
    }//for
    
    cout<<"\n"<<endl;
    
    cout<<"Punto fijo: "<< x1 <<endl;
    cout<<"Diferencia: "<< dif<<endl;
    
    return 0;
}//main


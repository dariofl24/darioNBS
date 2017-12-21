
#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>

using namespace std;


int main(int argc, char** argv) {
    
    double x0,a;
    int its;
    
    do{
        cout<<"a= (|a|>0)"<<endl;
        cin>>a;
    }while(a==0);
    
    
    
    if(a<0){
        cout<<"x0 0<(3/2a)<x0<(1/2a)"<<endl;
        
    }else{
        cout<<"x0 (1/2a)<x0<(3/2a)<0"<<endl;    
    }//if-else
    
    cin>>x0;
    
    cout<<"Numero de iteraciones:"<<endl;
    cin>>its;
    
    for(int i=1;i <= its;++i){
        
        x0=((2.0)*x0)-(a*x0*x0);
        cout<<x0<<endl;
    }//for
    
    
    cout<<"\n"<<"1/"<< (a) <<"= "<< x0 <<endl;
    
    return 0;
}//main


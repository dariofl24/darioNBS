

#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>

using namespace std;


int main(int argc, char** argv) {
    
    int its;
    double a,x0;
    
    cout<<"Base:"<<endl;
    cin>>a;
    
    cout<<"Numero de iteraciones:"<<endl;
    cin>>its;
    
    cout<<"\n";
    
    x0= (17.0/24.0)+(a/3.0);
    
    cout<<"x0="<<x0<<endl;
    
    for(int i=1;i<=its;++i){
        
        x0= (x0/2.0)+(a/(2.0*x0));
        cout<<i<<": "<<x0<<endl;
    }//for
    
    cout<<"\n"<<"Raiz:"<<endl;
    cout<<"R= "<<x0<<endl;
    

    return 0;
}//main


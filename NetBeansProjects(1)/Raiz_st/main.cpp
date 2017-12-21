
#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>

using namespace std;

double fact(int x){
    double y=1;
    
    for(int i=1;i<=x;++i){
        y=(y*i);
    }//for
    
    return y;
}//fact

double x0_calc(double a,int p,int k){
    double sum=0;
    
    for(int r=0;r<=k;++r){
        sum= sum +( pow(log(a),r)/( pow((double)p,(double)r)*fact(r) ) );
    }//for
    
    return sum;
}//x0_calc


int main(int argc, char** argv) {
    
    int p,k,its;
    double a,x0;
    
    cout<<"Base:"<<endl;
    cin>>a;
    
    cout<<"Raiz (entero):"<<endl;
    cin>>p;
    
    cout<<"Orden del valor inicial:"<<endl;
    cin>>k;
    
    cout<<"Numero de iteraciones:"<<endl;
    cin>>its;
    
    cout<<"\n";
    
    x0= x0_calc(a,p,k);
    
    cout<<"x0="<<x0<<endl;
    
    for(int i=1;i<=its;++i){
        
        x0= ( ((p-1)*x0)/((double)p) )+( a/( p*pow(x0,(p-1)) ) );
        cout<<i<<": "<<x0<<endl;
    }//for
    
    cout<<"\n"<<"Raiz:"<<endl;
    cout<<"R= "<<x0<<endl;
    
    
    return 0;
}//main


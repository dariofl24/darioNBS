
#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>

using namespace std;


int main(int argc, char** argv) {
    
    double x0,a,n;
    int its;
    
    cout<<"Raiz n-esima de a"<<"\n"<<endl;
    
    do{
        cout<<"a= (a>0)"<<endl;
        cin>>a;
    }while(a<0);
    
    do{
        cout<<"n= (n>1)"<<endl;
        cin>>n;
    }while(n<=1.0);
    
    cout<<"x0 "<<endl;
    cin>>x0;
    
    cout<<"Numero de iteraciones:"<<endl;
    cin>>its;
    cout<<"\n";
    
    for(int i=1;i <= its;++i){
        x0= ((1.0-(1.0/n))*x0)+(a/(n*pow(x0,(n-1.0)) ));
        cout<<x0<<endl;
    }//for
    
    cout<<"\n"<<"Raiz "<<n<<" de "<<a<<":"<<endl;
    cout<<x0<<endl;
    
    return 0;
}//main


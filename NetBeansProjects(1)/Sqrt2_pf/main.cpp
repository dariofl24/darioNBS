
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
    double x0=0;
    
    cout<<"x0=0"<<endl;
    cout<<"Numero de iteraciones:"<<endl;
    cin>>its;
    
    cout<<"\n"<<endl;
    
    for(int i=1;i<=its;++i){
        x0=sqrt((2+x0));
        cout<<x0<<endl;
    }//for
    
    
    cout<<"\n"<<"x"<<its<<"= "<<x0<<endl;
    
    return 0;
}//main


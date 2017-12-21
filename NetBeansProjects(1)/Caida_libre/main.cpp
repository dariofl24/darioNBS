
#include <cstdlib>
#include <iostream>
#include <stdlib.h>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    double h0,v=0,h,t;
    double g=-9.81;
    
    cout<<"Altura(m)= ";
    cin>>h0;
    
    h=h0;
    v=0;
    t=0;
    
    while(h>=0){
        
        cout<<"t="<< t <<" ; "<<"h="<< h <<"m ; "<<"v="<< v <<"m/s"<<endl;
        
        t=t+0.1;
        
        v= g*t;
        h=(0.5)*g*(t*t)+h0;
        
        if(h<0){
            cout<<"La pelota ha caido en el piso"<<endl;
            cout<<"t="<< t <<" ; "<<"h="<< h <<"m ; "<<"v="<< v <<"m/s"<<endl;
        }//if
        
    }//while
    
    
    
    return 0;
}//main


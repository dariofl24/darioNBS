

#include <cstdlib>
#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <stdio.h>

using namespace std;

int main(int argc, char** argv) {
    
    double a,b,c,ta,tb,tc,rp;
    
    cout<<"Ingresa los lados del trinagulo"<<endl;
    cin>>a;
    cin>>b;
    cin>>c;
    
    if( ((a+b)>c) && ((a+c)>b) && ((b+c)>a) ){
        
        if( (a==b) && (b==c) ){
            cout<<"El triangulo es equilatero"<<endl;
            
        }else{
            
            if( (a==b) || (a==c) || (c==b) ){
            cout<<"El triangulo es isoseles"<<endl;
            
        }else{
                cout<<"El triangulo es escaleno"<<endl;
        }//if-else
            
            
        }//if-else
        
        
        
    }else{
        cout<<"No son los lados de un trinagulo"<<endl;
    }//if-else
    
    
    
    return 0;
}//main


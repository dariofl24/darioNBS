

#include <cstdlib>
#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <stdio.h>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    int i0=0,i1=1,x=0,n=0;
    
    cout<<"Ingresa un numero entero"<<endl;
    cin>>n;
    
    if(n<0){
        cout<<n<<" es negativo"<<endl;
        cout<<"No esta en la serie de Fibonacci"<<endl;
        return 0;
    }//if
    
    if( (n==0) || (n==1) ){
        cout<<n<<" esta en la serie de Fibonacci*"<<endl;
    }else{
        
        while( (i0+i1)<=n ){
            x=i0+i1;
            i0=i1;
            i1=x;
        }//while
        
        if(i1==n){
            cout<<n<<" esta en la serie de Fibonacci"<<endl;
        }else{
            cout<<n<<" No esta en la serie de Fibonacci"<<endl;
        }//if-else
        
    }//if-else
    

    return 0;
}//main


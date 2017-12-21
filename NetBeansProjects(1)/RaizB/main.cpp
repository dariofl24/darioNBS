/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 17 de agosto de 2011, 02:56 PM
 */

#include <cstdlib>
#include <iostream>
#include <cmath>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    double x,r,t=0,limp;
    
    cout.setf(ios::fixed,ios::floatfield);
    cout.precision(22);
    
    limp=0.001;
    
    cout<<"Raiz de:";
    cin>>x;
    cout<<""<<endl;
    
    r=x;
    cout<<"r:"<<r<<" ; "<<"t:"<<t<<endl;
    
    while( r!=t ){
        
        t=r;
        r=(1.0/2.0)*((x/r)+r);
        
        cout<<"r:"<<r<<" ; "<<"t:"<<t<<endl;
    }//while
    
    cout<<"Raiz de:"<<x<<" ="<<r<<endl;
    
    return 0;
}//main


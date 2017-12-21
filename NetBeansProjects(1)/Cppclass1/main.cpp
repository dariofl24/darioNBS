/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 16 de agosto de 2011, 12:38 PM
 */

#include <cstdlib>
#include <iostream>
#include <complex>
#include <vector>
#include <cmath>
using namespace std;

/*
 * 
 */

void fun(int& a){//paso por referencia
    a=3;
}//fun

void f2(int* p){
    *p=2;
}//

double promedio(const vector<int> v){
    //paso por referencia sin modificar en la funcion
    
    double prom=0;
    
    for(int i=0;i<v.size();++i){
        prom= v[i]+prom;
    }//for
    
    return prom/v.size();
}//promedio

int main(int argc, char** argv) {
    
    int x=5;
    
    fun(x);
    cout<<x <<endl;
    
    vector<int> vec;
    
    for(int i=0;i<10;++i)
        vec.push_back(i);
    
    cout<<"Promedio= "<<promedio(vec)<<endl;
    
    int a=3,b=1;
    int* p; //apuntador a un entero
    p= &a; //p apunta a la direccion de a
    
    cout<<"p= "<<p <<endl;
    
    cout<< *p <<endl; //el contenido de donde apunta p
    *p=18; //cambia el contenido de donde apunta p
    cout<< *p<<";"<<a<< endl;
    
    f2(&a);
    
    p=&b;
    *p=4;
    
    double areg[10];
    
    cout<< areg <<endl;
    
    cout<< areg[0]<<endl;
    cout<< *areg<<endl;
    
    cout<< areg[1]<<endl;
    cout<< *(areg+1) <<endl;
    
    double* pp= areg+1;
    cout<< *pp <<endl;
    
    double* arr= new double[1000];//se crea un apuntador que apunta a un arreglo en el heap
    delete[] arr; //libera la memoria 
    
    return 0;
}//main


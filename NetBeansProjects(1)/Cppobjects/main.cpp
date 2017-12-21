/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 25 de agosto de 2011, 12:28 PM
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

class Particula{
private:
    double x,vx;
    
public:
    
    Particula(double xx,double vxx){ //constructor
        x=xx;
        vx=vxx;
    }//
    
    Particula(){
       x=0;
       vx=1;
    }//
    
    void ini(double xx,double vxx){
        x=xx;
        vx=vxx;
    }//ini
    
    void mover(double dt){
        x +=vx*dt;
    }//mover
    
    double getx(){
        return x;
    }//getx
    
    void print(){
        cout<<"(x,v)= "<<x<<","<<vx<<endl;
    }//print
    
};

class Gas{
private:
    vector<Particula> parts;
    int nps;
    
public:
    
    Gas(double vxx,int ps){
        nps=ps;
        
       for(int i=1;i<=ps;++i){
           parts.push_back( Particula(i,vxx) );
       }//for
       
    }//
    
    void mover(double dt){
        
        for(int i=0;i<nps;++i){
            parts[i].mover(dt);
        }//for
        
    }//mover
    
    void print(){
        for(int i=0;i<10;++i){
            parts[i].print();
        }//parts
    }//print
    
    
};

int main(int argc, char** argv) {
    
    Particula p1(10,1); //creacion de particula con constructor
    Particula p2; //creacion con constructor por defecto
    
    //arreglo de particulas
    //Particula parts[10];
    
    vector<Particula> parts;
    
    for(int i=1;i<=10;++i){
        parts.push_back(Particula(i,1));
    }//parts
    
    for(int i=0;i<10;++i){
        parts[i].print();
    }//parts
    
    //p.x += p.vx*(0.1);
    p1.mover(0.1);
    cout<< p1.getx() <<endl;
    cout<< p2.getx() <<endl;
    
    return 0;
}//main


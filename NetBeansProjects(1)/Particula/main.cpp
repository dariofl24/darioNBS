/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 1 de septiembre de 2011, 12:19 PM
 */

#include <cstdlib>
#include <iostream>

using namespace std;

/*
 * 
 */

struct Vec{
public:
    double x,y;
    
    Vec(){
       x=0;
       y=0;
    }//
    
    Vec(double xx,double yy){
       x=xx;
       y=yy;
    }//
    
    friend ostream& operator<< (ostream& os,Vec& v);
};

class Particula{
public:
    double x,y,vx,vy;
    Vec pos;
    Vec vel;
    
    Particula(){
       x=0; 
    }//
    
    Particula(double xx,double yy,double vxx,double vyy):pos(xx,vxx),vel(yy,vyy){
         
    }//
    
    void mover(double xx){
        x+=xx;
    }//mover
    
};

ostream& operator<<(ostream& os,Vec& v){
    os<< "("<< v.x <<" ; "<< v.y <<")";
    return os;
}//

int main(int argc, char** argv) {
    
    Particula p;
    Particula* pp;
    
    pp= &p;
    
    cout<< p.x <<endl;
    cout<< (*pp).x <<endl;
    cout<< pp ->x <<endl;
    
    pp= new Particula();
    
    cout<< pp << endl;
    
    pp->mover(1);
    cout<< pp ->x <<endl;
    
    
    return 0;
}//


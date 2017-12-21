/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 1 de septiembre de 2011, 01:21 PM
 */

#include <cstdlib>
#include <vector>
#include <iostream>

using namespace std;

/*
 * 
 */

class Forma{
public:
    double x;
    
    double pos(){
        return x;
    }//pos
    
    virtual void dibujar(){
        cout<< x <<endl;
    }//dibujar
};

class Circulo: public Forma{
public: 
    double radio;
    
    void dibujar(){
        cout<<"Circulo "<< x <<endl;
    }//dibujar
    
};

int main(int argc, char** argv) {
    
    Circulo c;
    Forma f;
    
    cout<< c.x<<endl;
    
    Forma* p; //puntero a cualquier tipo de forma
    p= &c;
    
    p->dibujar(); //dibujar de circulo por que la de forma es virtual
    
    vector <Forma*> vec;
    
    vec.push_back(new Forma());
    
    cout<<"vec: "<< vec[0]->x << endl;
    
    return 0;
}//


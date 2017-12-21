/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 9 de junio de 2011, 03:01 PM
 */


#include <iostream>

#include "Nodo.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    cout<<"Hola"<<endl;
    
    Nodo nod("Nod");
    cout<<nod.element<<endl;
    
    Nodo* na= new Nodo("1");
    Nodo* nb= new Nodo("2",na);
    Nodo* nc= new Nodo("---");
    
    cout<< na->element <<endl;
    
    nb->sig->element="999";
    
    cout<< na->element <<endl;
    
    cout<< nb->get_element() <<endl;
    
    nb->set_elem("+++");
    
    cout<< nb->get_element() <<endl;
    
    nb->set_sig(nc);
    
    cout << nb->sig->element <<endl;
    
    return 0;
}//main


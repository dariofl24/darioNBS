/* 
 * File:   Nodo.cpp
 * Author: DarioF
 * 
 * Created on 9 de junio de 2011, 09:50 PM
 */

#include "Nodo.h"
#include <string>

using namespace std;


Nodo::Nodo() {
    
}//0

Nodo::Nodo(string e){
    element=e;
}//

Nodo::Nodo( Nodo* an, string e){
    ant= an;
    element= e;
}//

Nodo::Nodo(string e, Nodo* si){
    sig= si;
    element=e;
    
}//

void Nodo::set_ant(Nodo* an){
    delete ant;
    ant=an;
}//set_ant

void Nodo::set_sig(Nodo* si){
    delete sig;
    sig=si;
}//set_sig

void Nodo::set_elem(string e){
    element=e;
}//set_elem

string Nodo::get_element(){
   return element; 
}//element

Nodo* Nodo::get_sig(){
    return sig;
}//get_sig

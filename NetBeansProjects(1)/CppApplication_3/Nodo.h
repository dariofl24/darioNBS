/* 
 * File:   Nodo.h
 * Author: DarioF
 *
 * Created on 9 de junio de 2011, 09:50 PM
 */

#ifndef NODO_H
#define	NODO_H
#include <string>

using namespace std;

class Nodo {
public:
    string element;
    Nodo* ant;
    Nodo* sig;
    
    Nodo();
    Nodo(string e);
    Nodo(Nodo* an,string e);
    Nodo(string e,Nodo* si);
    void set_ant(Nodo* an);
    void set_sig(Nodo* si);
    void set_elem(string e);
    string get_element();
    Nodo* get_sig();

};

#endif	/* NODO_H */


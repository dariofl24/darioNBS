

#include <cstdlib>
#include <iostream>
#include <math.h>
#include <stdlib.h>
#include <stdio.h>

using namespace std;

int main(int argc, char** argv) {
    
    int fig,PA;
    double l1,l2,l3;
    
    cout<<"Elige la figura"<<"\n"<<endl;
    
    cout<<"1) Cuadrado"<<endl;
    cout<<"2) Rectangulo"<<endl;
    cout<<"3) Triangulo"<<endl;
    cout<<"4) Circulo"<<endl;
    cout<<"5) SALIR"<<endl;
    
    cin>>fig;
    
    if( (fig <1) || (fig>=5) ) return 0;
    
    cout<<"Elige que quieres calcular"<<"\n"<<endl;
    cout<<"1) Perimetro"<<endl;
    cout<<"2) Area"<<endl;
    
    cin>>PA;
    
    if( (PA <1) || (PA>2) ) return 0;
    
    if(PA==2) fig=(-1)*fig;
    
    if( (fig==1)||(fig==-1) ){
        
        cout<<"Elegiste un Cuadrado"<<endl;
        cout<<"Ingresa el lado del cuadrado"<<endl;
        cin>>l1;
        
        if(fig>0){
            cout<<"El perimetro del cuadrado es: "<<(4.0*l1)<<endl;
        }else{
            cout<<"El area del cuadrado es: "<<(l1*l1)<<endl;
        }//if-else
        
        
    }//if
    
    if( (fig==2)||(fig==-2) ){
        cout<<"Elegiste un Reactangulo"<<endl;
        cout<<"Ingresa los lados del reactangulo"<<endl;
        cin>>l1;
        cin>>l2;
        
        if(fig>0){
            cout<<"El perimetro del rectangulo es: "<<( (2.0*l1)+(2.0*l2) )<<endl;
        }else{
            cout<<"El area del rectangulo es: "<<(l1*l2)<<endl;
        }//if-else
        
    }//if
    
    if( (fig==3)||(fig==-3) ){
        cout<<"Elegiste un Triangulo"<<endl;
        
        
        if(fig>0){
            cout<<"Ingresa los lados del Triangulo:"<<endl;
            cin>>l1;
            cin>>l2;
            cin>>l3;
            
            cout<<"El perimetro del Triangulo es: "<<( l1+l2+l3 )<<endl;
        }else{
            cout<<"Ingresa la base del triangulo:"<<endl;
            cin>>l1;
            
            cout<<"Ingresa la altura del triangulo"<<endl;
            cin>>l2;
            
            l3=(l1*l2)/2.0;
            cout<<"El area del triangulo es: "<<l3<<endl;
        }//if-else
        
    }//if
    
    if( (fig==4)||(fig==-4) ){
        cout<<"Elegiste un Circulo"<<endl;
        cout<<"Ingresa el radio del Circulo"<<endl;
        cin>>l1;
        
        if(fig>0){
            cout<<"El perimetro del circulo es: "<<( (2.0*l1)*(3.141592) )<<endl;
        }else{
            cout<<"El area del circulo es: "<<( l1*l1*(3.141592) )<<endl;
        }//if-else
        
    }//if
    
    
    return 0;
}//main


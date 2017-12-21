

#include <cstdlib>
#include <cstdio>

using namespace std;
#define LEN 11

int main(int argc, char** argv) {
    
    char cad1[LEN];
    char cad2[LEN];
    int l1=0,l2=0,i,eq;
    
    printf("Cadena 1:\n");
    gets(cad1);
    
    printf("\n");
    printf("Cadena 2:\n");
    gets(cad2);
    
    i=0;
    
    while(cad1[i]!='\0'){
        
        l1=l1+1;
        
        i=i+1;
    }//while
    
    
    i=0;
    
    while(cad2[i]!='\0'){
        
        l2=l2+1;
        
        i=i+1;
    }//while
    
    printf("Longitud de la cadena 1:");
    printf("%i",l1);
    
    printf("\nLongitud de la cadena 2:");
    printf("%i",l2);
    printf("\n");
    
    if(l1==l2){
        
        eq=0;
        
        for(i=0;i<l1;i++){
            
            if(cad1[i]==cad2[i]){
                eq=eq+1;
            }//if
            
        }//for
        
        if(eq==l1){
                printf("Las cadenas son iguales");
        }else{
                printf("Las cadenas son diferentes");
        }//if-else
        
        
    }else{
        
        if(l1<l2){
            printf("La cadena 1 es mas chica que la cadena 2");
        }else{
            
            printf("La cadena 2 es mas chica que la cadena 1");
            
        }//if-else
        
    }//if
    
    
    
    return 0;
}//main


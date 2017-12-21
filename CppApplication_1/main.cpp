

#include <cstdlib>
#include <cstdio>

using namespace std;
#define LEN 101

int main(int argc, char** argv) {
    
    int i;
    char line[LEN];
    char coded[LEN];
    
    
    for(i=0;i<100;i++){
        line[i]=' ';
        coded[i]=' ';
    }//for
        
    
    
    printf("Frase a encriptar:\n");
    
    gets(line);
    
    
    for(i=0;i<100;i++){
        
        switch(line[i]){
            
            case'a':
                coded[i]='W';
                break;
                
            case'b':
                coded[i]='X';
                break;
                
            case'c':
                coded[i]='Y';
                break;
                
            case'd':
                coded[i]='Z';
                break;
            
            case'e':
                coded[i]='A';
                break;
                
            case'f':
                coded[i]='B';
                break;
                
            case'g':
                coded[i]='C';
                break;
                
            case'h':
                coded[i]='D';
                break;
                
            case'i':
                coded[i]='E';
                break;
                
            case'j':
                coded[i]='F';
                break;
                
            case'k':
                coded[i]='G';
                break;
                
            case'l':
                coded[i]='H';
                break;
                
            case'm':
                coded[i]='I';
                break;
                
            case'n':
                coded[i]='J';
                break;
                
            case'o':
                coded[i]='K';
                break;
                
            case'p':
                coded[i]='L';
                break;
            
           case'q':
               coded[i]='M';
                break;
                
           case'r':
               coded[i]='N';
                break;
                
           case's':
               coded[i]='O';
                break;
                
           case't':
               coded[i]='P';
                break;
           
           case'u':
               coded[i]='Q';
                break;
                
           case'w':
               coded[i]='R';
                break;
                
           case'x':
               coded[i]='S';
                break;
                
           case'y':
               coded[i]='T';
                break;
                
           case'z':
               coded[i]='U';
                break;
                
           case' ':
               coded[i]=' ';
                break;
                
           case'\0':
               coded[i]='\0';
                break;
                
            default:
                coded[i]='0';
                break;
                
                
                
        }//switch
        
    }//for
        
    puts(line);
    
    puts(coded);
     
    
    return 0;
}//main


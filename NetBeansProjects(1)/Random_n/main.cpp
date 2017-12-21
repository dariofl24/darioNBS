/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 11 de junio de 2011, 05:18 PM
 */

#include <cstdlib>
#include <iostream>
#include <math.h>
#include <time.h>

using namespace std;

double Random(){
    double r;
    
    r=rand()/((double)RAND_MAX);
    
    return r;
}//Random


double RandomN_s(int l){
    
    double num=0,div=1,r; //RAND_MAX
    
    for(int i=1;i<=l;i++){
        div= div/10.0;
        r=(double)(rand()%10);
        num=num+( div*r );
        //cout<<r;
    }//for
    //cout<<""<<endl;
    
    return num;
}//RandomN_s

int main(int argc, char** argv) {
    
    double c=0.001;
    int ns[1000];
    int ns2[1000];
    
    
    cout<<"Rand max:"<<RAND_MAX<<endl;
    
    srand(time(NULL));
    
    for(int k=0;k<1000;++k){
        ns[k]=0;
        ns2[k]=0;
    }//for
    
    
    for(int i=1;i<=10000000;++i){
        ns[ (int)floor( Random()*1000 ) ]+=1;
        
    }//for
    
    for(double l=0;l<1000;++l){
        cout<<"("<<(l*c)<<" , "<<( (l+1)*c )<<"): "<<ns[(int)l]<<endl;
    }//for

    return 0;
}//


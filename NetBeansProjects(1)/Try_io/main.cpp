/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 13 de junio de 2011, 02:54 PM
 */

#include <cstdlib>
#include <iostream>
#include <math.h>
#include <fstream>
#include <stdlib.h>
#include <dirent.h>
#include <iomanip>


using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    string ss="assfss";
    ofstream wff;
    ifstream rff;
    string line;
    double num;
    
    
    wff.setf(ios::fixed,ios::floatfield);
    wff.precision(21);
    cout.setf(ios::fixed,ios::floatfield);
    cout.precision(21);
    
    
    wff.open("fileN.txt",ios::app);
    
    
    if(wff.is_open()){
        
        do{
            wff<<101.16767800066777<<"\n";
            wff<<102.1000000110002<<"\n";
            wff<<103.00000000967<<"\n";
            wff<<0.000000001773<<"\n";
            wff<<105.000007<<"\n";
            wff<<0.00000000046786<<"\n";
        }while(wff.fail());
        
    }//if
    
    wff.close();
    rff.open("fileN.txt");
    
    if(rff.good()){
        cout<<"good"<<endl;
    }else{
        cout<<"NN"<<endl;
    }//if-else
    
    while(!rff.eof() ){
        
        getline(rff,line);
        if(line=="") cout<<"..."<<endl;  
        
        num= atof(line.c_str());
        
        cout<<num<<endl;
        
    }//while
    
    rff.close();
    
    
    return 0;
}//


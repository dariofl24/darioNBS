/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 11 de junio de 2011, 02:08 PM
 */

#include <cstdlib>
#include <iostream>
#include <time.h>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    int nums[10];
    int r=0;
    int tim=0;
    
    clock_t tt;
    
    for(int t=0;t<10;++t){
    
        tt= clock();
        cout<<"tt: "<<(float)tt<<endl;
        
    srand(time(NULL)+nums[2]+nums[0]+nums[9]+3);
    
    for(int j=0;j<10;j++)
        nums[j]=0;
    
    for(int i=1;i<=1000;++i){
        nums[rand()%10]+=1;
    }//for
    
    for(int k=0;k<10;++k){
        cout<<nums[k]<<endl;
    }//for
    
    cout<<"\n";
    
    }//
    
    return 0;
}//


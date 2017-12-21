/* 
 * File:   main.cpp
 * Author: DarioF
 *
 * Created on 8 de junio de 2011, 01:00 AM
 */

#include <stdio.h>
#include <time.h>
#include <iostream>
using namespace std;

int main ()
{
  time_t rawtime;
  struct tm * timeinfo;
  string s;

  time ( &rawtime );
  timeinfo = localtime ( &rawtime );
  printf ( "The current date/time is: %s", asctime (timeinfo) );
  cout<<" "<<asctime (timeinfo)<<endl;
  s=asctime (timeinfo);
  cout<<" "<<s<<endl;
  
  return 0;
}


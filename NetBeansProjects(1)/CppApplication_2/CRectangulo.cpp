#include <iostream>
#include <string>
using namespace std;

class CRectangulo
{
	private:            //no es necesario poner "private:", ya que por default están declarados como privados
		int altura;
		int base;
		string color;
	public:
		int area();
                
                void CRectangulo::pon_valor(int x, int y)   // hago un "scope" para definir la funcion pon_valor de la clase CRectangulo fuera de la misma
{
	altura = y;
	base = x;
}

int CRectangulo::perimetro()
{
	return (2*base)+(2*altura);
}
		
};//class




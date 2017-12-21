/* 
 * File:   main.cpp
 *
 * Created on 23 de marzo de 2012, 01:06 AM
 */

#include <iostream>
#include <math.h>
#include <cassert>
#include <vector>
#include <iostream>

using namespace std;

/*
 * Points sur le segments:
 * 			0|--------------|1
 * On donne Ã©galement les poids sur ces points correspondants Ã  une
 * formule de quadrature exacte sur
 * 2r+1 (r Ã©tant le nombre de points moins 1).
 *
 * On accede a au iÃ¨me poids et points de la formule de quadrature exacte sur 2r+1 par:
 * 		_G_pt[r][i] => points
 * 		_G_wt[r][i] => poids
 *
 */

namespace
{
//Formule de quadrature exacte sur P1
const double _G_pt1[1]={0.5};
const double _G_wt1[1]={1.0};

//Formule de quadrature exacte sur P3
const double _G_pt2[2]={0.21132486540518711774, 0.78867513459481288226};
const double _G_wt2[2]={0.5, 0.5};

//Formule de quadrature exacte sur P5
const double _G_pt3[3]={0.11270166537925831148, 0.5, 0.88729833462074168852};
const double _G_wt3[3]={5./18., 4./9., 5./18.};

//Formule de quadrature exacte sur P7
const double _G_pt4[4]={(-0.8611363115940525752239465+1)*0.5,(-0.3399810435848562648026658+1)*0.5,(0.3399810435848562648026658+1)*0.5,(0.8611363115940525752239465+1)*0.5};
const double _G_wt4[4]={0.3478548451374538573730639*0.5,0.652145154862546142626936*0.5,0.652145154862546142626936*0.5,0.3478548451374538573730639*0.5};

//Formule de quadrature exacte sur P9
const double _G_pt5[5]={(-0.9061798459386639927976269+1)*0.5,(-0.5384693101056830910363144+1)*0.5,0.5,(0.5384693101056830910363144+1)*0.5,(0.9061798459386639927976269+1)*0.5};
const double _G_wt5[5]={0.236926885056189087514264*0.5,0.4786286704993664680412915*0.5,0.5688888888888888888888889*0.5,0.4786286704993664680412915*0.5,0.236926885056189087514264*0.5};

//Formule de quadrature exacte sur P11
const double _G_pt6[6]={(-0.9324695142031520278123016+1)*0.5,(-0.6612093864662645136613996+1)*0.5,(-0.2386191860831969086305017+1)*0.5,(0.2386191860831969086305017+1)*0.5,(0.6612093864662645136613996+1)*0.5,(0.9324695142031520278123016+1)*0.5};
const double _G_wt6[6]={0.1713244923791703450402961*0.5,0.3607615730481386075698335*0.5,0.4679139345726910473898703*0.5,0.4679139345726910473898703*0.5,0.3607615730481386075698335*0.5,0.1713244923791703450402961*0.5};

//Formule de quadrature exacte sur P13
const double _G_pt7[7]={(-0.9491079123427585245261897+1)*0.5,(-0.7415311855993944398638648+1)*0.5,(-0.4058451513773971669066064+1)*0.5,0.5,(0.4058451513773971669066064+1)*0.5,(0.7415311855993944398638648+1)*0.5,(0.9491079123427585245261897+1)*0.5};
const double _G_wt7[7]={0.1294849661688696932706114*0.5,0.2797053914892766679014678*0.5,0.3818300505051189449503698*0.5,0.4179591836734693877551020*0.5,0.3818300505051189449503698*0.5,0.2797053914892766679014678*0.5,0.1294849661688696932706114*0.5};

const double* _G_pt[7]={_G_pt1,_G_pt2,_G_pt3,_G_pt4,_G_pt5,_G_pt6,_G_pt7};
const double* _G_wt[7]={_G_wt1,_G_wt2,_G_wt3,_G_wt4,_G_wt5,_G_wt6,_G_wt7};

const int _Order_Max_G = 7;
}



class GaussRule
{
private:
	double uvw[3];
	
	//Order of the Gauss Lobatto quadrature rule used in each subdivision
	int _num_order;	
	
	// number of subdivision in 1D
	int _num_segments;
	
	//Dimension of the quadrature rule (1 or 2)
	int _dim;		
	

	//h = 1.0/(num_segments)
	double _h; 
	

	//Position and weights of the quadrature rule
	vector<double> _x; 		
	vector<double> _y;
	vector<double> _z;
	
	vector<double> _weights;
	
	void _init_1D()
	{
		
		int num_1D_points = _num_order*_num_segments+1;
		int size = num_1D_points;

		_x.resize(size,0.0);
		_y.resize(size,0.0);
		_z.resize(size,0.0);
		_weights.resize(size,0.0);

		for (int i=0;i<_num_segments;++i)                                  
			for (int j=0;j<_num_order+1;++j) 
			{
				_x[i*_num_order+j]= i*_h+_G_pt[_num_order][j]*_h;
				_weights[i*_num_order+j]+= _G_wt[_num_order][j]*_h;
			}	
	}
	
	void _init_2D()
	{
		
		int num_1D_points = _num_order*_num_segments+1;
		int size = num_1D_points*num_1D_points;

		_x.resize(size,0.0);
		_y.resize(size,0.0);
		_z.resize(size,0.0);
		_weights.resize(size,0.0);
		
		for (int i=0;i<_num_segments;++i)                                 
			for (int j=0;j<_num_order+1;++j) 
				for (int k=0;k<_num_segments;++k)                                  
					for (int l=0;l<_num_order+1;++l) 
					{
						_x		[(i*_num_order+j)*num_1D_points+(k*_num_order+l)]= i*_h+_G_pt[_num_order][j]*_h;
						_y		[(i*_num_order+j)*num_1D_points+(k*_num_order+l)]= k*_h+_G_pt[_num_order][l]*_h;
						_weights[(i*_num_order+j)*num_1D_points+(k*_num_order+l)]+= _G_wt[_num_order][j]*_G_wt[_num_order][l]*_h*_h;
					}
				
			
		
	}

	void _init_3D()
	{
		
		int num_1D_points = _num_order*_num_segments+1;
		int size = num_1D_points*num_1D_points*num_1D_points;

		_x.resize(size,0.0);
		_y.resize(size,0.0);
		_z.resize(size,0.0);
		_weights.resize(size,0.0);
		
		for (int i=0;i<_num_segments;++i)                                 
			for (int j=0;j<_num_order+1;++j) 
				for (int k=0;k<_num_segments;++k)                                  
					for (int l=0;l<_num_order+1;++l) 
						for (int m=0;m<_num_segments;++m)                                  
							for (int n=0;n<_num_order+1;++n)
					{
						_x		[(i*_num_order+j)*num_1D_points*num_1D_points+(k*_num_order+l)*num_1D_points+(m*_num_order+n)]= i*_h+_G_pt[_num_order][j]*_h;
						
						_y		[(i*_num_order+j)*num_1D_points*num_1D_points+(k*_num_order+l)*num_1D_points+(m*_num_order+n)]= k*_h+_G_pt[_num_order][l]*_h;
						
						_z		[(i*_num_order+j)*num_1D_points*num_1D_points+(k*_num_order+l)*num_1D_points+(m*_num_order+n)]= m*_h+_G_pt[_num_order][n]*_h;
						
						_weights[(i*_num_order+j)*num_1D_points*num_1D_points+(k*_num_order+l)*num_1D_points+(m*_num_order+n)]+= _G_wt[_num_order][j]*_G_wt[_num_order][l]*_G_wt[_num_order][n]*_h*_h*_h;
					}
				
			
		
	}
		
public:
	
	GaussRule(int num_order,int num_segments, int dim) : _num_order(num_order),_num_segments(num_segments),_dim(dim)
	{
		assert(_num_segments>=1);
		assert(_num_order>=1);
		assert(_num_order<=_Order_Max_G);
		assert(_dim>0);
		assert(_dim<4);
		
		_h=1.0/(_num_segments);
		
		switch(_dim)
		{
			case 1:_init_1D();    break;
			case 2:_init_2D();    break;
			case 3:_init_3D();    break;
			default:assert(false);break;
		}
		
		uvw[0]=0.0;
		uvw[1]=0.0;
		uvw[2]=0.0;
	}	
	
	int getNumQuadraPoints() {return _weights.size();};
	
	double getWeight(int n) {return _weights[n];};

	const double* getQuadraPointPos(int n) 
	{
		uvw[0]=_x[n];
		
		if (_dim==2) 
			uvw[1]=_y[n];
		else if (_dim==3) 
		{
			uvw[1]=_y[n];
			uvw[2]=_z[n];
		}

		return uvw;
	};
};//class


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	double u;


double f(double *XXX,double *YYY)
{

	

	double u1_u2 = (2.0*u-1.0);
	double u1pu2 = (u*u+(1-u)*(1-u));
	
	
	double combinaison1 = ((1.0-u)*YYY[0]-u*XXX[0])*((1.0-u)*YYY[0]-u*XXX[0])
	                    + ((1.0-u)*YYY[1]-u*XXX[1])*((1.0-u)*YYY[1]-u*XXX[1])
					    + ((1.0-u)*YYY[2]-u*XXX[2])*((1.0-u)*YYY[2]-u*XXX[2]);
					
	double sqrt_combinaison1 = sqrt(combinaison1);			
		

	double combinaison2 = (YYY[0]+XXX[0])*(YYY[0]+XXX[0])
	                    + (YYY[1]+XXX[1])*(YYY[1]+XXX[1])
					    + (YYY[2]+XXX[2])*(YYY[2]+XXX[2]);
					
	double sqrt_combinaison2 = sqrt(combinaison2);
	
					
	double exposant	= combinaison1 + 0.5*u1pu2*combinaison2 + 0.5*(YYY[0]*YYY[0]+YYY[1]*YYY[1]+YYY[2]*YYY[2]);
					 
			
							
	double X = u1_u2*sqrt_combinaison2*sqrt_combinaison1;
					
	
	double sinhX_X;
	
	if (fabs(X)<1e-3)
	{
		double X2 = X*X;
		double X4 = X2*X2;
		double X6 = X2*X4;
		
		sinhX_X = 1 + X2*(1.0/6.0) + X4*(1.0/120.0) + X6*(1.0/5040.0); //x^8 / 362880
	}
	else
	{
		sinhX_X = sinh(X)/X;
	}
	
	
	
	return  2.0*sinhX_X*sqrt_combinaison1*exp(-exposant);
}

int main()
{
	double size_center;	
	int num_segments_center;
	int order_center;

	

	cout << " u ? " << endl;
	cin >> u;
	

	cout << " Taille du domaine d'integration : " << endl;
	cin>>size_center;
	
	cout << "Nombre de decoupe de ce domaine : " << endl;
	cin>>num_segments_center;

	cout << "Ordre de la formule d'integration (entre 2 et 6) : " << endl;
	cin>>order_center;	

	
	GaussRule center(order_center,num_segments_center,3);
		
		

	double value = 0.0;
	double X[3];
	double Y[3];
	
	double volume = size_center*size_center*size_center; 
	
	cout << "Densite de points de quadrature (uniformement repartis) : " << double(center.getNumQuadraPoints())/volume << endl;
	
	
	double done = 0.0;
	
	//Main integral----------------------------
	//Center
	for (int i=0;i<center.getNumQuadraPoints();++i)
	{
		

		double intermediate_value=0.0;

		
		X[0]=size_center*(center.getQuadraPointPos(i)[0]-0.5);
		X[1]=size_center*(center.getQuadraPointPos(i)[1]-0.5);
		X[2]=size_center*(center.getQuadraPointPos(i)[2]-0.5);
					
		//Sub integral--------------------------
		//Center
		for (int j=0;j<center.getNumQuadraPoints();++j)
		{
			
			Y[0]=size_center*(center.getQuadraPointPos(j)[0]-0.5);
			Y[1]=size_center*(center.getQuadraPointPos(j)[1]-0.5);
			Y[2]=size_center*(center.getQuadraPointPos(j)[2]-0.5);
			
			
			intermediate_value+=f(X,Y)*center.getWeight(j)*volume;	
			

		}
	
		if (i/double(center.getNumQuadraPoints())>done)
		{
			cout << " done " << done*100 << " % " << endl;
			done +=0.05;
		}
		
		value+=intermediate_value*intermediate_value*center.getWeight(i)*volume;
		
	}
	
	cout << value  << " a comparer a (si u = 1) ::"  << 225.333 << " a comparer a (si u = 0.5) ::"  << 4*114.555 << endl;

}

/**
*	LU.java
*	Created on 22 November 2013, 11:13 hrs.
*	A simple class wich uses LU method.
*	@see Gauss.java
*
*	Universidad Nacional Autónoma de México
*	Programación Avanzada y Métodos Numéricos
*	Facultad de Ingeniería
*	Semestre: 2014-1
*	Profesor: Honorato Saavedra Hernández	
*/

/**
*	@author: Equipo8
*
*			 -> Trejo Juárez César Alberto				contact:   cesaralberto@yandex.com / cesaratj27@gmail.com
*			 -> Hernández Cuecuecha Jorge Alberto		contact:   fig_jorg10_7@hotmail.com
*			 -> Servín Lucario Verónica Valeria			contact:   vili_servin@hotmail.com
*			 -> Martínez Lara José Alberto				contact:   betto_ma_war.h@hotmail
*			 -> Fajardo Álvarez Samuel					contact:   samfajalv@gmail.com
*			 -> Sebastian Cuatepotzo					contact:   sstsacm@gmail.com
*
*/

public class LU extends Gauss{

	//Propiedades
	public float L[][];
	public float U[][];

	//Constructor
	public LU(int n){
		super(n);
		this.L = new float[n][n];
		this.U = new float[n][n];
	}

	//Metodos

	/** 
	*	Metodo para obtener U
	*	@return: array[n] 
	*	@param: nothing
	*/
	public float getU(){
		int i,j,k;

		for(k=0; k<3; k++) {
			for(i=0; i<3; i++) {
				U[k][i] = 0;
				
				for(j=k+1;j<3;j++) {
					U[k][j] = (A[k][j] - summation(k, j, 2)) / L[k][k];
				}
			}
		}
		

		return U;
	}
	
	/** 
	*	Metodo para obtener L
	*	@return: array[n] 
	*	@param: nothing
	*/
	public float getL(){
		int i,j,k;
		
		for(k=0; k<3; k++) {
			for(j=0; j<3; j++) {
			
				L[k][k] = A[k][k] - summation(k,-1, 0);

				for(i=k+1;i<3;i++) {
					L[i][k] = A[i][k] - summation(k, i, 1);
				}
			}
		}
		return L;
	}
	
	public void summation(int prim_counter, int sec_counter, int flag) {
		int s = 0;
		int k = prim_counter;

		float mult = 0;
		float sum = 0;

		if(flag == 0) {
			for(s=0;s<k;s++) {
					mult = L[k][s] * U[s][k];
					sum = sum + mult;
			}
		}else if(flag == 1) {
			for(s=0;s<k;s++) {
					mult = L[sec_counter][s] * U[s][k];
					sum = sum + mult;
			}
		} else if(flag == 2) {
			for(s=0;s<k;s++) {
					mult = L[k][s] * U[s][sec_counter];
					sum = sum + mult;
			}
		}
	return sum;
	}
	
	public double getX(){
		
		double y_1, y_2, y_3, x_1, x_2, x_3;
		
		y_1 = B[0] / L[0][0];
		y_2 = (B[1] - L[1][0] * y_1) / L[1][1];
		y_3 = (B[2] - (L[2][0] * y_1) - (L[2][1] * y_2)) / L[2][2];
		
		x_3 = y_3;
		x_2 = y_2 - U[1][2] * x_3;
		x_1 = y_1 - U[0][1] * x_2 - U[0][2] * x_3;
		
		System.out.println("Solution: x1=" + x_1 + ", x2=" + x_2 + ", x3=" + x_3);
	}
}

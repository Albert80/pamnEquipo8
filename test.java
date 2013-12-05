/**
*	test.java
*
*	Created on 3 December 2013, 12:30 hrs.
*	A simple class wich implements a single object of
*	every single class that we created.
*	@see Funcion.java
*	@see MiFuncion.java
*	@see Biseccionador.java
*	@see NewtonRaphson.java
*	@see Gauss.java
*	@see GaussJordan.java
*	@see LU.java
*	@see DDNewton.java
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

public class test{
	public static void main(String args[]){
		///*
		//+---------------Gauss-------------------+//
		double []solG;
		double []soluciones = {2.4, 6.4, 7.6};
		double [][]sistemaEc = { {1, 2, 3},
								 {-2, -4, 8},
								 {3, 1, 2} };
		Gauss matrix = new Gauss(soluciones.length);
		System.out.println("\t\t-+-+-+-+-GAUSS METHOD-+-+-+-+-");
		matrix.setB(soluciones);
		matrix.setA(sistemaEc);
		solG = matrix.getX();
		System.out.println("\n-->Gauss Solutions, X: ");
		for (int i = 0; i < solG.length; i++) {
			System.out.print("Variable " + (i+1) + " >>>\t" + Math.rint(solG[i]*10000)/10000); //redondear cifra a 3 decimales
			//System.out.print("Variable " + (i+1) + " >>>\t" + solG[i]); //--> sin redondear
			System.out.println();
		}
		//*/
		

		///*
		//+----------------GaussJordan----------------+//
		double []solGJ;
		double []solucionesGJ = {2.4, 6.4, 7.6};
		double [][]sistemaEcGJ = { {1, 2, 3},
								 {-2, -4, 8},
								 {3, 1, 2} };
		GaussJordan matrix_2 = new GaussJordan(solucionesGJ.length);
		System.out.println("\n\n\t\t-+-+-+-+-GAUSS-JORDAN METHOD-+-+-+-+-");
		matrix_2.setB(solucionesGJ);
		matrix_2.setA(sistemaEcGJ);
		solGJ = matrix_2.getX();
		System.out.println("\n-->Gauss-Jordan Solutions, X:");
		for (int j = 0; j < solGJ.length; j++) {
			System.out.print("Variable " + (j+1) + " >>>\t" + Math.rint(solGJ[j]*10000)/10000);
			System.out.println();
		}
		//*/


		///*
		//+-------------NewtonRaphson---------------+//
		Funcion f = new Funcion();
		MiFuncion df = new MiFuncion();
		NewtonRaphson newton = new NewtonRaphson(f, df);
		System.out.println("\n\n\t\t-+-+-+-+-NEWTONRAPHSON METHOD-+-+-+-+-");
		double result = newton.calcular(0.002, 10);
		System.out.println("-->Resultado de NewtonRaphson: " + Math.rint(result*10000)/10000);
		//*/
		

		///*
		//+-------------Bisección-----------------+//
		Funcion g = new Funcion();
		Biseccionador bisecc = new Biseccionador(1.2,1.4, g);
		System.out.println("\n\n\t\t-+-+-+-+-BISSECCIONADOR METHOD-+-+-+-+-");
		double resul = bisecc.calcular(0.002);
		System.out.println("-->Resultado de Bisección: " + Math.rint(resul*10000)/10000);
		//*/

		///*
		//+-------------Bisección-----------------+//
		System.out.println("\n\n\t\t-+-+-+-+-DDNewton-+-+-+-+-");
		DDNewton ej = new DDNewton(2.4);
		double x[] = {0.1, 0.4, 0.7, 1};
		double y[] = {2.31, 3.36, 4.59, 6};
		double coef[];
		ej.setX(x);
		ej.setY(y);
		coef = ej.getPolinomio();
		System.out.println("DDNewton");
		for (int k = 0; k < x.length; k++) {
			System.out.println("b"+ k + ": " + coef[k]);
		}
	}
}

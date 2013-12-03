public class test{
	public static void main(String args[]){
		///*
		//+---------------Gauss-------------------+//
		double []solG;
		double []soluciones = {2.4, 6.4, 7.6};
		double [][]sistemaEc = { {1, 2, 3},
								 {-2, -4, 8},
								 {3, 1, 2} };
		Gauss matrix = new Gauss(3);
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
		GaussJordan matrix_2 = new GaussJordan(3);
		System.out.println("\n\n\t\t-+-+-+-+-GAUSS-JORDAN METHOD-+-+-+-+-");
		matrix_2.setB(solucionesGJ);
		matrix_2.setA(sistemaEcGJ);
		solGJ = matrix_2.getX();
		System.out.println("\n-->Gauss-Jordan Solutions, X:");
		for (int i = 0; i < solGJ.length; i++) {
			System.out.print("Variable " + (i+1) + " >>>\t" + Math.rint(solGJ[i]*10000)/10000);
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


	}
}
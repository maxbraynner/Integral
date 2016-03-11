package br.com.calculo;

public class Acumulador {

	private static double acumulador = 0;

	public static double getAcumulador() {
		return acumulador;
	}

	synchronized public static void addAcumulador(double valor) {
		acumulador += valor;
	}
	
	public static void setAcumulador(double acumulador){
		Acumulador.acumulador = acumulador;
	}
}

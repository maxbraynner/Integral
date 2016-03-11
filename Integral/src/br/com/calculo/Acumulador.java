package br.com.calculo;

/**
 * Classe possui variavel compartilhada(Região crítica) sincronizada
 * @author braynner
 *
 */
public class Acumulador {

	private static double acumulador = 0;

	public static double getAcumulador() {
		return acumulador;
	}

	/**
	 * Incrementa o acumulador
	 * @param valor
	 */
	synchronized public static void addAcumulador(double valor) {
		acumulador += valor;
	}
	
	public static void setAcumulador(double acumulador){
		Acumulador.acumulador = acumulador;
	}
}

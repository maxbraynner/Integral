package br.com.calculo;

/**
 * efetua calculo da parte
 * @author braynner
 *
 */
public class ThreadCalculo implements Runnable{

	private double a, largura, indice;
	
	public ThreadCalculo(double a, double h, double indice) {
		this.a = a;
		this.largura = h;
		this.indice = indice;
	}

	/**
	 * função da integral
	 * @param icognita
	 * @return
	 */
	private double funcao(double icognita) {
		return 1 / (1 + icognita * icognita);
	}
	
	@Override
	/**
	 * efetua o calculo e adiciona ao acumulador
	 */
	public void run() { 
		double icognita = a + largura * indice;
		
		Acumulador.addAcumulador( funcao(icognita) );
	}
	
}

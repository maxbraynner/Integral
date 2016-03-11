package br.com.calculo;

public class ThreadCalculo implements Runnable{

	private double a, largura, indice;
	
	public ThreadCalculo(double a, double h, double indice) {
		this.a = a;
		this.largura = h;
		this.indice = indice;
	}

	private double funcao(double icognita) {
		return 1 / (1 + icognita * icognita); // função da integral
	}
	
	@Override
	public void run() {
		double icognita = a + largura * indice;
		
		Acumulador.addAcumulador( funcao(icognita) );
	}
	
}

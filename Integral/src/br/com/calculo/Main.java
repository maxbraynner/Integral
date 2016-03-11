package br.com.calculo;

public class Main {

	public static void main(String[] args) {
		double a = 0.0;
		double b = 1.0;
		int divisoes = 1_000_000;

		Integral integral = new Integral(a, b);
		integral.integrar(divisoes);
	}
	
}

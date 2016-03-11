package br.com.calculo;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Integral {

	private double a,b;
	
	public Integral(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public void integrar(int numeroDivisoes) {
		long time = System.currentTimeMillis();

		double largura = (b - a) / numeroDivisoes;
		
		Acumulador.addAcumulador( 0.5 * (funcao(a) + funcao(b)) );
		
		ThreadPoolExecutor threadPool = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		for (int i = 1; i < numeroDivisoes; i++) {
			// lança a thread para calcular
			threadPool.execute(new ThreadCalculo(a, largura, i));
		}
		
		// lança o monitor
		threadPool.execute(new ThreadMonitor(threadPool, largura, time));
		threadPool.shutdown();
	}
	
	private double funcao(double icognita) {
		return 1 / (1 + icognita * icognita); // função da integral
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

}


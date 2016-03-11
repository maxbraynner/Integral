package br.com.calculo;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadMonitor implements Runnable {

	private ThreadPoolExecutor service;
	private double largura;
	private long time;

	public ThreadMonitor(ThreadPoolExecutor service, double largura, long time) {
		this.service = service;
		this.largura = largura;
		this.time = time;
	}

	@Override
	public void run() {
		boolean executando = true;
		while (executando) {
			// só vai estar executando ela mesma
			if (service.getActiveCount() == 1) {
				executando = false;
			}
		}

		Acumulador.setAcumulador(Acumulador.getAcumulador() * largura);
		
		
		System.out.println("Terminou!!! Tempo de execução(ms): " + (System.currentTimeMillis() - time));
		
		System.out.printf("Valor do acumulador:    %.19f %n", Acumulador.getAcumulador());
		System.out.printf("Valor do acumulador x4: %.19f %n", Acumulador.getAcumulador()*4);
		System.out.printf("Valor de PI:            %.19f %n", Math.PI);
	}

}

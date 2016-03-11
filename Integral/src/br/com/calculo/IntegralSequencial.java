package br.com.calculo;

public class IntegralSequencial {
	static double f(double x) {
		return 1 / (1 + x * x);
	}

	static double integrate(double a, double b, int N) {
		double h = (b - a) / N;
		double sum = 0.5 * (f(a) + f(b));
		for (int i = 1; i < N; i++) {
			double x = a + h * i;
			sum = sum + f(x);
		}

		return sum * h;
	}

	public static void main(String[] args) {
		double a = 0.0;
		double b = 1.0;

		long time = System.currentTimeMillis();
		
		double result = integrate(a, b, 1000000);
		
		System.out.println("Terminou!!! Tempo de execução(ms): " + (System.currentTimeMillis() - time));
		
		System.out.printf("Resultado =      %.19f %n",  result);
		System.out.printf("Resultado*4 =    %.19f %n",  result * 4);
		System.out.printf("PI =             %.19f %n",  Math.PI);
		System.out.printf("PI - Resultado = %.19f %n",  Math.PI - (result * 4));
	}
}

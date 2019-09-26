package website.marcioheleno.av1;

import java.util.concurrent.TimeUnit;

public class Exercicio2 {

	public static void main(String[] args) {
		System.out.printf("Soma 1\n");
		System.out.printf("%10s%20s%10s\n", "n", "solucao", "tempo");
		for (int n = 0; n <= 100; n += 10) {
			soma1(n);
		}
		System.out.printf("Soma 2\n");
		System.out.printf("%10s%20s%10s\n", "n", "solucao", "tempo");
		for (int n = 0; n <= 100; n += 10) {
			soma2(n);
		}
		System.out.printf("Soma 3\n");
		System.out.printf("%10s%20s%10s\n", "n", "solucao", "tempo");
		for (int n = 0; n <= 100; n += 10) {
			soma3(n);
		}
	}

	static void soma1(long n) {
		double inicio = System.currentTimeMillis();
		long soma = 0;
		for (long i = 1; i <= n; i++) {
			long termo = 0;
			for (long j = 1; j <= i; j++) {
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				termo = termo + j;
			}
			soma = soma + termo;
		}
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%10d%20d%10.0f\n", n, soma, tempo);
	}

	static void soma2(long n) {
		double inicio = System.currentTimeMillis();
		long soma = 0;
		for (long i = 1; i <= n; i++) {
			long termo = ((1 + i) * i) / 2;
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			soma = soma + termo;
		}
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%10d%20d%10.0f\n", n, soma, tempo);
	}

	static void soma3(long n) {
		double inicio = System.currentTimeMillis();
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long soma = n * (n + 1) * (n + 2) / 6;
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%10d%20d%10.0f\n", n, soma, tempo);
	}

}

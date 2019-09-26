package website.marcioheleno.av1;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe o valor de n: ");
		long n = scanner.nextLong();
		scanner.close();
		// soma1(n);
		soma2(n);
		soma3(n);
	}

	static void soma1(long n) {
		System.out.println("soma1");
		System.out.printf("%10s%20s%10s\n", "n", "solucao", "tempo");
		double inicio = System.currentTimeMillis();
		long soma = 0;
		for (long i = 1; i <= n; i++) {
			long termo = 0;
			for (long j = 1; j <= i; j++) {
				termo = termo + j;
			}
			soma = soma + termo;
		}
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%10d%20d%10.0f\n", n, soma, tempo);
	}

	static void soma2(long n) {
		System.out.println("soma2");
		System.out.printf("%10s%20s%10s\n", "n", "solucao", "tempo");
		double inicio = System.currentTimeMillis();
		long soma = 0;
		for (long i = 1; i <= n; i++) {
			long termo = ((1 + i) * i) / 2;
			soma = soma + termo;
		}
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%10d%20d%10.0f\n", n, soma, tempo);
	}

	static void soma3(long n) {
		System.out.println("soma3");
		System.out.printf("%10s%20s%10s\n", "n", "solucao", "tempo");
		double inicio = System.currentTimeMillis();
		long soma = n * (n + 1) * (n + 2) / 6;
		double fim = System.currentTimeMillis();
		double tempo = fim - inicio;
		System.out.printf("%10d%20d%10.0f\n", n, soma, tempo);
	}

}

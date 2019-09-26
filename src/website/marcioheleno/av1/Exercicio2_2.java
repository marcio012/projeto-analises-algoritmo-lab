package website.marcioheleno.av1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Exercicio2_2 {

	public static void main(String[] args) {

		int n = 1000;
		int[] A;
		A = criaVetorAleatorio(n);
		double inicio, fim, tempo;
		inicio = System.currentTimeMillis();
		metodo(A, n);
		fim = System.currentTimeMillis();
		tempo = fim - inicio;
		System.out.printf("Tempo: %1.0f", tempo);
	}

	static double metodo(int[] vetor, int n) {
		double v = 1;
		for (int i = 0; i < n; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			v = v * vetor[i];
			if (v == 0) {
				return 0;
			}
		}
		return v;
	}

	static int[] criaVetorAleatorio(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(100);
		}
		return A;
	}

}

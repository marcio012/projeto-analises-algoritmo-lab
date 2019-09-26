package website.marcioheleno.av1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Exercicio4 {

	public static void main(String[] args) {
		int[] A, B;
		double inicio1, fim1, tempo1;
		double inicio2, fim2, tempo2;

		System.out.println("Ordenado crescente");
		System.out.printf("%5s%10s%10s\n", "n", "insertion", "merge");
		System.out.println("-------------------------");
		for (int n = 0; n <= 100; n += 5) {
			A = criaVetorCrescente(n);
			B = A.clone();
			inicio1 = System.currentTimeMillis();
			A = insertionSort(A);
			fim1 = System.currentTimeMillis();
			tempo1 = fim1 - inicio1;
			inicio2 = System.currentTimeMillis();
			B = mergeSort(B, 0, n - 1);
			fim2 = System.currentTimeMillis();
			tempo2 = fim2 - inicio2;
			System.out.printf("%5d%10.0f%10.0f\n", n, tempo1, tempo2);
		}

		System.out.println("Ordenado decrescente");
		System.out.printf("%5s%10s%10s\n", "n", "insertion", "merge");
		System.out.println("-------------------------");
		for (int n = 0; n <= 100; n += 5) {
			A = criaVetorDecrescente(n);
			B = A.clone();
			inicio1 = System.currentTimeMillis();
			A = insertionSort(A);
			fim1 = System.currentTimeMillis();
			tempo1 = fim1 - inicio1;
			inicio2 = System.currentTimeMillis();
			B = mergeSort(B, 0, n - 1);
			fim2 = System.currentTimeMillis();
			tempo2 = fim2 - inicio2;
			System.out.printf("%5d%10.0f%10.0f\n", n, tempo1, tempo2);
		}

		System.out.println("Ordenado aleatório");
		System.out.printf("%5s%10s%10s\n", "n", "insertion", "merge");
		System.out.println("-------------------------");
		for (int n = 0; n <= 100; n += 5) {
			A = criaVetorAleatorio(n);
			B = A.clone();
			inicio1 = System.currentTimeMillis();
			A = insertionSort(A);
			fim1 = System.currentTimeMillis();
			tempo1 = fim1 - inicio1;
			inicio2 = System.currentTimeMillis();
			B = mergeSort(B, 0, n - 1);
			fim2 = System.currentTimeMillis();
			tempo2 = fim2 - inicio2;
			System.out.printf("%5d%10.0f%10.0f\n", n, tempo1, tempo2);
		}
	}

	static int[] criaVetorCrescente(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] + randomGenerator.nextInt(10);
		}
		return A;
	}

	static int[] criaVetorDecrescente(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		if (n != 0) {
			A[0] = Integer.MAX_VALUE;
		}
		for (int i = 1; i < n; i++) {
			A[i] = A[i - 1] - randomGenerator.nextInt(10);
		}
		return A;
	}

	static int[] criaVetorAleatorio(int n) {
		Random randomGenerator = new Random();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = randomGenerator.nextInt(100 * n);
		}
		return A;
	}

	static void imprimeVetor(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	static int[] insertionSort(int[] A) {
		for (int j = 1; j < A.length; j++) {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int chave = A[j];
			int i = j - 1;
			while (i >= 0 && A[i] > chave) {
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				A[i + 1] = A[i];
				i--;
			}
			A[i + 1] = chave;
		}
		return A;
	}

	static int[] mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
		return A;
	}

	static void merge(int[] A, int p, int q, int r) {
		int i, j;
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for (i = 0; i < n1; i++) {
			L[i] = A[p + i];
		}
		for (j = 0; j < n2; j++) {
			R[j] = A[q + j + 1];
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		for (int k = p; k <= r; k++) {
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (L[i] <= R[j]) {
				A[k] = L[i++];
			} else {
				A[k] = R[j++];
			}
		}
	}

}

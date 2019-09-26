package website.marcioheleno.av1;

public class Questao4Trabalho {

	public static void main(String[] args) {
		/*
		 * Seja um vetor A de n elementos inteiros e positivos. É possível determinar
		 * a quantidade de elementos ímpares do vetor em O(n), percorrendo-se os
		 * elementos do vetor de forma iterativa. Alternativamente, pode-se utilizar um
		 * método de divisão-e-conquista. Faça uma função para determinar a
		 * quantidade de elementos ímpares do vetor. O algoritmo deve recursivamente
		 * dividir o vetor em duas partes de tamanhos aproximadamente iguais até se
		 * chegar a um caso trivial. Determine e resolva a equação de recorrência
		 * para o seu algoritmo. O algoritmo recursivo é assintoticamente mais
		 * eficiente do que o algoritmo iterativo? Obs: para encontrar o ponto médio,
		 * utilize m = (i + f)/2, onde i e f são, respectivamente, os índices inicial
		 * e final do subvetor.
		 */

		int vet1[] = new int[10];
		int qtdImpar = 0;
		for (int i = 0; i < vet1.length; i++) {
			if (i % 2 != 0) {
				System.out.println("é impar");
				qtdImpar++;
			} else {
				System.out.println("é par");
			}
		}
//        System.out.println(qtdImpar);
//        int vet2[] = new int[10];

		int[] a = { 1, 2, 3, 120, 5, 6, 7, 8, 9, 100 };
		int v = 1;
//        System.out.println("Numeros Impar: " + VetImpar(a, 0, a.length - 1));

	}

	public static int VetImpar(int[] a, int inicio, int fim) {
		if (inicio == fim) { // apenas um elemento, a soma é ele próprio
			return a[inicio];
		} else { // Meu problema ainda pode ser dividido em pedaços menores
			int meio = (inicio + fim) / 2;
			int v1 = VetImpar(a, inicio, meio);
			int v2 = VetImpar(a, meio + 1, fim);

			if (v1 % 2 != 0) {
				System.out.println(v1);
			}

			if (v2 % 2 != 0) {
				System.out.println(v2);
			}
			// Agora, basta somar os retornos e retornar a soma =]
			return 0;
		}
	}

}

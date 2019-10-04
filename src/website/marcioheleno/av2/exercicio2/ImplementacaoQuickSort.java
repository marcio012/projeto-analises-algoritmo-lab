package website.marcioheleno.av2.exercicio2;

import java.util.Random;

public class ImplementacaoQuickSort {

    public static void main(String[] args) {
        int [] v = {3, 8, 10, 7, 2, 4};
        imprime(v);
        quickSort(v, 0, v.length - 1);
        System.out.println("Alinhado");
        imprime(v);
    }

    private static void quickSort(int[] A, int esq, int dir) {
        if (esq < dir) {
            int q = partition(A, esq, dir);
            quickSort(A, esq, q - 1);
            quickSort(A, q + 1, dir);
        }
    }

    private static int partition(int[] A, int p, int r) {
        int pivo = A[r]; // length
        int x = p - 1;
        for (int i = p; i < r; i++) {
            if (A[i] <= pivo) {
                x++;
                troca(A, x, i);
            }
        }
        troca(A, x + 1, r);
        return x + 1;
    }

    private static void troca(int[] numbers, int j, int k) {
        int temp = numbers[j];
        numbers[j] = numbers[k];
        numbers[k] = temp;
    }

    static void imprime (int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.print("\n");
    }
}

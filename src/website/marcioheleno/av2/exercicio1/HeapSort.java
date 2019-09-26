package website.marcioheleno.av2.exercicio1;

import java.util.Random;

public class HeapSort {

    public static void main(String[] args) {
        int[] A = {86, 78, 36, 61, 67, 34, 58, 42, 35, 59, 62, 28, 60, 37, 12};
        System.out.println("Vetor A:");
        imprimeVetor(A);
        System.out.println("Heap A:");
        imprimeHeap(A);
        System.out.println("Left A(2):");
        System.out.println(A[left(2)]);
        System.out.println("Right A(4):");
        System.out.println(A[right(4)]);
        maxheapfy(A, 2);
        imprimeHeap(A);
        //int[] B = criaVetorAleatorio(15);
        //System.out.println("------------------------------------------------------------------------------------------");
        //System.out.println("Vetor B:");
        //imprimeVetor(B);
        //imprimeHeap(B);
    }

    static int left (int i) {
        // to do
        return (2 * i) + 1;
    }

    static int right (int i) {
        // to do
        return (2 * i) + 2;
    }

    static void maxheapfy (int[] V, int i) {
        int l = V[left(i)];
        int r = V[right(i)];
        int m = V[i];

        if (l >= V[i] && V.length > i) {
            m = l;
        } else {
            m = i;
        }

        if (r >= V[i] && V.length > i) {
            m = r;
        } else {
            m = i;
        }

    }

    static void buildmaxheap (int[] V) {
        // to do
    }

    static int[] criaVetorAleatorio (int n) {
        Random randomGenerator = new Random();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = randomGenerator.nextInt(10 * n);
        }
        return A;
    }

    static void imprimeVetor (int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%6d", A[i]);
        }
        System.out.print("\n\n\n");
    }

    // Todo so impressão do heap
    static void imprimeHeap (int[] A) {
        int h = (int) (Math.log(A.length) / Math.log(2));
        int espacos = calculaEspacos(h);
        for (int i = 0; i <= h; i++) {
            for (int j = 1; j <= Math.pow(2, i); j++) {
                if ((int) (Math.pow(2, i)) - 1 + (j-1) >= A.length) break;
                imprimeEspacos(espacos);
                System.out.printf("%3d", A[(int) (Math.pow(2, i)) - 1 + (j-1)]);
                imprimeEspacos(espacos);
                if (j < Math.pow(2, i)) {
                    System.out.printf("%3s", "");
                }
            }
            espacos = (espacos - 3) / 2;
            System.out.println();
        }
    }

    static int calculaEspacos (int h) {
        int espacos = 3;
        for (int i = 1; i <= h; i++) {
            espacos = 2 * espacos + 3;
        }
        return espacos;
    }

    static void imprimeEspacos (int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(" ");
        }
    }


}

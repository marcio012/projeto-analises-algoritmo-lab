package website.marcioheleno.av2.exercicio1;

import java.util.Random;

public class HeapSort {

    public static void main(String[] args) {
        int[] A = {86, 78, 36, 61, 67, 34, 58, 42, 35, 59, 62, 28, 60, 37, 12};
//        int[] A = {77, 42, 26, 43, 9 ,7 };
        System.out.println("Vetor A:");
        imprimeVetor(A);
        System.out.println("Heap A:");
        imprimeHeap(A);
        System.out.println("Left A(2):");
//        System.out.println(A[left(2)]);
        System.out.println("Right A(4):");
//        System.out.println(A[right(4)]);
        System.out.println("Aplicando MaxHeapFy na raiz do vetor:");
        maxheapfy(A, 0);
        imprimeHeap(A);
        System.out.println("=======================================");
        System.out.println("Aplicando MaxHeapFy no indice 2 do vetor:");
        maxheapfy(A, 2);
        imprimeHeap(A);

        System.out.println("=======================================");
        System.out.println("Aplicando MaxHeapFy no indice 2 e no indice 5 do vetor:");
        maxheapfy(A, 2);
        maxheapfy(A, 5);
        imprimeHeap(A);

        System.out.println("=======================================");
        System.out.println("Aplicando MaxHeapFy no indice 5 e no indice 2 do vetor:");
        maxheapfy(A, 2);
        maxheapfy(A, 5);
        imprimeHeap(A);
//        int[] B = criaVetorAleatorio(15);
//        System.out.println("------------------------------------------------------------------------------------------");
//        System.out.println("Vetor B:");
//        imprimeVetor(B);
//        imprimeHeap(B);
//
//        System.out.println("=======================================");
//        System.out.println("Aplicando o procedimento de buildMaxHeap no vetor B:");
//        buildmaxheap(B);
//        imprimeHeap(B);


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
        int l = left(i);
        int r = right(i);
        int maior = i;

        if (l < V.length && V[l] > V[i]) {
            maior = l;
        } else {
            maior = i;
        }

        if (r < V.length && V[r] > V[maior]) {
            maior = r;
        }

        if (maior != i) {
            int trocar = V[i];
            V[i] = V[maior];
            V[maior] = trocar;
            maxheapfy(V, maior);
        }
    }

    static void buildmaxheap (int[] V) {
        // to do
        for (int i = V.length / 2; i >= 1; i--) {
            maxheapfy(V, i - 1);
            System.out.println("============================================");
            imprimeHeap(V);
        }
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

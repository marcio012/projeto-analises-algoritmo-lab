package website.marcioheleno.av2.exercicio2;

import java.util.Random;

public class Exercicio2 {

    static class Crianca {
        public String nome;
        public int idade;
        public char sexo;

        public Crianca() {
            Random randomGenerator = new Random();
            nome = "";
            nome += (char)('A' + randomGenerator.nextInt(26));
            for (int i = 2; i <= 10; i++) {
                nome += (char) ('a' + randomGenerator.nextInt(26));
            }
            idade = 6 + randomGenerator.nextInt(11);
            sexo = (randomGenerator.nextInt(2) == 0) ? 'M' : 'F';
        }
    }

    public static void main(String[] args) {
        int n = 20;
        Crianca[] criancas = new Crianca[n];
        for (int i = 0; i < criancas.length; i++) {
            criancas[i] = new Crianca();
        }
        imprime(criancas);
//        organizaSexo (criancas);
//        imprime(criancas);
        organizaIdadeLocal(criancas);
        imprime(criancas);
        //organizaIdadeNaoLocal (criancas);

    }

    static void organizaSexo (Crianca[] A) {
        char pivo = 'F'; // pivo
        int x = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i].sexo == pivo) {
                x++;
                troca(A, x, i);
            }
        }
    }

    private static void troca(Crianca[] A, int j, int k) {
        Crianca temp = A[j];
        A[j] = A[k];
        A[k] = temp;
    }

    static void organizaIdadeLocal (Crianca[] A) {
        quickSort(A,0,A.length - 1 );
//        boolean pivo1; // pivo 06 a 10
//        boolean pivo2; // pivo 11 a 14
//        boolean pivo3; // pivo 15 a 16
//        int x = -1;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i].idade <= 6 && A[i].idade <= 10) {
//                x++;
//                troca(A, x, i);
//            }
//            else if (A[i].idade <= 11 && A[i].idade <=14) {
//                x++;
//                troca(A, x, i);
//            }
//            else {
//                x++;
//                troca(A, x, i);
//            }
//        }
    }

    static void organizaIdadeNaoLocal (Crianca[] A) {
        //to do
        Crianca[] B = A.clone();
    }

    static void quickSort(Crianca[] A, int esq, int dir) {
        if (esq < dir) {
            int q = particao(A, esq, dir, 14);
            quickSort(A, esq, q -1);
            quickSort(A, q + 1, dir);
        }
        return;
    }

    private static int particao(Crianca[] A, int esq, int dir, int pivo) {
//        int pivo = A[dir].idade; // length
        int x = esq - 1;
        for (int i = esq; i < dir; i++) {
            if (A[i].idade <= pivo - 4) {
                x++;
                troca(A, x, i);
            }
            if (A[i].idade > pivo - 4 && A[i].idade <= 14) {
                x++;
                troca(A, x, i);
            }
            if (A[i].idade > pivo) {
                x++;
                troca(A, x, i);
            }

        }
        troca(A, x + 1, dir);
        return x + 1;
    }

    private static int partition2(Crianca[] A, int p, int r, int s, int t) { // r = 10 s = 14 t = 15
        int pivo1 = r; // length 10
        int pivo2 = s; // length 14
        int pivo3 = t; // length 15
        int x = p - 1;
        for (int i = p; i < r; i++) {
            if (A[i].idade >= pivo1) {
                x++;
                troca(A, x, i);
            }
            if (A[i].idade > pivo1 && A[i].idade <= pivo2 ) {
                x++;
                troca(A, x, i);
            }
            if (A[i].idade >= pivo3) {
                x++;
                troca(A, x, i);
            }
        }
        troca(A, x + 1, r);
        return x + 1;
    }

    static void imprime (Crianca[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%d | %15s | %7d | %7c |\n", i, A[i].nome, A[i].idade, A[i].sexo);
        }
        System.out.print("\n\n\n");
    }
}

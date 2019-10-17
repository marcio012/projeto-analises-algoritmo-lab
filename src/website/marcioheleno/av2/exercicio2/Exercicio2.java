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
        System.out.println("Organizando pelo sexo");
        organizaSexo (criancas);
        imprime(criancas);

        System.out.println("Organizando pela idade local");
        organizaIdadeLocal(criancas);
        imprime(criancas);

        System.out.println("Organizando pela idade não local");
        organizaIdadeNaoLocal (criancas);
        imprime(criancas);

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
        int x = -1;
        for (int i = 0; i < A.length; i++) {
            if ( A[i].idade <= 10 ) {
                x++;
                troca( A, x, i );
            }
        }

        for (int i = x + 1; i < A.length; i++) {
            if (A[i].idade <=14) {
                x++;
                troca(A, x, i);
            }
        }
    }

    static void organizaIdadeNaoLocal (Crianca[] A) {
        Crianca[] B = A.clone();
        int k = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i].idade <= 10) {
                A[k] = B[i];
                k++;
            }
        }
        for (int i = 0; i < B.length; i++) {
			if (B[i].idade > 10 && B[i].idade <= 14) {
				A[k] = B[i];
				k++;
			}
		}
		for (int i = 0; i < B.length; i++) {
			if (B[i].idade > 14) {
				A[k] = B[i];
				k++;
			}
		}
    }


    static void imprime (Crianca[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%d | %15s | %7d | %7c |\n", i, A[i].nome, A[i].idade, A[i].sexo);
        }
        System.out.print("\n\n\n");
    }
}

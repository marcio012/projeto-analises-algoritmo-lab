package website.marcioheleno.av3.lab01;

import java.util.Random;

public class Exercicio1 {

    static class Aluno {
        public String matricula;
        public String nome;
        public int creditos;

        public Aluno() {
            Random randomGenerator = new Random();
            matricula = "";
            for (int i = 1; i <= 10; i++) {
                matricula += (char) ('0' + randomGenerator.nextInt(10));
            }
            nome = "";
            nome += (char)('A' + randomGenerator.nextInt(26));
            for (int i = 2; i <= 10; i++) {
                nome += (char) ('a' + randomGenerator.nextInt(26));
            }
            creditos = randomGenerator.nextInt(201);
        }
    }

    public static void main(String[] args) {
        int n = 40;
        Aluno[] alunos = new Aluno[n];
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno();
        }

        imprime(alunos);
        alunos = ordenaCreditos(alunos);
        imprime(alunos);
        alunos = ordenaMatricula(alunos);
        imprime(alunos);
        alunos = ordenaNome(alunos);
        imprime(alunos);
    }

    static Aluno[] ordenaCreditos (Aluno[] A) {
        // to do
        // credito maximo 200
        int creditoMaximo = 200;
        Aluno[] B = new Aluno[A.length];
        int[] C = new int[creditoMaximo + 1];

        for (int j = 0; j < A.length; j++){
            int creditosCorrente = A[j].creditos;
            C[creditosCorrente] += 1;
        }

        for (int i = 1; i < C.length; i++)
            C[i] = C[i] + C[i - 1];

        for (int j = A.length - 1; j >= 0; j--) {
            Aluno aluno = A[j];
            int creditos = aluno.creditos;
            int posicao = C[creditos] - 1;

            B[posicao] = aluno;
            C[creditos] = C[creditos] - 1;
        }

        return B;
    }


    static Aluno[] ordenaMatricula (Aluno[] A) {
        // to do
        int tamanhoMatricula = 10;
        for (int d = tamanhoMatricula -1; d >= 0; d--) {
            Aluno[] B = new Aluno[A.length];
            int[] C = new int[tamanhoMatricula + 1];


            for (int j = 0; j < A.length; j++){
                int digito = (int) A[j].matricula.charAt(d) - '0';
                C[digito] += 1;
            }

            for (int i = 1; i < C.length; i++)
                C[i] = C[i] + C[i - 1];

            for (int j = A.length - 1; j >= 0; j--) {
                Aluno aluno = A[j];
                int digito = (int) A[j].matricula.charAt(d) - '0';
                int posicao = C[digito] - 1;

                B[posicao] = aluno;
                C[digito] = C[digito] - 1;
            }
            A = B;
        }
        return A;

    }

    static Aluno[] ordenaNome (Aluno[] A) {
        // to do


        int tamanhoNome = A.length;
        int[] C = new int[A[0].nome.length()];

        for (int d = tamanhoNome -1; d >= 0; d--) {
            Aluno[] B = new Aluno[A.length];


            for (int j = 0; j < A.length; j++){
                int digito = (int) A[j].nome.charAt(d) - 'a';
                C[digito] += 1;
            }

            for (int i = 1; i < C.length; i++)
                C[i] = C[i] + C[i - 1];

            for (int j = A.length - 1; j >= 0; j--) {
                Aluno aluno = A[j];
                int digito = (int) A[j].nome.charAt(d) - 'a';
                int posicao = C[digito] - 1;

                B[posicao] = aluno;
                C[digito] = C[digito] - 1;
            }
            A = B;
        }
        return A;
    }

    static void imprime (Aluno[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%-15s%-15s%10d\n", A[i].matricula, A[i].nome, A[i].creditos);
        }
        System.out.print("\n\n\n");
    }

}

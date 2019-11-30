package website.marcioheleno.av3.lab02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exercicio1 {

    static class Grafo {
        public int[][] m;
        public Grafo(int size) {
            Random randomGenerator = new Random();
            m = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (randomGenerator.nextDouble() <= 0.7) {
                        m[i][j] = 1;
                        m[j][i] = 1;
                    }
                }
            }
            System.out.printf("Matriz de adjacências:\n");
            for (int i = 0; i < size; i++) {
                System.out.printf("--");
            }
            System.out.printf("\n");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.printf("%2d", m[i][j]);
                }
                System.out.printf("\n");
            }
            for (int i = 0; i < size; i++) {
                System.out.printf("--");
            }
            System.out.printf("\n\n");
        }
    }
    public static void main(String[] args) {
        int n = 5;
        Integer[] vertices = new Integer[n];
        System.out.printf("Vértices:\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("--");
        }
        System.out.printf("\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d", i);
            vertices[i] = i;
        }
        System.out.printf("\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("--");
        }
        System.out.printf("\n\n");
        Grafo g = new Grafo(n);
        List<Integer> candidata = Arrays.asList(vertices);
        Collections.shuffle(candidata);
        System.out.printf("Solução candidata:\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("--");
        }
        System.out.printf("\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d", candidata.get(i));
        }
        System.out.printf("\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("--");
        }
        System.out.printf("\n\n");

        if (viavel(g, candidata)) {
            System.out.println("É um ciclo hamiltoniano!");
        } else {
            System.out.println("Não é um ciclo hamiltoniano!");
        }

        if (hamiltoniano(g)) {
            System.out.println("Possui ciclo hamiltoniano!");
        } else {
            System.out.println("Não possui ciclo hamiltoniano!");
        }
    }
    static boolean viavel(Grafo g, List<Integer> candidata) {
        // todo - checar se todas as arestas da solucao candidata fazem parte do grafo

        for (int i = 0; i < candidata.size();  i++) {
            if (g.m[i][i + 1] == candidata.get(i)) {
                return true;
            }
        }

        return true;
    }
    static boolean hamiltoniano(Grafo g) {
        // todo - gerar todas as permutacoes dos vertices e checar se alguma é viável
        return true;
    }
}
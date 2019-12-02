package website.marcioheleno.av3.lab02;

import java.util.*;

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

        for (int i = 0; i < g.m.length - 1 ;  i++) {
            if(g.m[candidata.get(i)][candidata.get(i+1)] == 0){
                return false;
            }
        }
        if(g.m[candidata.size()-1][candidata.get(0)] == 0){
            return false;
        }

        return true;
    }
    static boolean hamiltoniano(Grafo g) {
        // todo - gerar todas as permutacoes dos vertices e checar se alguma é viável
        for (int i = 0; i < g.m.length; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.printf("%2d", g.m[i][j]);
            }
        }
        System.out.println("");
        return true;
    }

//    static public Grafo permute( List<Integer> a ) {
//        // Validação de entrada
//        if( a == null )
//            throw new IllegalArgumentException( "A entrada não pode ser nula" );
//
//        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<ArrayList<Integer>>();
//
//        if( a.size() == 1 ){
//            toReturn.add( new ArrayList<Integer>(a) );
//            return toReturn;
//        }
//
//        // Loop em todos os elementos.
//        for( int i = 0 ; i < a.size(); i++ ){
//            int current = a.get( i );
//            ArrayList<Integer> tmp = new ArrayList<Integer>(a);
//            tmp.remove( i );
//
//            // Chame recursivamente com subconjunto
//            ArrayList<ArrayList<Integer>> res = permute(tmp);
//
//            // Crie o resultado da sub-lista retornada
//            for( int j = 0 ; j < res.size() ; j++ ){
//                ArrayList<Integer> toAdd = new ArrayList<Integer>();
//                toAdd.add( current );
//                toAdd.addAll( res.get( j ) );
//
//                toReturn.add( toAdd );
//            }
//        }
//
//        // devolver os resultados
//        return toReturn;
//    }


}

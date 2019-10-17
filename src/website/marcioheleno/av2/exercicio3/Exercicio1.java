package website.marcioheleno.av2.exercicio3;

public class Exercicio1 {

    static int[] qtde;

    public static void main(String[] args) {
        int troco = 18;
        int[] padrao = {1, 6, 10};
        double inicio, fim, tempo;
        int q;

        inicio = System.currentTimeMillis();
        q = trocoDinamico(troco, padrao);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        if (q == Integer.MAX_VALUE) {q = -1;}
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Dinâmico", q, tempo);

        inicio = System.currentTimeMillis();
        qtde = new int[troco+1];
        for (int t = 0; t <= troco; t++) {
            qtde[t] = -1;
        }
        q = trocoMemoization(troco, padrao);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        if (q == Integer.MAX_VALUE) {q = -1;}
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Memoization", q, tempo);

        inicio = System.currentTimeMillis();
        q = trocoRecursivo(padrao, troco);
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        if (q == Integer.MAX_VALUE) {q = -1;}
        System.out.printf("%-15s%10s%10s\n", "Método", "Qtde", "Tempo");
        System.out.printf("%-15s%10d%10.2f\n\n", "Recursivo", q, tempo);
    }

    static int trocoRecursivo(int[] padrao, int troco ) {

        if (troco != 0) {
            int qMin = Integer.MAX_VALUE;
            for (int i = 0; i < padrao.length; i++) {
                if (troco - padrao[i] >= 0) {
                    int q = trocoRecursivo( padrao, troco - padrao[i]) + 1;
                    if (q < 0) {q = Integer.MAX_VALUE;}
                    if (q < qMin) {qMin = q;}
                }
            }
            return qMin;
        }
        return 0;
    }

    static int trocoMemoization(int troco, int[] padrao) {

//        qtde[0] = 0;
//
//        if (troco != 0) {
//
//            int qMin = Integer.MAX_VALUE;
//
//            for (int i = 0; i < padrao.length; i++) {
//                if (troco - padrao[i] >= 0) {
//                    int q = trocoMemoization(troco - padrao[i], padrao) + 1;
//                    if (q < 0) {q = Integer.MAX_VALUE;}
//                    if (q < qMin) {qMin = q;}
//                }
//            }
//
//            qtde[0] = troco;
//
////            System.out.printf("Modedas: " + qtde[0]);
//
//            return qMin;
//
//        }
        return 0;
    }

    static int trocoDinamico(int troco, int[] padrao) {
        int[] q = new int[troco + 1];
        int[] c = new int[troco + 1];
        for (int t = 1; t <= troco; t++) {
            q[t] = Integer.MAX_VALUE;
            for (int p = 0; p < padrao.length; p++) {
                // to do
            }
        }
//        imprimeTroco(c, troco);
        System.out.println();
        return q[troco];
    }

    static void imprimeTroco(int[] c, int troco) {
        for (int i = 0; i < c.length; i++) {
            System.out.printf("Moeda do troco: " + c[i] + "troco: " + troco);
        }
    }


}

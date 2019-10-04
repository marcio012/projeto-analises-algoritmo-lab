package website.marcioheleno.av2.exercicio2;

public class PartitionApp {

    public static void main(String[] args) {
        int max = 16;
        Partition array = new Partition(max);

        for (int i = 0; i < max ; i++) {
            int n = (int) (Math.random() * 199);
            array.inserirElemento(n);
        }

        array.imprimeArray();

        long pivor = 99;
        System.out.println("O Pivor é :" + pivor);

        int tamanhoArray = array.tamanho();
        int partitioon = array.partitionIt(0, tamanhoArray -1, pivor);

        System.out.println(", Partition is at a index " + partitioon);

        array.imprimeArray();
    }
}

package website.marcioheleno.av2.exercicio2;

public class Partition {

    private long[] array;
    private int elementos;

    public Partition(int tamanho) {
        this.array = new long[tamanho];
        this.elementos = 0;
    }

    public void inserirElemento(long elemento) {
        this.array[elementos] = elemento;
        elementos ++;
    }

    public int tamanho() {
        return this.elementos;
    }

    public void imprimeArray() {
        System.out.print("Arranjo = ");
        for (int i = 0; i < elementos ; i++)
            System.out.print(this.array[i] + " ");
        System.out.println("");
    }

    public int partitionIt(int esq, int dir, long pivot) {
        int l = esq - 1;
        int r = dir + 1;

        while (true) {

            while (l < dir && this.array[++l] < pivot);

            while (r > esq && this.array[--r] > pivot);

            if (l >= r)
                break;
            else
                swap(l,r);
        }
        return l;
    }

    private void swap(int l, int r) {
        long t = this.array[l];
        this.array[l] = this.array[r];
        this.array[r] = t;
    }
}

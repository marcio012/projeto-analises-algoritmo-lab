package website.marcioheleno.av1;

public class Exercicio5 {

	public static void main(String[] args) {
		System.out.println("Imprime1");
		imprime1(4);
		System.out.println("Imprime2");
		imprime2(4);
		System.out.println("Imprime3");
		imprime3(4);
	}

	static void imprime1(int n) {
		if (n != 1) {
			System.out.println(n);
			imprime1(n / 2);
		} else {
			System.out.println(1);
		}
	}

	static void imprime2(int n) {
		if (n != 1) {
			System.out.println(n);
			imprime2(n / 2);
			imprime2(n / 2);
		} else {
			System.out.println(1);
		}
	}

	static void imprime3(int n) {
		if (n != 1) {
			System.out.println(n);
			imprime3(n / 2);
			imprime3(n / 2);
			imprime3(n / 2);
			imprime3(n / 2);
		} else {
			System.out.println(1);
		}
	}

}

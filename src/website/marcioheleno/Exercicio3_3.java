package website.marcioheleno;

import java.util.Scanner;

public class Exercicio3_3 {

	public static void main(String[] args) {

		System.out.println("Informe o tamanho do array : ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int finalfor2 = 0;
		int finalfor1 = 0;
		System.out.println("inicio");
		for (int i = 1; i <= n * n; i++) {
			System.out.println("Valor final do 1 for: " + i);
			finalfor1 += i;
			for (int j = 1; j <= i; j++) {
				finalfor2 += j;
				System.out.println("Valor final do 2 for: " + i);
			}
		}
		in.close();
		System.out.println("interacoes no 1 for: " + finalfor1);
		System.out.println("interacoes no 2 for: " + finalfor2);
		System.out.println("fim");

	}

}

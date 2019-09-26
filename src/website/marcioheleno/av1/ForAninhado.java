package website.marcioheleno.av1;

public class ForAninhado {

	public static void main(String[] args) {

		int sum = 0;
		int vet1[] = new int[10];
		int vet2[] = new int[10];
		int vet3[] = new int[1];

		for (int i = 0; i < vet1.length; i++) {
			for (int j = i; j < vet2.length * vet2.length; j++) {
				for (int k = 0; k < vet3.length; k++) {
					sum = sum + 10;
				}
			}
		}
		System.out.println(sum);

	}

}

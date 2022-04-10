import java.util.Scanner;
public class Triangle {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Insert n: ");
		int n = keyboard.nextInt();
		int k = 0;
		for(int i = 1; i <= n; i++, k = 0) {
			for(int space = 1; space <= n - i; space++) {
				System.out.print(" ");
			};
			while (k != 2 * i - 1) {
			   System.out.print("*");
			   ++k;
			}
			System.out.println();
		}
	}
}

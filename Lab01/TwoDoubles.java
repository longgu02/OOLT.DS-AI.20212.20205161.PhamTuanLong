import java.util.Scanner;
public class TwoDoubles {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Insert Number 1: ");
        double num1 = Double.parseDouble(keyboard.nextLine());
        System.out.print("Insert Number 2: ");
        double num2 = Double.parseDouble(keyboard.nextLine());
        double sum = 0, diff = 0, prod = 0, quotient = 0;
        sum = num1 + num2;
        diff = java.lang.Math.abs(num1 - num2);
        prod = num1 * num2;
        quotient = num1 / num2;
        System.out.print("Sum: " + sum + " | Diff: " + diff + " | Product: " + prod + " | Quotient: " + quotient);
    }
}

import java.util.Scanner;
public class Mathematics {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. First degree\n2. System of first degree\n3. Second degree");
        int choice = keyboard.nextInt();
        switch (choice){
            case 1:
                float a1 = keyboard.nextFloat();
                float b1 = keyboard.nextFloat();
                double result = 0;
                if(a1 == 0){
                    if(b1 == 0){
                        System.out.println("Infinitely root");
                    }else{
                        System.out.println("Impossible equation");
                    };
                    break;
                };
                result = -b1/a1;
                System.out.println("Result: " + result);
                break;
            case 2:
                break;
            case 3:
                System.out.print("Insert a: ");
                float a = keyboard.nextFloat();
                System.out.print("Insert b: ");
                float b = keyboard.nextFloat();
                System.out.print("Insert b: ");
                float c = keyboard.nextFloat();
                if (a == 0) {
                    if (b == 0) {
                        System.out.println("Impossible equation!");
                    } else {
                        System.out.println("1 roots: "
                                + "x = " + (-c / b));
                    }
                    return;
                }
                // tính delta
                float delta = b*b - 4*a*c;
                float x1;
                float x2;
                // tính nghiệm
                if (delta > 0) {
                    x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
                    x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
                    System.out.println("2 roots: "
                            + "x1 = " + x1 + " và x2 = " + x2);
                } else if (delta == 0) {
                    x1 = (-b / (2 * a));
                    System.out.println("1 roots: "
                            + "x1 = x2 = " + x1);
                } else {
                    System.out.println("Impossible equation!");
                }
                break;
        }
    }
}

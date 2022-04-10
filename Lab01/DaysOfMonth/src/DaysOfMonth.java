import java.util.Scanner;
public class DaysOfMonth {
	public static void main(String args[]) {
		String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String[] monthAbbre = {"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec." };
		int[] DayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] monthNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10", "11", "12"};
		boolean valid = false;
		while(!valid) {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter month: ");
			String inputMonth = keyboard.nextLine();
			System.out.print("Enter year: ");
			int year = keyboard.nextInt();
			for(int i = 0; i < 12; i++) {
				if(inputMonth.equals(month[i])|| inputMonth.equals(monthAbbre[i]) || inputMonth.equals(monthAbbre[i].substring(0,3)) || inputMonth == monthNum[i] ) {
					if(i == 1 && year%4 == 0) {
						if(year % 100 == 0) {
							if(year % 400 == 0) {
								System.out.println("29");
								valid = true;
								break;
							}else {
								System.out.println("29");
								valid = true;
							}
						}
					}else{
						System.out.println(DayOfMonth[i]);
						valid = true;
						break;
					}
				}
			}
			if(!valid) {
				System.out.println("Invalid, please insert again: ");
			}
		}
	}
}

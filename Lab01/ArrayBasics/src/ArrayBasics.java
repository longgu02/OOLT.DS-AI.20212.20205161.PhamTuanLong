
public class ArrayBasics {
	public static void main(String args[]) {
		int[] arr = {66435 ,234234 ,234 ,123 ,5435};
		int sum = 0, counter = 0;
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			counter++;
			System.out.print(arr[i] + " ");
		};
		System.out.println(" \nSum: " + sum + " | Avg: " + sum/counter);
	};
}


public class AddMatrices {
	public static void main(String args[]) {
		int[][] mat1 = {{1,2,3}, {1,2,3}, {1,2,3}};
		int[][] mat2 = {{1,2,4}, {1,2,4}, {1,2,4}};
		int[][] result = {{0,0,0}, {0,0,0}, {0,0,0}}; 
		for(int i = 0; i < mat1.length; i++) {
			for(int j = 0; j < mat1[0].length; j++) {
				result[i][j] = mat1[i][j] + mat2[i][j];
			};
		};
		for(int i = 0; i < mat1.length; i++) {
			for(int j = 0; j < mat1[0].length; j++) {
				System.out.print(result[i][j] + " ");
			};
			System.out.print("\n");
		};
	}
}

public class MySweetProgram {

	public static void main(String[] args) {

		int[][] data = {

				{ 23, 4, 67, 2 }, 
				{ 4, 89, 34, 1, 56, 8, 53, 6 }, 
				{ 76, 81, 34, 5 }

		};

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}
}
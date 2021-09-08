
public class Main {

	public static void main(String[] args) {

		Running pair1 = new Running("Nike", 43, 250);
		Walking pair2 = new Walking("Hanwag", 43.5, true);
		Walking pair3 = new Walking("Merrel", 42, false);

		Object[] shoesArray = { pair1, pair2, pair3 };
		
		for (Object i : shoesArray) {
			if(i instanceof Running ) {
				System.out.print(((Running) i).brand + "\tsize " 
						+ ((Running) i).size + 
						"  " + (int) ((Running) i).weight + " grams/shoe\n");
			}
			
			if(i instanceof Walking) {
					System.out.print(((Walking) i).brand + "\tsize " 
							+ ((Walking) i).size + "  ");
					if (((Walking) i).goreTex == true) {
						System.out.println("Gore-Tex");
					} else {System.out.println("No Gore-Tex");}
			}
		}
	}
}

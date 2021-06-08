import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MySweetProgram {

	public static void main(String[] args) throws FileNotFoundException {
		
		LinkedList<String> names = new LinkedList<String>();
		names.push("Rizvi");
		names.push("Sanzida");
		names.push("Waniya");

		System.out.println(names.pop());
		System.out.println(names.removeFirst());
		System.out.println(names.remove());
	}
}
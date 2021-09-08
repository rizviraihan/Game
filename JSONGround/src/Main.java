import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Main {

	public static void main(String[] args) throws JsonException, IOException {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();

		System.out.println("To add a user press A and Enter");
		System.out.println("To delete a user press D and Enter");
		System.out.println("To update a user press U and Enter");

		String performOperation = sc.nextLine();

		if (performOperation.equals("A")) {
			m.userAdd(sc);
		} else if (performOperation.equals("D")) {
			m.userDelete(sc);
		} else if (performOperation.equals("U")) {
			m.userUpdate(sc);
		} else {
			System.out.println("No action inputted, program closed.");
		}

		// adding an object in the array
//		JsonObject addUser = new JsonObject();
//		addUser.put("firstname", "Selina");
//		addUser.put("lastname", "Gomez");
//
//		array.add(addUser);
//
//		System.out.println(array);
//
//		JsonObject createJson = new JsonObject();
//
//		createJson.put("user", array);
//
//		FileWriter file = new FileWriter("json/user.json");
//		file.write(createJson.toJson());
//		file.flush();
//		file.close();

	}

	public void userAdd(Scanner inputData) throws IOException, JsonException {
		String inputFirstName = "";
		String inputLastName = "";

		System.out.println("Enter firstname: ");
		inputFirstName = inputData.nextLine();

		System.out.println("Enter lastname: ");
		inputLastName = inputData.nextLine();

		FileReader fileReader = new FileReader("json/user.json");
		JsonObject getUserObject = (JsonObject) Jsoner.deserialize(fileReader);

		JsonArray array = (JsonArray) getUserObject.get("user");

		JsonObject addUser = new JsonObject();
		addUser.put("firstname", inputFirstName.trim());
		addUser.put("lastname", inputLastName.trim());

		array.add(addUser);

		JsonObject createJson = new JsonObject();

		createJson.put("user", array);

		FileWriter file = new FileWriter("json/user.json");
		file.write(createJson.toJson());
		file.flush();
		file.close();
		System.out.println(array);
	}

	public void userDelete(Scanner inputData) throws IOException, JsonException {

		String inputFirstName = "";
		String inputLastName = "";
		String inputFullName = "";
		String savedFullName = "";

		System.out.println("Enter firstname: ");
		inputFirstName = inputData.nextLine();

		System.out.println("Enter lastname: ");
		inputLastName = inputData.nextLine();

		inputFullName = inputFirstName.trim() + " " + inputLastName.trim();

		FileReader fileReader = new FileReader("json/user.json");
		JsonObject getUserObject = (JsonObject) Jsoner.deserialize(fileReader);

		JsonArray array = (JsonArray) getUserObject.get("user");

		JsonObject getUserName = null;

		for (int i = 0; i < array.size(); i++) {
			getUserName = (JsonObject) array.get(i);
			// System.out.print(getUserName.get("firstname") + " ");
			// System.out.println(getUserName.get("lastname") + " at " + i);

			savedFullName = getUserName.get("firstname") + " " + getUserName.get("lastname");

			if (inputFullName.equals(savedFullName)) {

				System.out.println("User found. Do you want to delete?");
				System.out.println("Press Y and ENTER to proceed... ");
				System.out.println("Press any key except Y and ENTER to cancel...");

				String choice = inputData.nextLine();

				if (choice.equals("Y")) {

					System.out.println("User update in progress...");

					array.remove(getUserName);

					JsonObject createJson = new JsonObject();
					createJson.put("user", array);

					FileWriter file = new FileWriter("json/user.json");
					file.write(createJson.toJson());
					file.flush();
					file.close();

					System.out.println("User deleted.");
					System.out.println(array);
					break;
				} else {
					System.out.println("Not deleted. Cancelled.");
				}
			} else {
				if (i == array.size() - 1) {
					System.out.println("User Not Found.");
				}
			}
		}

		inputData.close();

	}

	public void userUpdate(Scanner inputData) throws IOException, JsonException {
		String inputFirstName = "";
		String inputLastName = "";
		String inputFullName = "";
		String savedFullName = "";
		String newFirstName = "";
		String newLastName = "";

		System.out.println("Enter firstname: ");
		inputFirstName = inputData.nextLine();

		System.out.println("Enter lastname: ");
		inputLastName = inputData.nextLine();

		inputFullName = inputFirstName.trim() + " " + inputLastName.trim();

		FileReader fileReader = new FileReader("json/user.json");
		JsonObject getUserObject = (JsonObject) Jsoner.deserialize(fileReader);

		JsonArray array = (JsonArray) getUserObject.get("user");

		JsonObject getUserName = null;

		// System.out.println(array);

		for (int i = 0; i < array.size(); i++) {
			getUserName = (JsonObject) array.get(i);
			// System.out.print(getUserName.get("firstname") + " ");
			// System.out.println(getUserName.get("lastname") + " at " + i);

			savedFullName = getUserName.get("firstname") + " " + getUserName.get("lastname");

			if (inputFullName.equals(savedFullName)) {

				System.out.println("User found. Do you want to update?");
				System.out.println("Press Y and ENTER to proceed... ");
				System.out.println("Press any key except Y and ENTER to cancel...");

				String choice = inputData.nextLine();

				if (choice.equals("Y")) {

					System.out.println("Enter firstname: ");
					newFirstName = inputData.nextLine();

					System.out.println("Enter lastname: ");
					newLastName = inputData.nextLine();

					System.out.println("User update in progress...");
					getUserName.put("firstname", newFirstName.trim());
					getUserName.put("lastname", newLastName.trim());
					array.remove(getUserName);
					array.add(i, getUserName);

					JsonObject createJson = new JsonObject();
					createJson.put("user", array);

					FileWriter file = new FileWriter("json/user.json");
					file.write(createJson.toJson());
					file.flush();
					file.close();

					System.out.println("User update completed.");
					System.out.println(array);
					break;
				} else {
					System.out.println("Not updated. Cancelled.");
				}
			} else {
				if (i == array.size() - 1) {
					System.out.println("User Not Found.");
				}
			}
		}

		inputData.close();

	}
}

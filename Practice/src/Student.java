import java.util.ArrayList;
import java.util.List;

public class Student extends User {

	Student() {
	}

	Student(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public List<User> getUsers(List<User> users, User u) {
		List<User> foundStudents = new ArrayList<User>();

		for (User user : users) {
			if (user.equals(u)) {
				foundStudents.add(user);
			}
		}
		if (!foundStudents.isEmpty())
			return foundStudents;
		else
			return null;
	}

	@Override
	public User getUser(List<User> users, User user) {
		return user;

	}

	@Override
	public void find(List<User> users, User u) {

		for (User user : users) {
			if (user.equals(u)) {
				System.out.println(user + " found at " + users.indexOf(user));

			}
		}
	}

	@Override
	public String getAllUser() {
		return getFullName();

	}
}
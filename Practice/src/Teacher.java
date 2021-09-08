import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {

	Teacher() {
	}

	Teacher(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public List<User> getUsers(List<User> users, User u) {
		List<User> foundTeachers = new ArrayList<User>();
		for (User user : users) {
			if (user.equals(u)) {

				foundTeachers.add(user);
			}
		}
		if (!foundTeachers.isEmpty())
			return foundTeachers;
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

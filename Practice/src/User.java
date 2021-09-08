import java.util.List;
import java.util.Objects;

public abstract class User {

	private String firstName;
	private String lastName;

	User() {

	}

	User(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}

	public abstract List<User> getUsers(List<User> users, User user);

	public abstract User getUser(List<User> users, User user);

	public abstract void find(List<User> users, User user);

	public abstract String getAllUser();

	@Override
	public String toString() {
		return "From toString: " + getFirstName() + " " + getLastName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

	// not used, list item object number is correct
	public boolean equals(User user) {
		if (getFirstName() == user.getFirstName() && getLastName() == user.getLastName()) {
			return true;
		} else {
			return false;
		}
	}
}

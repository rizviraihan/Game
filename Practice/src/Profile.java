import java.util.ArrayList;
import java.util.List;

public class Profile {

	public static void main(String[] args) {
		
		Student user1 = new Student("Tom", "Hank");
		Student user2 = new Student("Tom", "Hank");

		Teacher user3 = new Teacher("hello", "world");
		Teacher user4 = new Teacher("Tom", "Hxank");
		Teacher user5 = new Teacher("Tom", "Hank");
		Teacher user6 = new Teacher("Tom", "Hank");

		List<User> users = new ArrayList<User>();

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);

		User targetStudent = new Student();
		targetStudent.setFirstName("Tom");
		targetStudent.setLastName("Hank");

		User targetTeacher = new Teacher();
		targetTeacher.setFirstName("Tom");
		targetTeacher.setLastName("Hank");

		for (User user : users) {
			if (user.equals(targetStudent) || user.equals(targetTeacher)) {
				user = user.getUser(users, user);
				System.out.println(user.getAllUser() + " from " + user.getClass() + " at " + users.indexOf(user));
			}
		}
	}
}

package Project_018.App;

import Project_018.User.User;
import Project_018.User.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();

        userRepo.add(new User(1, "John", "john@gmail.com"));
        userRepo.add(new User(2, "Jane", "jane@gmail.com"));
        userRepo.add(new User(3, "Bob", "bob@gmail.com"));
        userRepo.add(new User(4, "Alice", "alice@gmail.com"));

        try {
            User user = userRepo.findById(1);
            System.out.println("User found: " + user.getName());
        } catch (Exception e) {
            System.out.println("User not found.");
        }

        try {
            User user = userRepo.findByEmail("jane@gmail.com");
            System.out.println("User found: " + user.getName());
        } catch (Exception e) {
            System.out.println("User not found.");
        }

            List<User> users = userRepo.findAllUsers().get();
               System.out.println("All users:");
            for (User user : users) {
                System.out.println(user.getName());
            }

    }
}

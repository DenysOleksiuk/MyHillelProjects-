package Project_018.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public List<User> getAll() {
        return users;
    }

    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                Optional<User> userOptional = Optional.of(user);
                return userOptional.get();
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                Optional<User> userOptional = Optional.of(user);
                return userOptional.get();
            }
        }
        return null;
    }

    public Optional<List<User>> findAllUsers() {
        return Optional.ofNullable(users);
    }





}

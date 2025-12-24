package test1;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    long idCounter = 0;

    public User createUser(String firstname, String lastName, String email){
        User user = new User(idCounter, firstname, lastName, email);
        users.add(user);
        idCounter++;
        return user;
    }

    public User getUserById(long id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User updateUser(long id, String newName, String newLastName, String newEmail){
        for (User user : users){
            if (user.getId() == id){
                user.setFirstname(newName);
                user.setLastName(newLastName);
                user.setEmail(newEmail);
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(long id){
        return users.removeIf(user -> user.getId() == id);
    }
}

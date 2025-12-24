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
        throw new UserNotFoundException("User with ID: " + id + " not found");
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
        throw new UserNotFoundException("User with id " + id + " not found");
    }

    public boolean deleteUser(long id){
        boolean deleted = users.removeIf(user -> user.getId() == id);
        if (!deleted){
            throw new UserNotFoundException("User with id " + id + " not found");
        } else
            return true;
    }

    public User findUserByIdOrThrow(long id){
        for (User user:users){
            if (user.getId() == id){
                return user;
            }
        }
        throw new UserNotFoundException("User with id " + id + " not found");
    }
}

package test;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    private long idCounter = 0;

    public User createUser(String firstName, String lastName, String email){
        User user = new User(idCounter, firstName, lastName, email);
        users.add(user);
        idCounter++;
        return user;
    }


    public List<User> getAllUsers(){
        return users;
    }

    public User getUserById(Long id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User updateUser(Long id, String firstName, String lastName, String email){
        for (User user : users){
            if (user.getId() == id){
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(Long id){
        return users.removeIf(user -> user.getId() == id);
    }

}


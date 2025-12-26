package com.maqa.usermanager;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    private long idCounter = 0;

    public User createUser(String firstname, String lastName, String email) {
        validateUserData(firstname, lastName, email);
        User user = new User(idCounter, firstname, lastName, email);
        users.add(user);
        idCounter++;
        return user;
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    private void validateUserData(String firstname, String lastName, String email){
        if (firstname == null || lastName == null || email == null) {
            throw new IllegalArgumentException("Firstname, Lastname or email cannot be NULL");
        }if (firstname.trim().isEmpty() || lastName.trim().isEmpty() || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Firstname, Lastname or email is empty");
        } if (!validateEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public User getUserById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("User with ID: " + id + " not found");
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public User updateUser(long id, String newName, String newLastName, String newEmail) {
        validateUserData(newName, newLastName, newEmail);
        for (User user : users) {
            if (user.getId() == id) {
                user.setFirstName(newName);
                user.setLastName(newLastName);
                user.setEmail(newEmail);
                return user;
            }
        }
        throw new UserNotFoundException("User with id " + id + " not found");
    }

    public boolean deleteUser(long id) {
        boolean deleted = users.removeIf(user -> user.getId() == id);
        if (!deleted) {
            throw new UserNotFoundException("User with id " + id + " not found");
        } else
            return deleted;
    }
}

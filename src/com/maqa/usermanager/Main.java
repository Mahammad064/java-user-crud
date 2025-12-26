package com.maqa.usermanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose one of below actions:");
            System.out.println("1. CREATE");
            System.out.println("2. GET ALL USERS");
            System.out.println("3. GET USER BY ID");
            System.out.println("4. UPDATE");
            System.out.println("5. DELETE BY ID");
            System.out.println("0: Exit the app");

            System.out.print("Enter the number of action: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Bye!");
                    return;
                case 1:
                    System.out.print("First name: ");
                    String fname = scanner.nextLine();
                    System.out.print("Last name: ");
                    String lname = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.println("Created: " +
                            userService.createUser(fname, lname, email));
                    System.out.println("===============================");
                    break;
                case 2:
                    userService.getAllUsers().forEach(System.out::println);
                    System.out.println("===============================");
                    break;
                case 3:
                    try {
                        System.out.print("Enter ID: ");
                        System.out.println(
                                userService.getUserById(scanner.nextLong()));
                        scanner.nextLine();
                        System.out.println("===============================");
                    } catch (UserNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("ID: ");
                        long id = scanner.nextLong();
                        scanner.nextLine();
                        userService.getUserById(id);
                        System.out.print("New first name: ");
                        fname = scanner.nextLine();
                        System.out.print("New last name: ");
                        lname = scanner.nextLine();
                        System.out.print("New email: ");
                        email = scanner.nextLine();
                        System.out.println(
                                userService.updateUser(id, fname, lname, email));
                        System.out.println("===============================");
                    } catch (UserNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Enter ID: ");
                        System.out.println(
  //                              userService.deleteUser(scanner.nextLong()));
                              userService.deleteUser(scanner.nextLong()) ? "Deleted" : "User not found");
                        scanner.nextLine();
                        System.out.println("===============================");
                    } catch (UserNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.print("WRONG INPUT. Choose one of actions above!!!!");
                    System.out.println("===============================");
            }
        }
    }
}

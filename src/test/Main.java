package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select one of actions:");
        System.out.println("CREATE");
        System.out.println("GETALL");
        System.out.println("GETBYID");
        System.out.println("UPDATE");
        System.out.println("DELETE");

        System.out.print("Enter command: ");
        String action = scanner.nextLine();

        if (action.equals("CREATE")) {
            userService.createUser(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        } else if (action.equals("GETALL")) {
            System.out.println(userService.getAllUsers());
        } else if (action.equals("GETBYID")) {
            userService.getUserById(scanner.nextLong());
        } else if (action.equals("UPDATE")) {
            userService.updateUser(scanner.nextLong(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        } else if (action.equals("DELETE")) {
            userService.deleteUser(scanner.nextLong());
        }
    }
}

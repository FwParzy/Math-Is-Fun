import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        User currentUser; // use to track performance of user. 

        do {

            do {
                System.out.println("1. Login");
                System.out.println("2. Add user");
                System.out.println("3. Search user by ID");
                System.out.println("4. Print all users");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("must be a number: ");
                    scanner.next();
                }
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 5);

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    addUser(scanner);
                    break;
                case 3:
                    searchUserById(scanner);
                    break;
                case 4:
                    printAllUsers();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice
                != 5);

        scanner.close();
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        if (!Login.authenticateUser(username, password)) {
            System.out.println("Invalid username or password.");
        }
        System.out.println("Login successful. Hello ");
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.next();

        int level = 0;

        do {
            System.out.print("Enter level(1-4): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number (1-4): ");
                scanner.next();
            }
            level = scanner.nextInt();
        } while (level > 4 || level < 1);

        System.out.print("Enter first name: ");
        String firstName = scanner.next();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        Login.addUser(level, email, firstName, lastName, username, password);
    }

    private static void searchUserById(Scanner scanner) {
        int id =0;
        do {
            System.out.print("Enter user ID: ");
            while (!scanner.hasNextInt()) {
                System.out.print("must be a number ");
                scanner.next();
            }
            id = scanner.nextInt();
        } while (id < 1 || id > Database.getNextId() - 1);

        Database.searchUserById(id);
    }

    private static void printAllUsers() {
        Database.printAllUsers();
    }
}

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("1. Login");
      System.out.println("2. Add user");
      System.out.println("3. Search user by ID");
      System.out.println("4. Print all users");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

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
    } while (choice != 5);

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

    System.out.print("Enter first name: ");
    String firstName = scanner.next();

    System.out.print("Enter last name: ");
    String lastName = scanner.next();

    System.out.print("Enter username: ");
    String username = scanner.next();

    System.out.print("Enter password: ");
    String password = scanner.next();

    Login.addUser(email, firstName, lastName, username, password);
  }

  private static void searchUserById(Scanner scanner) {
    System.out.print("Enter user ID: ");
    int id = scanner.nextInt();
    User.searchUserById(id);
  }

  private static void printAllUsers() {
    User.printAllUsers();
  }
}

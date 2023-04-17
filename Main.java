import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;
    JSONObject user;

    do {
      System.out.println("1. Login");
      System.out.println("2. Add user");
      System.out.println("3. Search user by ID");
      System.out.println("4. Print all users");
      System.out.println("9. Exit");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          User currentUser = login(scanner);
          loggedIn(scanner, currentUser);
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
        case 9:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 9);

    scanner.close();
  }

  private static User login(Scanner scanner) {
    System.out.print("Enter username: ");
    String username = scanner.next();

    System.out.print("Enter password: ");
    String password = scanner.next();

        User user = Login.authenticateUser(username, password);
    if (user.getId() == -1) {
      System.out.println("Invalid username or password.");
      return null;
    }

    User currentUser = UserRepository.searchUserById(user.getId());
    if (currentUser == null) {
      System.out.println("User not found.");
      return null;
    }

    System.out.println("Login successful. Hello " + currentUser.getFirstName());
    return currentUser;
  }

  private static void loggedIn(Scanner scanner, User currentUser) {
    int loggedInChoice;
    do {
      System.out.println("1. View current user");
      System.out.println("2. Do things (placeholder)");
      System.out.println("9. Logout");
      System.out.print("Enter your choice: ");
      loggedInChoice = scanner.nextInt();

      switch (loggedInChoice) {
        case 1:
          UserRepository.printSearchedUser(currentUser.getId());
          break;
        case 2:
          System.out.println("Doing things (placeholder)..."); // Placeholder action
          break;
        case 9:
          System.out.println("Logging out...");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (loggedInChoice != 9);
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

    int id = UserRepository.getNextId();
    User newUser = new User(id, email, firstName, lastName, username, password);
    Login.addUser(newUser);
  }

  private static void searchUserById(Scanner scanner) {
    System.out.print("Enter user ID: ");
    int id = scanner.nextInt();
    UserRepository.printSearchedUser(id);
  }

  private static void printAllUsers() {
    UserRepository.printAllUsers();
  }
}

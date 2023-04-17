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
        case 9:
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

    int userId = Login.authenticateUser(username, password);
    if (userId == -1) {
      System.out.println("Invalid username or password.");
      return;
    }
    JSONObject currentUser = null;
    JSONArray users = User.readUsersFromFile();
    for (Object userObj : users) {
      JSONObject user = (JSONObject) userObj;
      int id = ((Long) user.get("id")).intValue();
      if (id == userId) {
        String firstName = (String) user.get("firstName");
        System.out.println("Login successful. Hello " + firstName);
        currentUser = user;
        break;
      }
    }

    if (currentUser == null) {
      System.out.println("User not found.");
      return;
    }

    loggedIn(scanner, currentUser);
  }

  private static void loggedIn(Scanner scanner, JSONObject currentUser) {
    int loggedInChoice;
    do {
      System.out.println("1. View current user");
      System.out.println("2. Do things (placeholder)");
      System.out.println("9. Logout");
      System.out.print("Enter your choice: ");
      loggedInChoice = scanner.nextInt();

      switch (loggedInChoice) {
        case 1:
          User.printSearchedUser(((Long) currentUser.get("id")).intValue());
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
    } while (loggedInChoice != 3);
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
    User.printSearchedUser(id);
  }

  private static void printAllUsers() {
    User.printAllUsers();
  }
}

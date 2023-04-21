import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/*
 * @author Isaac
 * @author Natalie
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice = 99;
    // This defaults to invalid untill we get to 8 options
    JSONObject user;

    do {
      try {
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
            if (currentUser == null) {
              break;
            }
            loggedIn(scanner, currentUser);
            break;
          case 2:
            addUser(scanner);
            break;
          case 3:
            searchUserById(scanner);
            break;
          case 4:
            UserRepository.printAllUsers();
            break;
          case 9:
            System.out.println("Goodbye!");
            scanner.close();
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (InputMismatchException e) {
        System.out.println("That isn't allowed. Please enter a valid integer.");
        scanner.nextLine(); // Clear the invalid input from the scanner
      }
    } while (choice != 9);

    scanner.close();
  }

  /*
   * @author Isaac
   *
   * @param scanner - user input
   *
   * @return User - the user if they logged in
   */
  private static User login(Scanner scanner) {
    System.out.print("Enter username: ");
    String username = scanner.next();

    System.out.print("Enter password: ");
    String password = scanner.next();

    User user = Login.authenticateUser(username, password);
    if (user == null) {
      System.out.println("Invalid username or password.");
      return null;
    }

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

  /*
   * @author Isaac
   *
   * @param scanner - user input
   *
   * @return
   */
  private static void loggedIn(Scanner scanner, User currentUser) {
    int loggedInChoice = 8;
    do {
      try {
        System.out.println("1. View current user");
        System.out.println("2. Play MathIsFun");
        System.out.println("9. Logout");
        System.out.print("Enter your choice: ");
        loggedInChoice = scanner.nextInt();

        switch (loggedInChoice) {
          case 1:
            UserRepository.printSearchedUser(currentUser.getId());
            break;
          case 2:
            MathIsFun(scanner);
            break;
          case 9:
            System.out.println("Logging out...");
            break;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (InputMismatchException e) {
        System.out.println("That isn't allowed. Please enter a valid integer.");
        scanner.nextLine(); // Clear the invalid input from the scanner
      }

    } while (loggedInChoice != 9);
  }

  /*
   * @author Natalie
   * @author Isaac
   *
   * @param scanner - user input
   */
  private static void MathIsFun(Scanner scanner) {
    int playAgain = 1;
    while (playAgain != 0) {
      System.out.println(
          "***********************************\n"
              + "*				  *\n"
              + "*    MATH IS FUN!                 *\n"
              + "*                                 *\n"
              + "***********************************");

      System.out.println(
          "Select a game below:\n"
              + "1. Addition     2. Subtraction     3. Multiplication   4.Division    9. Quit");

      try {
        switch (scanner.nextInt()) {
          case 1: // addition
            ArrayList<Double> grades = MathFunctions.Addition(scanner);
            break;
          case 2: // subtraction
            ArrayList<Double> gradesSub = MathFunctions.Subtraction(scanner);
            break;
          case 3: // multiplication
            MathFunctions.Multiplication(scanner);
            break;
          case 4: // division
            MathFunctions.division(scanner);
            break;
          case 9: // division
            playAgain = 0;
            break;
        }
      } catch (InputMismatchException e) {
        System.out.println("That isn't allowed. Please enter a valid integer.");
        scanner.nextLine(); // Clear the invalid input from the scanner
      }

      System.out.println("Would you like to play again?");
      System.out.println("press 0 to quit, or 1 to continue");
      try {
        playAgain = scanner.nextInt();

      } catch (InputMismatchException e) {
        System.out.println("That isn't allowed. Please enter a valid integer.");
        scanner.nextLine(); // Clear the invalid input from the scanner
      }
    }
  }

  private static String readInputWithCancel(Scanner scanner, String prompt) {
    System.out.print(prompt);
    String input = scanner.next();
    return input.equals("9") ? null : input;
  }

  private static void addUser(Scanner scanner) {
    try {
      String email = readInputWithCancel(scanner, "Enter email (type 9 to cancel): ");
      if (email == null) return;

      String firstName = readInputWithCancel(scanner, "Enter first name (type 9 to cancel): ");
      if (firstName == null) return;

      String lastName = readInputWithCancel(scanner, "Enter last name (type 9 to cancel): ");
      if (lastName == null) return;

      // check if username already exists
      String username;
      boolean usernameExists;
      do {
        username = readInputWithCancel(scanner, "Enter username (type 9 to cancel): ");
        if (username == null) return;

        usernameExists = false;
        JSONArray users = UserRepository.readUsersFromFile();
        for (Object userObj : users) {
          JSONObject userJson = (JSONObject) userObj;
          User user = UserRepository.jsonToUser(userJson);
          if (user.getUsername().equals(username)) {
            usernameExists = true;
            System.out.println("Username is already taken. Please choose another one.");
            break;
          }
        }
      } while (usernameExists);

      String password = readInputWithCancel(scanner, "Enter password (type 9 to cancel): ");
      if (password == null) return;

      int id = UserRepository.getNextId();
      User newUser = new User(id, email, firstName, lastName, username, password);
      Login.addUser(newUser);
    } catch (InputMismatchException e) {
      System.out.println("That isn't allowed. Please enter a valid input.");
      scanner.nextLine(); // Clear the invalid input from the scanner
    }
  }

  /*
   * @author Isaac
   *
   * @param scanner - user input
   */
  // private static void addUser(Scanner scanner) {
  //   try {
  //     System.out.print("Enter email: ");
  //     String email = scanner.next();
  //
  //     System.out.print("Enter first name: ");
  //     String firstName = scanner.next();
  //
  //     System.out.print("Enter last name: ");
  //     String lastName = scanner.next();
  //
  //     System.out.print("Enter username: ");
  //     String username = scanner.next();
  //
  //     System.out.print("Enter password: ");
  //     String password = scanner.next();
  //
  //     int id = UserRepository.getNextId();
  //     User newUser = new User(id, email, firstName, lastName, username, password);
  //     Login.addUser(newUser);
  //   } catch (InputMismatchException e) {
  //     System.out.println("That isn't allowed. Please enter a valid input.");
  //     scanner.nextLine(); // Clear the invalid input from the scanner
  //   }
  // }

  /*
   * @author Isaac
   *
   * @param scanner - user input
   *
   */
  private static void searchUserById(Scanner scanner) {
    System.out.print("Enter user ID: ");
    try {
      int id = scanner.nextInt();
      UserRepository.printSearchedUser(id);
    } catch (InputMismatchException e) {
      System.out.println("That isn't allowed. Please enter a valid input.");
      scanner.nextLine(); // Clear the invalid input from the scanner
    }
  }
}

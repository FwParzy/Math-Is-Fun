import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserRepository {

  private static final String FILE_NAME = "db.json";

  public static void inputUser(User user) {
    int id = getNextId();
    user.setId(id);

    JSONObject newUser = user.toJson();
    JSONArray users = readUsersFromFile();
    users.add(newUser);
    writeUsersToFile(users);

    System.out.println(user.getFirstName() + " added successfully.");
  }
    public static JSONObject userToJson(User user) {
    return user.toJson();
  }

  public static User jsonToUser(JSONObject userJson) {
    String role = (String) userJson.get("role");
    return User.fromJson(userJson);
  }


  public static User searchUserById(int id) {
    JSONArray users = readUsersFromFile();
    for (Object userObj : users) {
      JSONObject userJson = (JSONObject) userObj;
      User user = jsonToUser(userJson);
      if (id == user.getId()) {
        return user;
      }
    }
    return null;
  }

  public static int getNextId() {
    JSONArray users = readUsersFromFile();
    int maxId = 0;

    for (Object userObj : users) {
      JSONObject user = (JSONObject) userObj;
      int userId = ((Long) user.get("id")).intValue();
      if (userId > maxId) {
        maxId = userId;
      }
    }

    return maxId + 1;
  }

  public static JSONArray readUsersFromFile() {
    JSONParser parser = new JSONParser();
    JSONArray users;

    try (FileReader reader = new FileReader(FILE_NAME);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      users = new JSONArray();
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        Object parsed = parser.parse(line);
        if (parsed instanceof JSONObject) {
          users.add(parsed);
        }
      }
    } catch (IOException | ParseException e) {
      users = new JSONArray(); // Return an empty array if file not found or cannot be parsed
    }

    return users;
  }

  private static void writeUsersToFile(JSONArray users) {
    try (FileWriter file = new FileWriter(FILE_NAME)) {
      for (Object userObj : users) {
        JSONObject user = (JSONObject) userObj;
        file.write(user.toJSONString() + System.lineSeparator());
      }
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


    public static void printSearchedUser(int id) {
  User user = searchUserById(id);
  if (user != null) {
    JSONObject jsonUser = userToJson(user);
    print(jsonUser);
  } else {
    System.out.println("User not found.");
  }
}


  public static void printAllUsers() {
    JSONArray users = readUsersFromFile();
    print(users);
  }

  private static void print(JSONObject user) {
    JSONArray users = new JSONArray();
    users.add(user);
    print(users);
  }


  private static void print(JSONArray users) {
    System.out.println(
        "+----+-----------------+---------------+---------------+-----------------+----------------------------------+");
    System.out.println(
        "| ID | Email           | First Name    | Last Name     | Username        | Encrypted"
            + " Password               |");
    System.out.println(
        "+----+-----------------+---------------+---------------+-----------------+----------------------------------+");
    for (Object userObj : users) {
      JSONObject user = (JSONObject) userObj;
      int id = ((Long) user.get("id")).intValue();
      String email = (String) user.get("email");
      String firstName = (String) user.get("firstName");
      String lastName = (String) user.get("lastName");
      String username = (String) user.get("username");
      String encryptedPassword = (String) user.get("password");
      System.out.printf(
          "| %-2d | %-15s | %-13s | %-13s | %-15s | %-32s |\n",
          id, email, firstName, lastName, username, encryptedPassword);
    }
    System.out.println(
        "+----+-----------------+---------------+---------------+-----------------+----------------------------------+");
  }
}

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class User {

    private static int id = 0;
    private int myId;
    private int level;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    

    public User(int level, String username, String password, String email, String firstName, String lastName) {
        this.level = level;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.myId = id;
        id++;
    }

    public static void print(JSONArray users) {
        String br = 
        "+----+---------------+-----------------+---------------+-----------------+-----------------+----------------------------------+";
    System.out.println(br);
    System.out.println(
        "| ID |   Level       | Email           | First Name    | Last Name       | Username        | Encrypted Password               |");
    System.out.println(br);
    for (Object userObj : users) {
      JSONObject user = (JSONObject) userObj;
      int id = ((Long) user.get("id")).intValue();
      int level = ((Long) user.get("level")).intValue();
      String email = (String) user.get("email");
      String firstName = (String) user.get("firstName");
      String lastName = (String) user.get("lastName");
      String username = (String) user.get("username");
      String encryptedPassword = (String) user.get("password");
      System.out.printf(
          "| %-2d | %-14s| %-15s | %-13s | %-15s | %-15s | %-32s |\n",
          id,  level, email, firstName, lastName, username, encryptedPassword);
    }
    System.out.println(br);
    }

    public int getId() {
        return this.myId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

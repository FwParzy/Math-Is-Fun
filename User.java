import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class User {
  private int id;
  private String email;
  private String firstName;
  private String lastName;
  private String username;
  private String password;

  public User(
      int id,
      String email,
      String firstName,
      String lastName,
      String username,
      String password) {
    this.id = id;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public JSONObject toJson() {
    JSONObject userJson = new JSONObject();
    userJson.put("id", Long.valueOf(getId()));
    userJson.put("email", getEmail());
    userJson.put("firstName", getFirstName());
    userJson.put("lastName", getLastName());
    userJson.put("username", getUsername());
    userJson.put("password", getPassword());
    return userJson;
  }

  public static User fromJson(JSONObject userJson) {
    int id = ((Long) userJson.get("id")).intValue();
    String email = (String) userJson.get("email");
    String firstName = (String) userJson.get("firstName");
    String lastName = (String) userJson.get("lastName");
    String username = (String) userJson.get("username");
    String password = (String) userJson.get("password");
    return new User(id, email, firstName, lastName, username, password);
  }
}

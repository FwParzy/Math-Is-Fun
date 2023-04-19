import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/*
 * @author Isaac
 */
public class User {
  private int id;
  private String email;
  private String firstName;
  private String lastName;
  private String username;
  private String password;

/*
 * @author Isaac
 */
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

/*
 * @author Isaac
 *
 * @return id of the user
 */
  public int getId() {
    return id;
  }

/*
 * @author Isaac
 *
 * @param id of the user
 */
  public void setId(int id) {
    this.id = id;
  }

/*
 * @author Isaac
 *
 * @return email of the user
 */
  public String getEmail() {
    return email;
  }

/*
 * @author Isaac
 *
 * @param email of the user
 */
  public void setEmail(String email) {
    this.email = email;
  }

/*
 * @author Isaac
 *
 * @return name of the user
 */
  public String getFirstName() {
    return firstName;
  }

/*
 * @author Isaac
 *
 * @param name of the user
 */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

/*
 * @author Isaac
 *
 * @return name of the user
 */
  public String getLastName() {
    return lastName;
  }

/*
 * @author Isaac
 *
 * @param name of the user
 */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

/*
 * @author Isaac
 *
 * @return Username of the user
 */
  public String getUsername() {
    return username;
  }

/*
 * @author Isaac
 *
 * @param username of the user
 */
  public void setUsername(String username) {
    this.username = username;
  }

/*
 * @author Isaac
 *
 * @return password of the user
 * note: this should be encrypted first
 */
  public String getPassword() {
    return password;
  }

/*
 * @author Isaac
 *
 * @param password of the user
 * note: this should be encrypted first
 */
  public void setPassword(String password) {
    this.password = password;
  }

/*
 * @author Isaac
 *
 * @return the user object as a JSONObject
 */
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

/*
 * @author Isaac
 *
 * @param the JSONObject of the user
 *
 * @return the user object from the JSONObject
 */
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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * @author Isaac
 */
public class Login {
/*
 * @author Isaac
 *
 * @param username - username that is entered
 * @param password - password that is entered
 *
 * @return - user if they matched username and pass correctly
 */
  public static User authenticateUser(String username, String password) {
    String encryptedPassword = encryptPassword(password);
    JSONArray users = UserRepository.readUsersFromFile();

    for (Object userObj : users) {
      JSONObject userJson = (JSONObject) userObj;
      User user = UserRepository.jsonToUser(userJson);

      if (username.equals(user.getUsername()) && encryptedPassword.equals(user.getPassword())) {
        return user;
      }
    }

    return null;
  }

/*
 * @author Isaac
 *
 * @param user - The user to be added to the db file
 */
  public static void addUser(User user) {
    String encryptedPassword = encryptPassword(user.getPassword());
    user.setPassword(encryptedPassword);
    UserRepository.inputUser(user);
  }

/*
 * @author Isaac
 *
 * @param password - the password entered into the program
 *
 * @return encryptedPassword - the MD5 encrypted password
 *
 * @source https://www.javatpoint.com/how-to-encrypt-password-in-java
 */
  private static String encryptPassword(String password) {
    String encryptedPassword = null;
    try {
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.update(password.getBytes());
      byte[] bytes = m.digest();

      StringBuilder s = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }

      encryptedPassword = s.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return encryptedPassword;
  }
}

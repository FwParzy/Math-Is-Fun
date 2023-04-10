import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Login {
  public static int authenticateUser(String username, String password) {
    String encryptedPassword = encryptPassword(password);
    JSONArray users = User.readUsersFromFile();

    for (Object userObj : users) {
      JSONObject user = (JSONObject) userObj;
      String dbUsername = (String) user.get("username");
      String dbPassword = (String) user.get("password");
      if (username.equals(dbUsername) && encryptedPassword.equals(dbPassword)) {
        return ((Long) user.get("id")).intValue();
      }
    }

    return -1;
  }

  public static void addUser(
      String email, String firstName, String lastName, String username, String password) {
    String encryptedPassword = encryptPassword(password);
    User.inputUser(username, encryptedPassword, email, firstName, lastName);
  }

  // https://www.javatpoint.com/how-to-encrypt-password-in-java
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

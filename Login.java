import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Login {
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

  public static void addUser(User user) {
    String encryptedPassword = encryptPassword(user.getPassword());
    user.setPassword(encryptedPassword);
    UserRepository.inputUser(user);
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

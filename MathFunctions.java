import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * @author Estafani
 * @author Natalie
 * @author dellv
 */
public class MathFunctions {
  private static final String additionFileName = "addquestions.txt";
  private static final String subtractionFileName = "subquestions.txt";

  /*
   * @author Estafani
   * @author Natalie
   *
   * @param scanner - user input
   *
   * @return ArrayList of the outputted grades
   */
  public static ArrayList<Double> Addition(Scanner scanner) {

    System.out.println("Addition");
    ArrayList<Double> scores = new ArrayList<>();
    int numQuestions = 10; // Number of questions in the game
    int score = 0; // Player's score2

    try {
      // Generate questions and store them in the text file
      generateQuestions(additionFileName, numQuestions);

      // Read questions from the text file and start the game
      BufferedReader reader = new BufferedReader(new FileReader(additionFileName));
      String line;
      int questionCount = 1;

      System.out.println("Welcome to the Addition Game!");
      System.out.println("You will be asked " + numQuestions + " addition questions.");

      while ((line = reader.readLine()) != null) {
        System.out.println("Question " + questionCount + ": " + line);
        System.out.print("Enter your answer: ");
        int answer = scanner.nextInt();
        int num1 = Integer.parseInt(line.split("\\s+")[0]);
        int num2 = Integer.parseInt(line.split("\\s+")[2]);
        int correctAnswer = num1 + num2;

        if (answer == correctAnswer) {
          System.out.println("Correct!");
          score++;
        } else {
          System.out.println("Incorrect. The correct answer is: " + correctAnswer);
        }

        questionCount++;
      }

      System.out.println("Game Over!");
      System.out.println("Your score: " + score + " out of " + numQuestions);
      Double percentage = (double) (score / numQuestions * 100);
      scores.add(percentage);

      reader.close();
    } catch (IOException e) {
      System.out.println("Failed to read questions from file: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Invalid answer format. Please enter an integer.");
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
    return scores;
  }

  /*
   * @author Estafani
   * @author Natalie
   *
   * @param scanner - user input
   *
   * @return ArrayList of the grades from the questions
   */
  public static ArrayList<Double> Subtraction(Scanner scanner) {
    System.out.println("SUBTRACTION");
    ArrayList<Double> scores = new ArrayList<>();
    int numQuestions2 = 10; // Number of questions in the game
    int score2 = 0; // Player's score2

    try {
      // Generate questions and store them in the text file
      generateSubQuestions(subtractionFileName, numQuestions2);

      // Read questions from the text file and start the game
      BufferedReader reader = new BufferedReader(new FileReader(subtractionFileName));
      String line;
      int questionCount = 1;

      System.out.println("Welcome to the Subtraction Game!");
      System.out.println("You will be asked " + numQuestions2 + " subtraction questions.");

      while ((line = reader.readLine()) != null) {
        System.out.println("Question " + questionCount + ": " + line);
        System.out.print("Enter your answer: ");
        int answer = scanner.nextInt();
        int num1 = Integer.parseInt(line.split("\\s+")[0]);
        int num2 = Integer.parseInt(line.split("\\s+")[2]);
        int correctAnswer = num1 - num2;

        if (answer == correctAnswer) {
          System.out.println("Correct!");
          score2++;
        } else {
          System.out.println("Incorrect. The correct answer is: " + correctAnswer);
        }

        questionCount++;
      }

      System.out.println("Game Over!");
      System.out.println("Your score: " + score2 + " out of " + numQuestions2);
      Double percentage = (double) (score2 / numQuestions2 * 100);
      scores.add(percentage);

      reader.close();
    } catch (IOException e) {
      System.out.println("Failed to read questions from file: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Invalid answer format. Please enter an integer.");
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
    return scores;
  }

  /*
   * @author Estafani
   * @author Natalie
   *
   * @param filename for addition questions
   * @param number of questions to generate
   */
  // Method to generate addition questions and store them in a text file
  public static void generateQuestions(String fileName, int numQuestions) throws IOException {
    FileWriter writer = new FileWriter(fileName);
    Random random = new Random();

    for (int i = 0; i < numQuestions; i++) {
      int num1 = random.nextInt(10) + 1;
      int num2 = random.nextInt(10) + 1;
      writer.write(num1 + " + " + num2 + "\n");
    }

    writer.close();
  }

  /*
   * @author Estafani
   * @author Natalie
   *
   * @param filename for subtraction questions
   * @param number of questions to generate
   */
  // Method to generate subtraction questions and store them in a text file
  public static void generateSubQuestions(String fileName2, int numQuestions2) throws IOException {
    FileWriter writer = new FileWriter(fileName2);
    Random random = new Random();

    for (int i = 0; i < numQuestions2; i++) {
      int num1 = random.nextInt(10) + 1;
      int num2 = random.nextInt(num1) + 1;
      writer.write(num1 + " - " + num2 + "\n");
    }

    writer.close();
  }

  /*
   * @author dellv
   */
  public static void Multiplication(Scanner scanner) {
    // Ask the user to guess how many of them he/she will get correct
    System.out.print("The program will ask you 10 multiplication questions.");
    System.out.println("Guess how many of them you will get correct (0-10)?");

    // Store this number in a variable.
    // This number will be used as a seed
    // You do not need to use guess variable in the rest of your program, just ignore it
    int guess = scanner.nextInt();
    Random random = new Random();
    random.setSeed(guess);

    // Declare the variables to keep count of correct & incorrect answers
    int correct = 0, incorrect = 0;

    // Loop through for the 10 quiz questions
    for (int i = 1; i <= 10; i++) {
      // Get the two random single digits (1 - 9)
      int n1 = random.nextInt(9) + 1;
      int n2 = random.nextInt(9) + 1;
      // Display the question and get the answer
      System.out.print("\nQuestion " + i + ": " + n1 + " x " + n2 + " = ");
      int answer;
      try {
        answer = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input! Please enter an integer.");
        scanner.nextLine(); // Clear the input buffer
        continue; // Skip the rest of the loop iteration and move on to the next question
      }
      // Check if the answer is right for each question
      if (answer == n1 * n2) {
        // Display a correct message
        System.out.println("Your answer is correct!");
        // Increment the count of correct answers by 1 if the answer is right
        correct++;
      } else {
        // Display an incorrect message with the correct answer
        System.out.println("Your answer is incorrect! The correct answer is " + (n1 * n2));
        // Else increment the count of incorrect answers by 1 if the answer is wrong
        incorrect++;
      }
    }

    // display the statistics
    System.out.println("\nCorrect answers: " + correct);
    System.out.println("Incorrect answers: " + incorrect);
  }

  public static void division(Scanner scanner) {
    String fileName = "division"; // Text file to store questions
    int numQuestions = 10; // Number of questions in the game
    int score = 0; // Player's score

    try {
      // Generate questions and store them in the text file
      divGenerateQuestions(fileName, numQuestions);

      // Read questions from the text file and start the game
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String line;
      int questionCount = 1;

      System.out.println("Welcome to the Division Game!");
      System.out.println("You will be asked " + numQuestions + " Division");

      while ((line = reader.readLine()) != null) {
        System.out.println("Question " + questionCount + ": " + line);
        System.out.print("Enter your answer: ");
        int answer = scanner.nextInt();
        int num1 = Integer.parseInt(line.split("\\s+")[0]);
        int num2 = Integer.parseInt(line.split("\\s+")[2]);
        int correctAnswer = num1 / num2;

        if (answer == correctAnswer) {
          System.out.println("Correct!");
          score++;
        } else {
          System.out.println("Incorrect. The correct answer is: " + correctAnswer);
        }

        questionCount++;
      }

      System.out.println("Game Over!");
      System.out.println("Your score: " + score + " out of " + numQuestions);

      reader.close();
    } catch (IOException e) {
      System.out.println("Failed to read questions from file: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Invalid answer format. Please enter an integer.");
    } catch (Exception e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
  }

  /*
   * @author dellv
   * Method to generate division questions and store them in a text file
   */
  public static void divGenerateQuestions(String fileName, int numQuestions) throws IOException {
    FileWriter writer = new FileWriter(fileName);
    Random random = new Random();

    for (int i = 0; i < numQuestions; i++) {
      int num1 = random.nextInt(10) + 1;
      int num2 = random.nextInt(10) + 1;
      writer.write(num1 + " / " + num2 + "\n");
    }

    writer.close();
  }
}

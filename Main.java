import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
     
    //public static void main(String[] args) {
    public static void main(String[] args) {
   
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        //initalize var for while loop
        //int playAgain = in.nextInt();
        System.out.println("***********************************\n"
                + "*				  *\n"
                + "*    MATH IS FUN!              *\n"
                + "*                                 *\n"
                + "***********************************");
        
        //sad little while loop attempt
       // while (playAgain != 0){
            System.out.println("Select a game below:\n1. Addition     2. Stubtraction     3. Multiplication   4.Division");
        
            switch (in.nextInt()) {
            
                case 1:
                    //addition
                     {
                    System.out.println("Addition");
                    String fileName = "addquestions.txt"; // Text file to store questions
                      int numQuestions = 10; // Number of questions in the game
                      int score = 0; // Player's score2

                      try {
                          // Generate questions and store them in the text file
                          generateQuestions(fileName, numQuestions);

                          // Read questions from the text file and start the game
                          BufferedReader reader = new BufferedReader(new FileReader(fileName));
                          Scanner scanner = new Scanner(System.in);
                          String line;
                          int questionCount = 1;

                          System.out.println("Welcome to the Addition Game!");
                          System.out.println("You will be asked " + numQuestions + " addition questions.");

              //            int j =(int) Math.round(Math.random())*10;
              //             if((i+j)== answer/)
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
                          
                          
                          
                          
                          
                          reader.close();
                          scanner.close();
                      } catch (IOException e) {
                          System.out.println("Failed to read questions from file: " + e.getMessage());
                      } catch (NumberFormatException e) {
                          System.out.println("Invalid answer format. Please enter an integer.");
                      } catch (Exception e) {
                          System.out.println("An error occurred: " + e.getMessage());
                      }
                      
                      
                            break; 
                          
                    }
                case 2: //subtraction
                    System.out.println("SUBTRACTION");
                    String fileName2 = "subquestions.txt"; // Text file to store questions
                    int numQuestions2 = 10; // Number of questions in the game
                    int score2 = 0; // Player's score2

                       try {
                           // Generate questions and store them in the text file
                           generateSubQuestions(fileName2, numQuestions2);

                           // Read questions from the text file and start the game
                           BufferedReader reader = new BufferedReader(new FileReader(fileName2));
                           Scanner scanner = new Scanner(System.in);
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
                           
                          
                           reader.close();
                           scanner.close();
                       } catch (IOException e) {
                           System.out.println("Failed to read questions from file: " + e.getMessage());
                       } catch (NumberFormatException e) {
                           System.out.println("Invalid answer format. Please enter an integer.");
                       } catch (Exception e) {
                           System.out.println("An error occurred: " + e.getMessage());
                       }  
                    
                    break;
                
                case 3: //multiplication
                    break;
                case 4: //division
                    break;
            }
            //sad attempt at while loop
            //System.out.println("Would you like to play again?");
            //System.out.println("press 0 to quit.");
            //playAgain = in.nextInt();
            
            
    }
        
    
    
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
}

                   // break;
             
           
                    
                    
        
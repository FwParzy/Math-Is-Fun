/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package division;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author dellv
 */
public class Division {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "division"; // Text file to store questions
        int numQuestions = 10; // Number of questions in the game
        int score = 0; // Player's score

        try {
            // Generate questions and store them in the text file
            generateQuestions(fileName, numQuestions);

            // Read questions from the text file and start the game
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Scanner scanner = new Scanner(System.in);
            String line;
            int questionCount = 1;

            System.out.println("Welcome to the Division Game!");
            System.out.println("You will be asked " + numQuestions + " Division");

//            int j =(int) Math.round(Math.random())*10;
//             if((i+j)== answer/)
            while ((line = reader.readLine()) != null) {
                System.out.println("Question " + questionCount + ": " + line);
                System.out.print("Enter your answer: ");
                int answer = scanner.nextInt();
                int num1 = Integer.parseInt(line.split("\\s+")[0]);
                int num2 = Integer.parseInt(line.split("\\s+")[2]);
                int correctAnswer = num1 / num2;                              //divi

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
    }

    // Method to generate division questions and store them in a text file
    public static void generateQuestions(String fileName, int numQuestions) throws IOException {
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
   
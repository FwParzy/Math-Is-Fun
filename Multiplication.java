/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathisfun;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dellv
 */
public class Multiplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);

        // Ask the user to guess how many of them he/she will get correct
        System.out.print("The program will ask you 10 multiplication questions.");
        System.out.println("Guess how many of them you will get correct (0-10)?");

        // Store this number in a variable.
        // This number will be used as a seed
        // You do not need to use guess variable in the rest of your program, just ignore it
        int guess = input.nextInt();
        Random random = new Random();
        random.setSeed(guess);

        // Declare the variables to keep count of correct & incorrect answers
        int correct = 0, incorrect = 0;


        // Loop through for the 10 quiz questions
        for(int i=1; i<=10; i++) {
            // Get the two random single digits (1 - 9)
            int n1 = random.nextInt(9) + 1;
            int n2 = random.nextInt(9) + 1;
            // Display the question and get the answer
            System.out.print("\nQuestion "+i+": "+n1+" x "+n2+" = ");
            int answer = input.nextInt();
            // Check if the answer is right for each question
            if(answer == n1 * n2) {
                // Display a correct message
                System.out.println("Your answer is correct!");
                // Increment the count of correct answers by 1 if the answer is right
                correct++;
            }
            else{
                // Display an incorrect message with the correct answer
                System.out.println("Your answer is incorrect! The correct answer is "+(n1 * n2));
                // Else increment the count of incorrect answers by 1 if the answer is wrong
                incorrect++; 
            }
        }

        // display the statistics
        System.out.println("\nCorrect answers: "+correct);
        System.out.println("Incorrect answers: "+incorrect);
    }
    }


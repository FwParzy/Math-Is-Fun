/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * @author alively
 * 
 * 
 */
public class Student extends User {
    
    int gradeLevel;  //Each teacher is responsible for one or more students, while each student has one math
                        //teacher in each grade level.
    double progress; //The program should be able to save the progress for each student.
    
    public Student(int level, String username, String password, String email, String firstName, String lastName) {
        super(level, username, password, email, firstName, lastName);
        
        
    }
    
    
//    The project should include three types of users, Teacher, parent, and Student.
}

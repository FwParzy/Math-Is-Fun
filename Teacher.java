/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.util.ArrayList;

/**
 *
 * @author alively
 */
public class Teacher extends User {
    
    int numberOfStudentsInClass; //Additionally, the teacher needs to
                                    //enter the number of students he/she supervises.
    ArrayList<Student> studentsInClass;
    //      The teacher needs to be able to search, list, and sort the students based on Names,
    //      scores, or grades.
    
    public Teacher(int level, String username, String password, String email, String firstName, String lastName) {
        super(level, username, password, email, firstName, lastName);
    }
    
    
}

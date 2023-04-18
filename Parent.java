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
public class Parent extends User{
    
    ArrayList<Student> children;
    //A parent could have one or more child registered in the program. 
    //He/she needs to follow up his/her child progress.
    
    public Parent(int level, String username, String password, String email, String firstName, String lastName) {
        super(level, username, password, email, firstName, lastName);
    }
    
}

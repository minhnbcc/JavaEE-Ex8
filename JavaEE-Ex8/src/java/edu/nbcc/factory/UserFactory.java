/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nbcc.factory;

/**
 *
 * @author Minh. Hoang
 */
public class UserFactory {
    public static User getInstance(UserType userType){
        switch(userType){
            case ADMIN:
                return new Admin();
            case CUSTOMER:
                return new Customer();
            default:
                return new Customer();
        }
    }
}

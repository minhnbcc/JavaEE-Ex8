/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nbcc.factory;

/**
 *
 * @author Minh.Hoang
 */
public class CustomerTest {
    public static void main(String[] args){
        User user = UserFactory.getInstance(UserType.ADMIN);
        System.out.println(user.getEntitlements());
    }
}

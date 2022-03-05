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
public class Admin implements User {

    @Override
    public String getEntitlements() {
        return "Admin user"; //To change body of generated methods, choose Tools | Templates.
    }

}

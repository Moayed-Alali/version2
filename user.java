/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
class user implements Serializable {

    String email, password;

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean valid(user a) {

        if (email.equals(a.email)) {
            if (password.equals(a.password)) {
                return true;

            }
        }
        return false;

    }

}

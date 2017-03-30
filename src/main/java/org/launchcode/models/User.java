package org.launchcode.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by stephen on 3/27/17.
 */
public class User {

    public User(String username, String email, String password, String password_confirmation) {
        this();
        this.email = email;
        this.username = username;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }

    public User() {
        this.id = nextId;
        nextId++;
    }

    @NotNull
    @Length(min = 1, message = "Username is required")
    private String username;

    @Email
    private String email;

    @NotNull
    @Length(min = 5, max = 15)
    private String password;

    @NotNull(message = "Passwords have to match")
    private String password_confirmation;

    private int id;
    private static int nextId = 0;


    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
        checkPasswords();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPasswords();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void checkPasswords() {
        if(!password.equals(password_confirmation)) {
            password_confirmation = null;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

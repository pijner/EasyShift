package com.gameofthreads.project.controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Prahar Ijner
 * @author Travis MacDonald
 */
@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String username = "";
    private String password = "";
    private boolean loginError = false;
    private String errorMessage = "fuck jsf";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginError() {
        return loginError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String attemptLogin() {
        if (username.isEmpty()) {
            setLoginError("Please enter a username.");
            return "login";
        }
        else if (password.isEmpty()) {
            setLoginError("Please enter a password.");
            return "login";
        }
        else if (!usernameExistsInDatabase()) {
            setLoginError("Unrecognized username.");
            return "login";
        }
        else if (!namePassIsValid()) {
            setLoginError("Incorrect password.");
            return "login";
        }
        errorMessage = "";
        loginError = false;
        return "dashboard";
    }

    private void setLoginError(String errorMsg) {
        errorMessage = errorMsg;
        loginError = true;
    }
    
    private boolean usernameExistsInDatabase() {
        
        return true;
    }
    
    private boolean namePassIsValid() {
        return true;
    }

}

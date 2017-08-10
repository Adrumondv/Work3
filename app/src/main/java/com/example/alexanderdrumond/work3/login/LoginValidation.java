package com.example.alexanderdrumond.work3.login;

import com.example.alexanderdrumond.work3.data.CurrentUser;

/**
 * Created by Alexander Drumond on 09-08-2017.
 */

public class LoginValidation {

    LoginCallback callback;

    public LoginValidation(LoginCallback callback) {
        this.callback = callback;
    }

    public void validate() {
        if (new CurrentUser().getCurrent() != null) {
            callback.logged();
        } else {
            callback.signIn();
        }

    }
}

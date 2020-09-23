package com.example.loginwithviewmodelnav;

import com.google.firebase.auth.FirebaseAuth;

public class LoginResult{
    private static LoginResult instance;
    public static LoginResult getInstance(){
        if (instance == null)
        {
            instance = new LoginResult();
        }
        return instance;
    }
    public Status login(String email, String password) {
        if (FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).isSuccessful()) {
            return Status.SUCCESS;
        }
        return Status.UNSUCCESS;
    }

}

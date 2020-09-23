package com.example.loginwithviewmodelnav;

import com.google.firebase.auth.FirebaseAuth;

public class User {
    private static User user ;

    public static User getInstance()
    {
        if(FirebaseAuth.getInstance().getCurrentUser() != null)
        {
            user  = new User();
        }
        return user;
    }

}

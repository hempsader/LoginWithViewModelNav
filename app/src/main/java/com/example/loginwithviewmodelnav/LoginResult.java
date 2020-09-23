package com.example.loginwithviewmodelnav;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginResult {
    private static LoginResult instance;

    public static LoginResult getInstance() {
        if (instance == null) {
            instance = new LoginResult();
        }
        return instance;
    }

    public Status login(String email, String password) {
       FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).getResult();
        return Status.UNSUCCESS;
    }
}



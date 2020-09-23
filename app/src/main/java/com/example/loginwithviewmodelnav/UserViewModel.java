package com.example.loginwithviewmodelnav;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserViewModel extends ViewModel {
    private final MutableLiveData<Status> loginResultLiveData = new MutableLiveData<>();
    private final MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
    public LiveData<Status> getLoginResult()
    {
        return loginResultLiveData;
    }

    public void setLoginResultLiveData(String email, String password)
    {
        loginResultLiveData.setValue(LoginResult.getInstance().login(email,password));
    }

    public LiveData<User> getUser()
    {
        return mutableLiveData;
    }

    public void setUser(User user)
    {
        mutableLiveData.setValue(user);
    }


}

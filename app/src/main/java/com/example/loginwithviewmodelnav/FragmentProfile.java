package com.example.loginwithviewmodelnav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.loginwithviewmodelnav.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;


public class FragmentProfile extends Fragment {
    private UserViewModel viewModel;
    private FragmentProfileBinding binding;
    private  NavController controller;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
        controller = NavHostFragment.findNavController(getParentFragment());
        NavBackStackEntry backStackEntry = controller.getCurrentBackStackEntry();
        SavedStateHandle handle = backStackEntry.getSavedStateHandle();
        handle.getLiveData(FragmentLogin.LOGIN_SUCCESSFUL, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    int startDest = controller.getGraph().getStartDestination();
                    NavOptions navOptions = new NavOptions.Builder()
                            .setPopUpTo(startDest,true)
                            .build();
                    controller.navigate(startDest,null,navOptions);
                }
            }
        });


        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
            }
        });
        View v = binding.getRoot();
        viewModel.getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if(user == null)
                {
                    Log.d("aa","no user");
               Navigation.findNavController(getView()).navigate(R.id.fragmentLogin);
                    //catre login screen
                }else {
                    //ramai aici
                    Log.d("aa","user");
                }
            }
        });
        return v;
    }
}
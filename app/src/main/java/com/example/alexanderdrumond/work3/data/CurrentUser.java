package com.example.alexanderdrumond.work3.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Alexander Drumond on 09-08-2017.
 */

public class CurrentUser {

    private FirebaseUser current = FirebaseAuth.getInstance().getCurrentUser();

    public FirebaseUser getCurrent() {
        return current;
    }

    public String email(){
        return current.getEmail();
    }

    public String uid(){
        return current.getUid();
    }
}

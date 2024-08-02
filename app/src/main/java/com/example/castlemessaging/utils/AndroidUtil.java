package com.example.castlemessaging.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.castlemessaging.model.UserModel;

public class AndroidUtil {
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void passUserModelAsIntent(Intent intent, UserModel model){
        intent.putExtra("username", model.getUsername());
        intent.putExtra("phone", model.getPhone());
        intent.putExtra("userId", model.getUserId());
    }
}

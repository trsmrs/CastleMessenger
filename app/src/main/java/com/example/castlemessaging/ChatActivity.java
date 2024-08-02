package com.example.castlemessaging;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.castlemessaging.model.UserModel;
import com.example.castlemessaging.utils.AndroidUtil;

public class ChatActivity extends AppCompatActivity {

    UserModel otherUser;

    EditText messageInput;
    ImageButton sendMessageBtn;
    ImageButton backBtn;
    TextView otherUsername;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        otherUser = AndroidUtil.getUserModelFromIntent(getIntent());

        messageInput = findViewById(R.id.chat_message_input);
        sendMessageBtn = findViewById(R.id.message_send_btn);
        backBtn = findViewById(R.id.back_chat_btn);
        otherUsername = findViewById(R.id.other_username);
        recyclerView = findViewById(R.id.recycler_view_chat);

        backBtn.setOnClickListener((v)->{
            onBackPressed();
        });

        otherUsername.setText(otherUser.getUsername());
    }
}
package com.example.test;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.model.Contact;

public class infoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        Contact contact = (Contact) getIntent().getSerializableExtra("contact");

        TextView nameInfo = findViewById(R.id.nameInfo);
        TextView telInfo = findViewById(R.id.telInfo);
        TextView placeInfo = findViewById(R.id.placeInfo);
        TextView ageInfo = findViewById(R.id.ageInfo);

        nameInfo.setText(contact.getName());
        telInfo.setText(contact.getTel());
        placeInfo.setText(contact.getPlace());
        ageInfo.setText(contact.getAge());
    }
}

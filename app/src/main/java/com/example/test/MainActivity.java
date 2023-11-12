package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.test.adapters.ContactAdapter;
import com.example.test.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int callPermission = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, callPermission);
        }

        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Gabriel", "8714344865", "21", "UTT", "https://www.twitch.tv/"));
        contactList.add(new Contact("Jafeto", "8714384865", "19", "UTT", "https://www.tiktok.com/"));
        contactList.add(new Contact("Tilin", "8713344565", "22", "UTT", "https://www.twitch.tv/"));
        contactList.add(new Contact("Mami", "8711344415", "Who knows", "Pues es mi amá", "https://www.tiktok.com/"));
        contactList.add(new Contact("Luis", "8711244865", "23", "Dominos", "https://www.twitch.tv/"));

        ContactAdapter ca = new ContactAdapter(contactList);

        RecyclerView rv= findViewById(R.id.rcContacts);

        rv.setAdapter(ca);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
    }
}
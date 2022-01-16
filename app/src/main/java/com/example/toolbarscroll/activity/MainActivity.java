package com.example.toolbarscroll.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toolbarscroll.R;
import com.example.toolbarscroll.adapter.ContactAdapter;
import com.example.toolbarscroll.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        fillContactList();

        refreshAdapter();
    }

    void refreshAdapter() {
        ContactAdapter contactAdapter = new ContactAdapter(this, contacts);
        recyclerView.setAdapter(contactAdapter);
    }

    public void openDetailPage(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("contact", contacts.get(position));
        startActivity(intent);
    }

    void fillContactList() {
        for (int i = 1; i <= 30; i++) {
            contacts.add(new Contact("Contact_name" + i, "+(998)93-247-97-78"));
        }
    }
}
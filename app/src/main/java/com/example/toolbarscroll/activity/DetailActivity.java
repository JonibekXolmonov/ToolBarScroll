package com.example.toolbarscroll.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toolbarscroll.R;

public class DetailActivity extends AppCompatActivity {

    TextView contactName;
    TextView contactNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
    }

    void initViews() {
        contactName = findViewById(R.id.tv_name);

        contactName.setText(getIntent().getSerializableExtra("contact").toString());
    }
}
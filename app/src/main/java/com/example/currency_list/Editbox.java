package com.example.currency_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Editbox extends Dialog implements View.OnClickListener {

    EditText ed1,ed2;
    Button b1;
    public Activity c;
    DBManager dbManager = new DBManager(getContext());
    String s1,s2;


    public Editbox(@NonNull Activity content) {
        super(content);
        this.c =content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_editbox);
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);


//        setContentView(R.layout.activity_editbox);

    }


    @Override
    public void onClick(View view) {

        s1 = String.valueOf(ed1.getText());
        s2 = String.valueOf(ed2.getText());
        dbManager.Open();
        dbManager.Insert(s1,s2);
        dbManager.Close();


        dismiss();

    }
}
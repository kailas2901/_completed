package com.example.currency_list;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    List<String> simpleAdapter;
    ListView lv;
    private String m_Text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Editbox editbox = new Editbox(this);

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        lv = (ListView) findViewById(R.id.lv);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               editbox.show();


                Snackbar.make(view,"clicked",Snackbar.LENGTH_LONG).show();
                simpleAdapter = new ArrayList<>();
                simpleAdapter.add("India");
                simpleAdapter.add("Usa");
                simpleAdapter.add("japan");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,simpleAdapter);
                lv.setAdapter(adapter);
                registerForContextMenu(lv);
            }
        });
    }

    //context

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_context:
                Toast.makeText(this, "item add", Toast.LENGTH_SHORT).show();
                break;

            case R.id.delete_context:
                Toast.makeText(this, "delete item", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    //menu




    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);

        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.options_menu_add){
            Toast.makeText(this, "item add", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

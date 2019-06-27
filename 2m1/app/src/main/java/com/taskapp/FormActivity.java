package com.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editDesc = findViewById(R.id.editDesc);
        editTitle = findViewById(R.id.editTitle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickCancel(View view) {
        finish();
    }

    public void onClickSave(View view) {
        Task task = new Task();
        task.setDescription(editDesc.getText().toString());
        task.setTitle(editTitle.getText().toString());

        Intent intent = new Intent();
        intent.putExtra("taskobj",task);
        setResult(RESULT_OK,intent);
        finish();
    }
}

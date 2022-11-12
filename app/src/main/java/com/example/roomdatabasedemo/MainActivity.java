package com.example.roomdatabasedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabasedemo.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonAdd, buttonRest;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();

    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_Txt);
        buttonAdd = findViewById(R.id.button_Add);
        buttonRest = findViewById(R.id.button_rest);
        recyclerView = findViewById(R.id.recyclerView_Id);

        // initialize database
        database = RoomDB.getInstance(this);
        dataList = database.mainDao().getAll();

        // initialize Linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter  = new MainAdapter(dataList, MainActivity.this);
        recyclerView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sText = editText.getText().toString().trim();

                if (!sText.equals("")){
                    //when text is Empty
                    MainData mainData = new MainData();
                    mainData.setText(sText);
                    database.mainDao().insert(mainData);
                    getPostedData();
                    editText.setText("");
                    dataList.clear();
                    dataList.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        buttonRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mainDao().reset(dataList);
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void getPostedData() {
        new PostRepository().getPostedData(MainActivity.this);
    }
}
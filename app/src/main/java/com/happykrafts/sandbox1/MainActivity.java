package com.happykrafts.sandbox1;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private Button mBtnSave;
    private EditText mEtInfo;
    private TextView mTvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnSave = findViewById(R.id.bt_save);
        mEtInfo = findViewById(R.id.et_info);
        mTvStatus = findViewById(R.id.tv_status);
    }

    public void save(View view){
        File file = null;
        String text1 = mEtInfo.getText().toString();
        FileOutputStream fileOutputStream = null;
        try{
            file = getFilesDir();
            fileOutputStream = openFileOutput("RAHUL.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            mTvStatus.setTextColor(Color.GREEN);
            mTvStatus.setText(text1+"\n Written to\n"+file.getAbsolutePath());

        }catch (FileNotFoundException e){
            mTvStatus.setTextColor(Color.RED);
            mTvStatus.setText(e.toString());
        }
        catch (IOException e){
            mTvStatus.setTextColor(Color.RED);
            mTvStatus.setText(e.toString());
        }
    }
}

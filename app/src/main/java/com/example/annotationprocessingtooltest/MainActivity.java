package com.example.annotationprocessingtooltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ioc.ViewBinder;
import com.example.ioc_annotation.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewBinder.bind(this);


        TextView tv = findViewById(R.id.tv);
        if (textView != null) {
            tv.setText("ViewBinder初始化成功");
        }else {
            tv.setText("ViewBinder初始化失败");
        }
    }
}

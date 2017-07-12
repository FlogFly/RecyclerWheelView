package com.example.recyclewheelview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclewheelview.bean.OperationBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<OperationBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list.add(new OperationBean("AA\nAA","XXX","XXX","XXX"));
        list.add(new OperationBean("BB\nBB","XXX","XXX","XXX"));
        list.add(new OperationBean("CC\nCC","XXX","XXX","XXX"));
        list.add(new OperationBean("DD\nDD","XXX","XXX","XXX"));
        list.add(new OperationBean("EE\nEE","XXX","XXX","XXX"));
        list.add(new OperationBean("FF\nFF","XXX","XXX","XXX"));
        list.add(new OperationBean("GG\nGG","XXX","XXX","XXX"));

        recyclerView.setAdapter(new ItemAdapter(MainActivity.this, list));
        recyclerView.setOnScrollListener(new ScrollerListener(this));
        recyclerView.scrollToPosition(list.size() * 1000);
    }
}

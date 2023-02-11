package com.reo.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.reo.customlistview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    String [] data1 = {
            "문자열1","문자열2","문자열3","문자열4","문자열5",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // 어뎁터
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this, R.layout.row,R.id.textView2,data1
        );

        activityMainBinding.listView.setAdapter(adapter1);
        ListItemClickListener1 listItemClickListener1 = new ListItemClickListener1();
        activityMainBinding.listView.setOnItemClickListener(listItemClickListener1);
    }
    class ListItemClickListener1 implements AdapterView

            .OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String str1 = data1[position];
            activityMainBinding.textView.setText(str1);
        }
    }
}
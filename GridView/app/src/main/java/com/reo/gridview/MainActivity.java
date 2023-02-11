package com.reo.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.reo.gridview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    String [] data1 = {
            "그리드1","그리드2","그리드3","그리드4","그리드5",
            "그리드6","그리드7","그리드8","그리드9","그리드10",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data1);
        activityMainBinding.grid1.setAdapter(adapter1);

        GridItemClickListener1 gridItemClickListener1 = new GridItemClickListener1();
        activityMainBinding.grid1.setOnItemClickListener(gridItemClickListener1);
    }
    // 사용자가 항목을 터치했을 때..
    class GridItemClickListener1 implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            activityMainBinding.textView.setText(data1[position]);
        }
    }
}
package com.reo.singlechoicelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.reo.singlechoicelistview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    String [] data1 = {
            "항목1","항목2","항목3","항목4","항목5",
            "항목6","항목7","항목8","항목9","항목10",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //어뎁터생성
        ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_single_choice, data1
        );
        activityMainBinding.list1.setAdapter(adapter1);
        // single Choice 모드로 설정한다
        activityMainBinding.list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 항목을 선택한다.
        activityMainBinding.list1.setItemChecked(2,true);

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);
    }
    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int position = activityMainBinding.list1.getCheckedItemPosition();
            activityMainBinding.textView.setText(data1[position]);
        }
    }
}
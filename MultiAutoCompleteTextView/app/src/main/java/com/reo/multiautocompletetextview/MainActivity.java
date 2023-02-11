package com.reo.multiautocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import com.reo.multiautocompletetextview.databinding.ActivityMainBinding;

import java.lang.reflect.AccessibleObject;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    String[] data1 = {
            "abcd", "abca", "abcb", "abcc", "bbaa", "bbab", "bcab", "bdab"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        //어뎁터
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, data1
        );
        //구분자
        MultiAutoCompleteTextView.CommaTokenizer commaTokenizer = new MultiAutoCompleteTextView.CommaTokenizer();

        activityMainBinding.multiAutoCompleteTextView.setTokenizer(commaTokenizer);
        activityMainBinding.multiAutoCompleteTextView.setAdapter(adapter1);

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        // 항목을 터치했을 때.
        AutoClickListener1 autoClickListener1 = new AutoClickListener1();
        activityMainBinding.multiAutoCompleteTextView.setOnItemClickListener(autoClickListener1);
    }

    class ButtonClickListener1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 입력한 문자열을 가져온다.
            String str1 = activityMainBinding.multiAutoCompleteTextView.getText().toString();
            // 쉼표를 구분으로 나눈다.
            String[] strArray = str1.split(",");

            activityMainBinding.textView.setText(str1);

            for (String str2 : strArray) {
                if (str2.trim().length() > 0) {
                    activityMainBinding.textView.append(str2.trim() + "\n");
                }
            }
        }
    }

    // 항목을 클릭했을 때...
    class AutoClickListener1 implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            activityMainBinding.textView2.setText(
                    data1[position] + " 를 선택하였습니다");
        }
    }
}
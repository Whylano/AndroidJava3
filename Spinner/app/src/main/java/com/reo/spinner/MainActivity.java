package com.reo.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.reo.spinner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    String [] data1 = {
            "항목1","항목2","항목3","항목4","항목5",
            "항목6","항목7","항목8","항목9","항목10",
            "항목11","항목12","항목13","항목14","항목15",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // 어뎁터를 생성한다. (접혀져 있을 때의 모양을 설정)
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data1);
        // 펼쳐졌을 때의 모양을 설정한다.
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        activityMainBinding.spinner.setAdapter(adapter1);

        // 항목을 선택한다
        activityMainBinding.spinner.setSelection(2);

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button.setOnClickListener(buttonClickListener1);

        // 스피너의 항목을 선택했을 때
        SpinnerItemSelectedListener1 spinnerItemSelectedListener1 = new SpinnerItemSelectedListener1();
        activityMainBinding.spinner.setOnItemSelectedListener(spinnerItemSelectedListener1);
    }
    class ButtonClickListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // 현재 선택되어 있는 항목의 인덱스(위치값)을 가져온다.
            int position = activityMainBinding.spinner.getSelectedItemPosition();
            activityMainBinding.textView1.setText("선택한 항목 : "+ data1[position]);
        }
    }
    // 스피너에서 항목을 선택하였을 때..
    class SpinnerItemSelectedListener1 implements AdapterView.OnItemSelectedListener{
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

            //이벤트가 발생한 스피너의 id를 가져온다.
            int id = parent.getId();
            switch (id){
                case R.id.spinner:
                    activityMainBinding.textView2.setText(data1[position]+"항목을 선택하였습니다");
                break;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
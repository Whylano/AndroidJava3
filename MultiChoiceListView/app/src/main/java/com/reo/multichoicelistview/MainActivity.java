package com.reo.multichoicelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.reo.multichoicelistview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    String [] data1 ={
            "항목1","항목2","항목3","항목4","항목5","항목6","항목7","항목8",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_multiple_choice,data1
        );
        activityMainBinding.list1.setAdapter(adapter1);
        // 모드를 설정한다.
        activityMainBinding.list1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        // 원하는 항목의 체크 상태를 설정해준다.
        activityMainBinding.list1.setItemChecked(0,true);
        activityMainBinding.list1.setItemChecked(2,true);
        activityMainBinding.list1.setItemChecked(4,true);

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.list1.setOnClickListener(buttonClickListener1);
    }
    class ButtonClickListener1 implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            activityMainBinding.textView.setText("");
            // 현재 체크 상태에 관련된 객체를 가져온다.
            SparseBooleanArray boolArray = activityMainBinding.list1.getCheckedItemPositions();
            //activityMainBinding.textView.setText("개수 : "+ boolArray.size());
            for(int i = 0 ; i< boolArray.size();i++){
                // 체크 상태가 변경된 항목의 인덱스를 가져온다.
                int position = boolArray.keyAt(i);
                // 항목의 체크 상태를 가져온다.
                boolean chk = boolArray.get(position);

                //activityMainBinding.textView.append(i+ " " + position + " : "+ chk +"\n");

                // 해당 항목이 체크되어있는지 확인한다.
                if(chk == true){
                    activityMainBinding.textView.append(data1[position]+"\n");
                }
            }
        }
    }
}
package com.reo.customlistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.reo.customlistview2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    //rowImageView에 셋팅할 이미지
    int[] imgRes = {
            R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3,
            R.drawable.imgflag4, R.drawable.imgflag5, R.drawable.imgflag6,
            R.drawable.imgflag7, R.drawable.imgflag8
    };

    //rowTextView1에 셋팅할 문자열
    String[] data1 = {
            "토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국"
    };

    //rowTextView2에 셋팅할 문자열
    String[] data2 = {
            "togo", "france", "swiss", "spain", "japan", "german", "brazil", "korea"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //Simple Adapter에 셋팅을 데이터를 담을 ArrayList
        ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
        //데이터를 담는다
        for (int i = 0; i < imgRes.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            //데이터를 담는다
            map.put("img", imgRes[i]);
            map.put("data1", data1[i]);
            map.put("data2", data2[i]);
            //ArrayList에 담는다.
            dataList.add(map);
        }
        // HashMap에 데이터를 담을 때 사용한 이름 배열
        String[] keys = {"img", "data1", "data2"};
        //데이터를 셋팅한 View의 id 배열
        int[] ids = {R.id.rowImageView, R.id.rowTextView, R.id.rowTextView2};

        //SimpleAdapter를 생성한다.
        SimpleAdapter adapter1 = new SimpleAdapter(this, dataList, R.layout.row, keys, ids);
        activityMainBinding.list1.setAdapter(adapter1);

        ListItemClickListener1 listItemClickListener1 = new ListItemClickListener1();
        activityMainBinding.list1.setOnItemClickListener(listItemClickListener1);
    }

    class ListItemClickListener1 implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            activityMainBinding.textView.setText(data1[position] + "항목을 터치하였습니다");
        }
    }
}
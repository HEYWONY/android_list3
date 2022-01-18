package com.example.a220118_list3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 4개의 멤버 필드
    private ArrayList<String> mData = new ArrayList<String>();
    private int mNextNumber;
    private ListView mList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //초기 리스트 항목을 몇 개 보일 건지
        for (int i=0; i<=5; i++) {
            mData.add("항목" + i);
        }
        mNextNumber = 6;

        mList = (ListView) findViewById(R.id.list);
        mAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_single_choice, mData);
        mList.setAdapter(mAdapter);
        mList.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                mData.add("항목" + mNextNumber);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.btnRemove:
                //현재 인덱스 확인하기
                int index = mList.getCheckedItemPosition();
                if(index != AdapterView.INVALID_POSITION) { //위치값이 동일하지 않으면
                    mList.clearChoices();
                    mData.remove(index);
                    mAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
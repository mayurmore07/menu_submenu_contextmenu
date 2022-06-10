package com.example.menu_submenu_contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Second_activity extends Activity {

    ListView list;
    String[] commentlist={"Pushkaraj","Kedar","Pratik","Siddhesh","Yash"};
    int frindlistlist;
    ArrayAdapter<String>arrayAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.second_activity);
          initView();
          

    }
    public void initView(){

        list=findViewById(R.id.list);
    }
}

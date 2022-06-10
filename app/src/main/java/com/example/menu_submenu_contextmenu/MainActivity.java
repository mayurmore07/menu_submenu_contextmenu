package com.example.menu_submenu_contextmenu;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int optionId;
    CheckBox checkbox;
    ImageView image;

    int contextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        registerForContextMenu(image);
    }

    public void initView(){
        image=findViewById(R.id.image);
       checkbox=findViewById(R.id.checkbox);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenuSettings=menu.addSubMenu(3,3,3,"Settings");

            subMenuSettings.add(3,4,1,"Account");
            subMenuSettings.add(3,5,2,"Chats");
            subMenuSettings.add(3,6,3,"Notifications");
            subMenuSettings.add(3,7,4,"Storage");

        MenuItem menuItemnewgroup=menu.add(1,1,1,"New Group");
        MenuItem menuItemHelp=menu.add(2,2,2,"Help");

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.setGroupEnabled(3, checkbox.isChecked());
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        optionId=item.getItemId();

        switch (optionId){
            case 1:
                toast("New Group");
                break;

            case 2:
                toast("Help");
                break;

            case 3:
                toast("Settings");
                break;

            case 4:
                toast("Account");
                break;

            case 5:
                toast("Chats");
                break;

            case 6:
                toast("Notifications");
                break;

            case 7:
                toast("Storage");
        }
        return true;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.contextmenu,menu);
        menu.setHeaderTitle("Context Menus");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        contextId = item.getItemId();

        switch (contextId) {
            case R.id.item1:
                toast("Download");
                break;

            case R.id.item2:
                toast("Like");
                break;

            case R.id.item3:
                toast("Dislike");
                break;

            case R.id.item4:
                toast("Save");
                break;

            case R.id.item5:
                toast("Comment");
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog.setTitle("Second Activity");
                alertdialog.setMessage("Go to next Activity?");
                alertdialog.setPositiveButton("Yes", new YesClickListener());
                alertdialog.setNegativeButton("Cancel",new CancelClickListener());
                alertdialog.show();
                break;
               // break;

            case R.id.item6:
                toast("Size");
                break;

        }

        return super.onContextItemSelected(item);


    }

public class YesClickListener implements DialogInterface.OnClickListener{
    @Override
    public void onClick(DialogInterface dialog, int which) {
        Intent intent =new Intent(MainActivity.this,Second_activity.class);
        startActivity(intent);
        toast("Second Activity");

    }
}
public class CancelClickListener implements DialogInterface.OnClickListener{
    @Override
    public void onClick(DialogInterface dialog,int which) {
        toast("MainActivity");



    }
}

    public void toast(String text) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}


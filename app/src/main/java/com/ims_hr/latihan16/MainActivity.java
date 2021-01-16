package com.ims_hr.latihan16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ims_hr.latihan16.setting.GlobalVar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Adapter_Array> listData;
    ListView LV_Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Set_Object();
        Listen_LV();
    }

    private void Inisial() {
        listData = new ArrayList<>();
        float Rating_1 = (float) 4.5;
        float Rating_2 = (float) 3.5;
        String Desc_1 = getString(R.string.bio1);
        String Desc_2 = getString(R.string.bio2);
        String Role_1 = getString(R.string.role1);
        String Role_2 = getString(R.string.role2);
        //listData.clear();
        listData.add(new Adapter_Array("EARTHSHAKER",Role_1,R.drawable.img_1,Rating_1 ,Desc_1));
        listData.add(new Adapter_Array("ANTI-MAGE",Role_2,R.drawable.img_2,Rating_2 ,Desc_2));
        LV_Data = findViewById(R.id.listView_Main_Data);
    }

    private void Set_Object() {
        Adapter_List adapter = new Adapter_List(MainActivity.this,R.layout.template_list,listData);
        LV_Data.setAdapter(adapter);
    }

    private void Listen_LV() {
        LV_Data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra(GlobalVar.EXTRA_NAMA,listData.get(position).Header);
                intent.putExtra(GlobalVar.EXTRA_ROLE,listData.get(position).Role);
                intent.putExtra(GlobalVar.EXTRA_DESC,listData.get(position).Desc);
                intent.putExtra(GlobalVar.EXTRA_RATING,listData.get(position).Rating);
                intent.putExtra(GlobalVar.EXTRA_GAMBAR,listData.get(position).ResID);
                startActivity(intent);
            }
        });
    }

}

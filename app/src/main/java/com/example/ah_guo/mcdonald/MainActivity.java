package com.example.ah_guo.mcdonald;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  clickListener(View v) {
        Intent it = new Intent(MainActivity.this, ChickenNuggets.class);
        it.putExtra("id", v.getId());
        startActivity(it);
    }
}



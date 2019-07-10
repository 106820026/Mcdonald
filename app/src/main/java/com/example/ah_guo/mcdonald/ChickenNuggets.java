package com.example.ah_guo.mcdonald;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class ChickenNuggets extends AppCompatActivity {

    private ImageView countdownImg;
    private ImageView countdowning;
    private ImageView main;
    private TextView timer;
    private AlertDialog.Builder builder;
    private Button dialogButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_nuggets);
        Toolbar toolbar = findViewById(R.id.tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        Intent it = getIntent();
        int ID = it.getIntExtra("id",0);
        countdownImg = findViewById(R.id.img_countdown_button);
        countdowning = findViewById(R.id.countdowning);
        timer = findViewById(R.id.timer);
        main = findViewById(R.id.main);
        countdownImg.setOnClickListener(clickListener);
        dialogButton = findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(clickListener);
        switch (ID){
            case R.id.chickenNugget:
                main.setImageResource(R.drawable.img_4chicken_nugget);
                break;
            case R.id.hashBrown:
                main.setImageResource(R.drawable.hashbrowns);
                break;
            case R.id.chickenNeggutBuy1Get1:
                main.setImageResource(R.drawable.chicken_neggut_buy1get1);
                break;
        }

    }

    public View.OnClickListener clickListener =  new  View.OnClickListener()
    {
        public void  onClick(View v){
            showAlertDialog(v);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog(View view){
        builder = new AlertDialog.Builder(this,R.style.AlertDialogStyle);
        builder.setTitle(R.string.confirm);
        builder.setMessage(R.string.dialogMessage);

        builder.setNegativeButton(R.string.notNow,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });
        builder.setPositiveButton(R.string.yesIDo,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                countdowning.setVisibility(View.VISIBLE);
                new CountDownTimer(120000, 1000) {

                    @Override
                    public void onFinish() {
                    }

                    @Override
                    public void onTick(long millisUntilFinished) {
                        timer.setVisibility(View.VISIBLE);
                        timer.setText("" + millisUntilFinished / 1000 / 60 + ":" + millisUntilFinished / 1000 % 60 / 10 + millisUntilFinished / 1000 % 60 % 10);
                    }

                }.start();
            }
        });
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }


}
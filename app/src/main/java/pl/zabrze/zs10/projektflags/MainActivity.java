package pl.zabrze.zs10.projektflags;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timer;
    int sekundy = 10;
    TextView textviewCzas, textViewWrozba, textViewDzien;
    LinearLayout linearLayout;
    Button buttonStart, buttonWrozba, buttonRating;
    Switch switchMotyw;
    ImageView imageView;
    ArrayList<Wrozba> wrozby = RepozytoriumWrozb.zwrocWrozbe();
    int losowana;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textviewCzas = findViewById(R.id.textViewCzas);
        textViewDzien = findViewById(R.id.textViewDzien);
        textViewWrozba = findViewById(R.id.textViewWrozba);
        buttonStart = findViewById(R.id.startTimer);
        buttonWrozba = findViewById(R.id.buttonWrozba);
        switchMotyw = findViewById(R.id.switchMotyw);
        linearLayout = findViewById(R.id.Linearfull);
        ratingBar = findViewById(R.id.ratingBar4);
        imageView = findViewById(R.id.imageViewPoraDnia);
        buttonRating = findViewById(R.id.buttonR);
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        timer = new CountDownTimer(sekundy * 1000, 1000) {
                            @Override
                            public void onTick(long l) {
                                sekundy = (int) l / 100;
                                textviewCzas.setText(String.valueOf(sekundy/10));
                                textviewCzas.setBackgroundResource(R.color.white);
                            }

                            @Override
                            public void onFinish() {
                                textviewCzas.setText("Koniec czasu!");
                                textviewCzas.setBackgroundResource(R.color.purple_200);
                                linearLayout.setBackgroundResource(R.color.teal_200);
                            }
                        };
                        timer.start();
                    }
                }
        );
        buttonWrozba.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        losowana = (int) (Math.random()* wrozby.size());
                        wyswietlWrozbe(losowana);
                    }
                }
        );
        switchMotyw.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(switchMotyw.isChecked()){
                            linearLayout.setBackgroundResource(R.color.purple_700);
                            imageView.setImageResource(R.drawable.moon);
                            textviewCzas.setTextColor(Color.parseColor("#FFFFFF"));
                            textViewDzien.setTextColor(Color.parseColor("#FFFFFF"));
                            textViewWrozba.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        else{
                            linearLayout.setBackgroundResource(R.color.white);
                            imageView.setImageResource(R.drawable.sun);
                            textviewCzas.setTextColor(Color.parseColor("#000000"));
                            textViewDzien.setTextColor(Color.parseColor("#000000"));
                            textViewWrozba.setTextColor(Color.parseColor("#000000"));
                        }
                    }
                }
        );
        buttonRating.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //String totalStars = "Suma gwiazdek: " + ratingBar.getNumStars();
                        String rating = "Ocena : " + ratingBar.getRating();
                        int ocenianie = (int) ratingBar.getRating();
                            if (ocenianie <= 1) {
                                linearLayout.setBackgroundResource(R.color.darkred);
                            } else if (ocenianie <= 2) {
                                linearLayout.setBackgroundResource(R.color.red);
                            } else if (ocenianie <= 3) {
                                linearLayout.setBackgroundResource(R.color.yellow);
                            } else if (ocenianie <= 4) {
                                linearLayout.setBackgroundResource(R.color.lightgreen);
                            } else {
                                linearLayout.setBackgroundResource(R.color.green);
                            }
                        textViewDzien.setText(rating);
                    }
                }
        );

    }
    private void wyswietlWrozbe(int i){
        textViewWrozba.setText(wrozby.get(i).getWrozba());
    }
}
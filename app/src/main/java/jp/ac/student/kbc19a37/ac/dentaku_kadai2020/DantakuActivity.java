package jp.ac.student.kbc19a37.ac.dentaku_kadai2020;

import android.annotation.SuppressLint;
import android.graphics.Color;
//import android.media.AudioAttributes;
//import android.media.AudioManager;
//import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.Locale;

public class DantakuActivity extends AppCompatActivity {

    LinearLayout buttonPadLinearLayout;

    final String[] buttonTexts =
            {"AC", "C", "Del", "÷",
                    "7", "8", "9", "×",
                    "4", "5", "6", "-",
                    "1", "2", "3", "+",
                    "±", "0", ".", "="};

    final String[] buttonTags = {
            "allclear", "clear", "delete", "divide",
            "seven", "eight", "nine", "multiply",
            "four", "five", "six", "minus",
            "one", "two", "three", "plus",
            "sign", "zero", "dot", "equal"};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentaku);
        this.buttonPadLinearLayout =
                findViewById(R.id.buttonPadLinearLayout);


        final ButtonClickListener buttonClickListener =
                new ButtonClickListener(
                        (TextView) findViewById(R.id.operand1),
                        (TextView) findViewById(R.id.operator),
                        (TextView) findViewById(R.id.operand2)
                );




        //LinearLayoutとButtonをforループで生成して追加する
        for (int i = 0; i < 5; ++i) {
            final LinearLayout newLL = new LinearLayout
                    (this.getApplicationContext());
            newLL.setBackgroundColor(Color.parseColor("#ffff66"));
            newLL.setOrientation(LinearLayout.HORIZONTAL);
            final ViewGroup.LayoutParams newLP =
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonPadLinearLayout.addView(newLL, newLP);

            for (int j = 0; j < 4; ++j) {
                final Button b = new Button
                        (this.getApplicationContext());
                //b.setText(i + "," + j);
                b.setBackgroundColor(Color.parseColor("#ff8800"));
                b.setText(buttonTexts[i * 4 + j]);
                b.setTextSize(22);
                b.setTextColor(Color.WHITE);
                //同じイベントリスナで複数のボタンを処理する際にボタンを識別するためタグをつける
                //各ボタンにIDをつけて識別することもできる
                b.setTag(buttonTags[i * 4 + j]);
                b.setOnClickListener(buttonClickListener);




                final LinearLayout.LayoutParams lllp =
                        new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);
                lllp.bottomMargin = 5;
                lllp.topMargin = 5;
                lllp.leftMargin = 5;
                lllp.rightMargin = 5;
                newLL.addView(b, lllp);
            }//for j
        }//for i

        ImageView imageView = (ImageView) findViewById(R.id.gifImage);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.kaeru).into(target);

    }//onCreate


}//DentakuActivity
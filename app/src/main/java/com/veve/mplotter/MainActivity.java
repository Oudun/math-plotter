package com.veve.mplotter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;

import com.veve.mplotter.mathplotter.R;
import com.veve.mplotter.model.Formula;
import com.veve.mplotter.model.impl.FormulaEmpty;
import com.veve.mplotter.model.impl.FormulaOneArg;

import static android.graphics.Bitmap.Config.ARGB_8888;

public class MainActivity extends AppCompatActivity {

    Formula rootFunction = null;

    Canvas canvas;

    Bitmap bitmap;

    ImageView imageView;

    Paint fillPaint;

    Paint textPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        textPaint = new Paint();
        textPaint.setTextSize(50);

        fillPaint = new Paint();
        fillPaint.setColor(Color.WHITE);
        fillPaint.setStyle(Paint.Style.FILL);

        rootFunction = new FormulaEmpty();

        setContentView(R.layout.activity_main);

        Button oneParamButton = findViewById(R.id.one_param);
        oneParamButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rootFunction = new FormulaOneArg();
                update();
            }
        });

        imageView = findViewById(R.id.formula);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(
            new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight() , ARGB_8888);
                    update();
                }
            });

    }

    public void update() {
        canvas = new Canvas(bitmap);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), fillPaint);
        rootFunction.plot(canvas, textPaint);
        imageView.setImageBitmap(bitmap);
    }















}

package com.veve.mplotter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.Suppress;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;

import com.veve.mplotter.mathplotter.R;
import com.veve.mplotter.model.Formula;
import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;
import com.veve.mplotter.model.impl.FormulaEmpty;
import com.veve.mplotter.model.impl.FormulaOneArg;
import com.veve.mplotter.model.impl.FormulaTwoArgs;
import com.veve.mplotter.model.impl.FunctionUnknown;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Bitmap.Config.ARGB_8888;

public class MainActivity extends AppCompatActivity {

    Formula formula = null;

    Canvas canvas;

    Bitmap bitmap;

    ImageView imageView;

    Paint fillPaint, textPaint;

    List<Function> functions;

    FormulaContext context;

    @Override
    @SuppressWarnings("ALL")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        textPaint = new Paint();
        textPaint.setTextSize(50);

        fillPaint = new Paint();
        fillPaint.setColor(Color.WHITE);
        fillPaint.setStyle(Paint.Style.FILL);

        formula = new FormulaEmpty();

        setContentView(R.layout.activity_main);

        Button oneParamButton = findViewById(R.id.one_param);
        oneParamButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (formula != null && formula.getFunction() != null)
                formula = new FormulaOneArg();
                formula.setFunction(new FunctionUnknown());
                update();
            }
        });

        Button twoParamsButton = findViewById(R.id.two_params);
        twoParamsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                formula = new FormulaTwoArgs();
                formula.setFunction(new FunctionUnknown());
                update();
            }
        });

        imageView = findViewById(R.id.formula);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(
            new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    bitmap = Bitmap.createBitmap(
                            imageView.getWidth(),
                            imageView.getHeight(),
                            ARGB_8888);
                    context = new FormulaContext();
                    canvas = new Canvas(bitmap);
                    context.setCanvas(canvas);
                    context.setStartPoint(new Point(0, 0));
                    context.setTextPaint(textPaint);
                    update();
                }
            });
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(getClass().getName(),
                        String.format("Coordinates are X:%d Y:%d",
                                (int)event.getX(), (int)event.getY()));
                Log.i(getClass().getName(), String.format("Selected function id is %d",
                        formula.getSelectedFunction((int)event.getX(), (int)event.getY(), context)));
                return true;
            }
        });

    }

    public void update() {
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), fillPaint);
        formula.plot(context);
        imageView.setImageBitmap(bitmap);
    }
//














}

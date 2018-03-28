package com.veve.mplotter.model.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.veve.mplotter.model.Formula;

/**
 * Created by ddreval on 3/27/2018.
 */

public class FormulaEmpty implements Formula {

    @Override
    public void plot(Canvas canvas, Paint paint) {
        String pleaseSelect = "Please select function type";
        Rect rect = new Rect();
        paint.getTextBounds(pleaseSelect, 0, pleaseSelect.length(), rect);
        canvas.drawText(pleaseSelect, (canvas.getWidth()-rect.width())/2, (canvas.getHeight()+rect.height())/2, paint);
    }

}

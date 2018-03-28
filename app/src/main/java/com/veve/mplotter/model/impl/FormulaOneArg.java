package com.veve.mplotter.model.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.veve.mplotter.model.Formula;

/**
 * Created by ddreval on 3/27/2018.
 */

public class FormulaOneArg implements Formula {

    @Override
    public void plot(Canvas canvas, Paint paint) {
        String formulaStr = "f(x) = ";
        Rect rect = new Rect();
        paint.getTextBounds(formulaStr, 0, formulaStr.length(), rect);
        canvas.drawText(formulaStr, (canvas.getWidth()-rect.width())/2, (canvas.getHeight()+rect.height())/2, paint);
    }

}

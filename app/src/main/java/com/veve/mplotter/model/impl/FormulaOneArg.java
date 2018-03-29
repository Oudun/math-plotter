package com.veve.mplotter.model.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.veve.mplotter.model.Formula;
import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;

/**
 * One argument formula stub
 * Created by ddreval on 3/27/2018.
 */

public class FormulaOneArg extends AbstractFormula {

    @Override
    public void plot(FormulaContext context) {

        String formulaStr = "f(x)=";
        int width, height, offsetX, offsetY;
        Rect rect = new Rect();
        context.getTextPaint().measureText(formulaStr);
        context.getTextPaint().getTextBounds(formulaStr, 0, formulaStr.length(), rect);
        width = rect.width() + function.getBounds(context).width();
        height = Math.max(rect.height(), function.getBounds(context).height());
        offsetX = (context.getCanvas().getWidth() - width)/2;
        offsetY = (context.getCanvas().getHeight() +height)/2;
        context.getCanvas().drawText(formulaStr, offsetX, offsetY, context.getTextPaint());

        context.setStartPoint(new Point(offsetX + rect.width(), offsetY));
        function.plot(context);
    }

}

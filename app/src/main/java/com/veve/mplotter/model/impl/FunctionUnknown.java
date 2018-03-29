package com.veve.mplotter.model.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;

/**
 * Created by ddreval on 3/28/2018.
 */

public class FunctionUnknown extends AbstractFunction {

    public static final String STRING = "?";

    @Override
    public void plot(FormulaContext context) {
        context.getCanvas().drawText(STRING,
                context.getStartPoint().x, context.getStartPoint().y, context.getTextPaint());
    }

    @Override
    public Float calculate() {
        return null;
    }

    @Override
    public Rect getBounds(FormulaContext context) {
        Rect rect = new Rect();
        context.getTextPaint().getTextBounds(STRING, 0, STRING.length(), rect);
        return rect;
    }

    @Override
    public int getSelectedFunction(int x, int y, FormulaContext context) {
        Rect rect = getBounds(context);
        if (rect.contains(x, y)) {
            return id;
        } else {
            return -1;
        }
    }

}

package com.veve.mplotter.model.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.veve.mplotter.model.Formula;
import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;

/**
 * Created by ddreval on 3/28/2018.
 */

public class FormulaTwoArgs extends AbstractFormula {

    @Override
    public void plot(FormulaContext context) {
        String formulaStr = "f(x, y)=?";
        Rect rect = new Rect();
        context.getTextPaint().getTextBounds(formulaStr, 0, formulaStr.length(), rect);
        context.getCanvas().drawText(formulaStr,
                (context.getCanvas().getWidth()-rect.width())/2,
                (context.getCanvas().getHeight()+rect.height())/2, context.getTextPaint());
    }

}

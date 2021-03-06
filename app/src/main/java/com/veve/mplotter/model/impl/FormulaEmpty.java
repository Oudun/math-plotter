package com.veve.mplotter.model.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.veve.mplotter.model.Formula;
import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;

/**
 * Designed to represent a stub when real function is not yet selected
 * Created by ddreval on 3/27/2018.
 */

public class FormulaEmpty extends AbstractFormula {

    @Override
    public void plot(FormulaContext context) {
        String pleaseSelect = "Please select function type";
        Rect rect = new Rect();
        context.getTextPaint().getTextBounds(pleaseSelect, 0, pleaseSelect.length(), rect);
        context.getCanvas().drawText(pleaseSelect,
                (context.getCanvas().getWidth()-rect.width())/2,
                (context.getCanvas().getHeight()+rect.height())/2, context.getTextPaint());
    }

    @Override
    public Function getFunction() {
        return null;
    }

    @Override
    public void setFunction(Function function) {

    }

}

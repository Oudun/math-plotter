package com.veve.mplotter.model.impl;

import android.graphics.Rect;

import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;

/**
 * Created by ddreval on 3/29/2018.
 */

public abstract class FunctionOneArg extends AbstractFunction {

    Function argument;

    @Override
    public void plot(FormulaContext context) {

    }

    @Override
    public Float calculate() {
        return argument.calculate();
    }

    @Override
    public Rect getBounds(FormulaContext context) {
        return null;
    }

    @Override
    public int getSelectedFunction(int x, int y, FormulaContext context) {
        Rect rect = getBounds(context);
        if (argument.getBounds(context).contains(x, y)) {
            return argument.getSelectedFunction(x, y, context);
        } else if (rect.contains(x, y)) {
            return id;
        } else {
            return -1;
        }
    }

}

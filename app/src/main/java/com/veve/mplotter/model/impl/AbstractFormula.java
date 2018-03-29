package com.veve.mplotter.model.impl;

import com.veve.mplotter.model.Formula;
import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;

/**
 * Base class to implement formula
 * Created by ddreval on 3/29/2018.
 */

public abstract class AbstractFormula implements Formula {

    protected Function function;

    @Override
    public Function getFunction() {
        return function;
    }

    @Override
    public void setFunction(Function function) {
        this.function = function;
    }

    @Override
    public int getSelectedFunction(int x, int y, FormulaContext context) {
        return function.getSelectedFunction(x, y, context);
    }

}



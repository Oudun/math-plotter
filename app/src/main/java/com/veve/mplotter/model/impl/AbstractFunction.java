package com.veve.mplotter.model.impl;

import android.graphics.Rect;

import com.veve.mplotter.model.FormulaContext;
import com.veve.mplotter.model.Function;

/**
 * Created by ddreval on 3/29/2018.
 */

public abstract class AbstractFunction implements Function {

    protected static int counter = 0;

    protected int id;

    public AbstractFunction() {
        id = counter++;
    }

    @Override
    public int getId() {
        return id;
    }

}

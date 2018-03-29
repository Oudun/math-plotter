package com.veve.mplotter.model;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by ddreval on 3/26/2018.
 */

public interface Formula {

    public void plot(FormulaContext context);

    public Function getFunction();

    public void setFunction(Function function);

    public int getSelectedFunction(int x, int y, FormulaContext context);

}

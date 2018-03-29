package com.veve.mplotter.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by ddreval on 3/26/2018.
 */

public interface Function {

    public void plot(FormulaContext context);

    public Float calculate();

    public Rect getBounds(FormulaContext context);

    public int getId();

    public int getSelectedFunction(int x, int y, FormulaContext context);

}

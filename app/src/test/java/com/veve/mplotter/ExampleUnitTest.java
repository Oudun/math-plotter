package com.veve.mplotter;

import com.veve.mplotter.model.Function;
import com.veve.mplotter.model.impl.FunctionUnknown;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void ids_areCorrect() throws Exception {
        Function f1 = new FunctionUnknown();
        assertEquals(0, f1.getId());
        Function f2 = new FunctionUnknown();
        assertEquals(1, f2.getId());
    }


}
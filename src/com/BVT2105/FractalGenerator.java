package com.BVT2105;

import java.awt.geom.Rectangle2D;


/**
 * Этот класс предоставляет общий интерфейс и операции для FractalGenerator, которые можно просмотреть в Fractal Explorer
 */
public abstract class FractalGenerator {

    public static double getCoord(double rangeMin, double rangeMax,
                                  int size, int coord) {

        assert size > 0;
        assert coord >= 0 && coord < size;

        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }


    /**
     *задает начальный диапазон для рендеринга
     */
    public abstract void getInitialRange(Rectangle2D.Double range);


    /**
     * Обновляет текущий диапазон, чтобы он был центрирован в указанных координатах
     * и увеличивался или уменьшался на указанный коэффициент масштабирования.
     */
    public void recenterAndZoomRange(Rectangle2D.Double range,
                                     double centerX, double centerY, double scale) {

        double newWidth = range.width * scale;
        double newHeight = range.height * scale;

        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }


    /**
     * Должно возвращать количество итераций до того, как функция "экранируется", учитывая координату.
     * Или -1, если это никогда не произойдет.
     */
    public abstract int numIterations(double x, double y);
}
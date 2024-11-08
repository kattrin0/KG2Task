package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;


public class Rasterization {

    public static void drawRectangle(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int width, final int height,
            final Color color) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int row = y; row < y + height; ++row)
            for (int col = x; col < x + width; ++col)
                pixelWriter.setColor(col, row, color);
    }

    public static void drawEllipse(final GraphicsContext graphicsContext,
                                   final int x, final int y,
                                   final int width, final int height,
                                   Interpolation interpolation) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        final int xCenter = x + width / 2;
        final int yCenter = y + height / 2;
        final int a = width / 2;
        final int b = height / 2;

        for (int row = y; row < y + height; row += 1) {
            int xLeft = (int) (xCenter - (a / (double) b) * Math.sqrt(Math.pow(b, 2) - Math.pow(row - yCenter, 2)));
            int xRight = (int) (xCenter + (a / (double) b) * Math.sqrt(Math.pow(b, 2) - Math.pow(row - yCenter, 2)));

            for (int col = xLeft; col < xRight; col += 1) {
                Color interpolatedColor = interpolation.interpolationFromCenter(x, y, col, row, width, height);
                pixelWriter.setColor(col, row, interpolatedColor);
            }
        }
    }
}

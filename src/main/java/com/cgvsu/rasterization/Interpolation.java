package com.cgvsu.rasterization;

import javafx.scene.paint.Color;

public class Interpolation {
    private Color centerColor;
    private Color endColor;

    public Interpolation(Color centerColor, Color endColor) {
        this.centerColor = centerColor;
        this.endColor = endColor;
    }

    public Color interpolationFromCenter(int x, int y, int col, int row, int width, int height) {
        final int xCenter = x + width / 2;
        final int yCenter = y + height / 2;
        final int a = width / 2;
        final int b = height / 2;
        double distance;
        double normalizedDistance;

        if (width > height) {
            distance = Math.sqrt(Math.pow((col - xCenter), 2) + Math.pow((double) (row - yCenter) * a / b, 2));
        } else {
            distance = Math.sqrt(Math.pow((double) (col - xCenter) * b / a, 2) + Math.pow((row - yCenter), 2));
        }
        double maxDistance = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        normalizedDistance = distance / maxDistance;

        double red = centerColor.getRed() + normalizedDistance * (endColor.getRed() - centerColor.getRed());
        double green = centerColor.getGreen() + normalizedDistance * (endColor.getGreen() - centerColor.getGreen());
        double blue = centerColor.getBlue() + normalizedDistance * (endColor.getBlue() - centerColor.getBlue());
        return Color.color(red, green, blue);
    }
}


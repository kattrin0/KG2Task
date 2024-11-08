package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        //Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 200, 300, 200, 100, Color.GREEN, Color.RED);
        //Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 300, 200, 100, 200,Color.GREEN, Color.RED);

        //body
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 200, 100, 250, 150, Color.GREY, Color.rgb(31, 94, 94));

        //legs
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 210, 230, 80, 50, Color.rgb(31, 94, 94), Color.GREY);
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 360, 230, 80, 50, Color.rgb(31, 94, 94), Color.GREY);

        //ears
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 180, 0, 40, 65, Color.rgb(31, 94, 94), Color.GREY);
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 200, 0, 40, 65, Color.rgb(31, 94, 94), Color.GREY);

        //head
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 140, 50, 115, 115, Color.rgb(31, 94, 94), Color.GREY);
        //eye
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 195, 90, 25, 20, Color.BLACK, Color.BLACK);
        //tail
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 400, 90, 50, 50, Color.GREY, Color.BLACK);
    }

}
package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.text.Font;
import javafx.scene.text.Font;
import javafx.scene.text.Font;
import javafx.scene.text.Font;
import javafx.scene.text.Font;
import javafx.util.Duration;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class main extends Application {
    private Canvas canvas;

    //Data for Bar Chart
    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    //Data for Pie Chart
    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };


    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 900, 700);


        canvas = new Canvas();
        canvas.setHeight(700);
        canvas.setWidth(900);

        root.getChildren().add(canvas);
        primaryStage.setTitle("Lab 6");
        primaryStage.setScene(scene);
        primaryStage.show();

        draw(root);
    }
    private void draw(Group group) {

        GraphicsContext gc = canvas.getGraphicsContext2D();


        //Double Bar Graph

        double y = 450;
        int x = 50;
        int height = 100;
        double heightMutiply = 1;

        gc.setFill(Color.RED);

        for (int i = 0; i < avgHousingPricesByYear.length; i++) {
            heightMutiply = avgHousingPricesByYear[i] / avgHousingPricesByYear[0];
            y -= ((height * heightMutiply) - height);
            gc.fillRect(x, y, 10, height * heightMutiply);
            x += 30;
            y = 450;
        }

        x = 60;
        y = 350;
        height = 200;
        gc.setFill(Color.BLUE);

        for (int i = 0; i < avgCommercialPricesByYear.length; i++) {

            heightMutiply = avgCommercialPricesByYear[i] / avgCommercialPricesByYear[0];
            y -= ((height * heightMutiply) - height);
            gc.fillRect(x, y, 10, height * heightMutiply);
            x += 30;
            y = 350;
        }



        double startAngle = 0;
        double extendAngle = 0;
        double total = 0;

        for (double purchase : purchasesByAgeGroup) {
            total += purchase;
        }



        //Pie chart

        for (int i =0; i < ageGroups.length; i++) {
            gc.setFill(pieColours[i]);
            startAngle += extendAngle;
            extendAngle = (purchasesByAgeGroup[i] / total) * 360;
            gc.fillArc(400, 300, 200, 200, startAngle, extendAngle, ArcType.ROUND);
            gc.setStroke(Color.BLACK);
            gc.strokeArc(400, 300, 200, 200, startAngle, extendAngle, ArcType.ROUND);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.Group;;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.canvas.GraphicsContext;
import java.io.*;
import  java.util.*;



public class main extends Application {
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Lab 7");
        Scene scene = new Scene(root, 800, 500);

        canvas = new Canvas();

        canvas.setHeight(500);
        canvas.setWidth(800);

        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.show();

        draw(root);
    }

    private void draw(Group group) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        TreeMap<String, Integer> count = new TreeMap<>();
        count = getCount();


        //Calculates total number of words
        int countTotal = 0;
        for (int num : count.values()) {
            countTotal += num;
        }

        double startAngle = 0;
        double extendAngle = 0;

        gc.setStroke(Color.BLACK);
        Font font = new Font("Times New Roman", 10);
        gc.setFont(font);
        for (String name : count.keySet()) {
            if (name.equals("FLASH FLOOD")) {
                gc.setFill(Color.BLACK);
                gc.strokeRect(100, 70, 50, 20);
                gc.fillText("FLASH FLOOD", 160, 85);
                gc.setFill(Color.AQUA);
                gc.fillRect(100, 70, 50, 20);

            } else if (name.equals("SEVERE THUNDERSTORM")) {
                gc.setFill(Color.BLACK);
                gc.strokeRect(100, 130, 50, 20);
                gc.fillText("SEVERE THUNDERSTORM", 155, 145);
                gc.setFill(Color.GOLD);
                gc.fillRect(100, 130, 50, 20);

            } else if (name.equals("SPECIAL MARINE")) {
                gc.setFill(Color.BLACK);
                gc.strokeRect(100, 210, 50, 20);
                gc.fillText("SPECIAL MARINE", 155, 225);
                gc.setFill(Color.DARKORANGE);
                gc.fillRect(100, 210, 50, 20);

            } else if (name.equals("TORNADO")) {
                gc.setFill(Color.BLACK);
                gc.strokeRect(100, 290, 50, 20);
                gc.fillText("TORNADO", 160, 305);
                gc.setFill(Color.DARKSALMON);
                gc.fillRect(100, 290, 50, 20);

            } else {
                gc.setFill(Color.BLACK);

            }
            extendAngle = count.get(name);
            extendAngle = extendAngle / countTotal;
            extendAngle *= 360;

            //Makes Pie Chart
            gc.fillArc(400, 100, 300, 300, startAngle, extendAngle, ArcType.ROUND);
            gc.strokeArc(400, 100, 300, 300, startAngle, extendAngle, ArcType.ROUND);
            startAngle += extendAngle;

        }
    }

    private TreeMap<String, Integer> getCount() {
        File inFile = new File("weatherwarnings-2015.csv");
        String line;
        TreeMap<String, Integer> Map = new TreeMap<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(inFile));
            while ((line = in.readLine()) != null) {
                String[] data = line.split(",");
                if (Map.containsKey(data[5])) {
                    int newValue = Map.get(data[5]);
                    newValue++;
                    Map.put(data[5], newValue);
                }
                else {
                    Map.put(data[5], 1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Map;

    }


}
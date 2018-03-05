package com.company;

import javafx.application.Application;
//import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.image.*;
//import javafx.collections.*;
//import javafx.event.*;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.cell.*;

//import java.io.File;
//import java.net.URL;
//import java.net.URLClassLoader;

public class Main extends Application {
    private Stage window;
    private BorderPane layout;
    private TableView<StudentRecord> table;
    private TextField sidField, midField, assignField, finalField;
    private String currentFile;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lab 5");

        /* create the menu (for the top of the user interface) */
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New", imageFile("images/new.png"));
        newMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        fileMenu.getItems().add(newMenuItem);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Open...", imageFile("images/open.png")));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Save", imageFile("images/save.png")));
        fileMenu.getItems().add(new MenuItem("Save As...", imageFile("images/save_as.png")));
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem exitMenuItem = new MenuItem("Exit", imageFile("images/exit.png"));
        fileMenu.getItems().add(exitMenuItem);
        exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        exitMenuItem.setOnAction( e -> System.exit(0) );

        Menu editMenu = new Menu("Edit");
        editMenu.getItems().add(new MenuItem("Cut", imageFile("images/cut.png")));
        editMenu.getItems().add(new MenuItem("Copy", imageFile("images/copy.png")));
        editMenu.getItems().add(new MenuItem("Paste", imageFile("images/paste.png")));

        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().add(new MenuItem("About...", imageFile("images/about.png")));
        helpMenu.getItems().add(new SeparatorMenuItem());
        helpMenu.getItems().add(new MenuItem("Help...", imageFile("images/help.png")));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(editMenu);
        menuBar.getMenus().add(helpMenu);

        /* create the table (for the center of the user interface) */
        table = new TableView<>();
        table.setItems(DataSource.getAllMarks());
        table.setEditable(true);

        /* create the table's columns */
        TableColumn<StudentRecord, String> sidColumn = null;
        sidColumn = new TableColumn<>("SID");
        sidColumn.setMinWidth(100);
        sidColumn.setCellValueFactory(new PropertyValueFactory<>("sid"));

        TableColumn<StudentRecord,Double> assignmentsColumn = null;
        assignmentsColumn = new TableColumn<>("Assignments");
        assignmentsColumn.setMinWidth(100);
        assignmentsColumn.setCellValueFactory(new PropertyValueFactory<>("assignments"));


        TableColumn<StudentRecord,Double> midtermColumn = null;
        midtermColumn = new TableColumn<>("Midterm");
        midtermColumn.setMinWidth(100);
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        TableColumn<StudentRecord,Double> finalExamColumn = null;
        finalExamColumn = new TableColumn<>("Final Exam");
        finalExamColumn.setMinWidth(100);
        finalExamColumn.setCellValueFactory(new PropertyValueFactory<>("finalExam"));

        TableColumn<StudentRecord,Double> finalGradeColumn = null;
        finalGradeColumn = new TableColumn<>("Final Mark");
        finalGradeColumn.setMinWidth(100);
        finalGradeColumn.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        TableColumn<StudentRecord,String> letterGradeColumn = null;
        letterGradeColumn = new TableColumn<>("Letter Grade");
        letterGradeColumn.setMinWidth(100);
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));


        table.getColumns().add(sidColumn);
        table.getColumns().add(assignmentsColumn);
        table.getColumns().add(midtermColumn);
        table.getColumns().add(finalExamColumn);
        table.getColumns().add(finalGradeColumn);
        table.getColumns().add(letterGradeColumn);


        /* arrange all components in the main user interface */
        layout = new BorderPane();

        layout.setCenter(table);


        Scene scene = new Scene(layout, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView imageFile(String filename) {
        return new ImageView(new Image("file:"+filename));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
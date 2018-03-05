import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.*;
import java.io.File;

/*
    Name: Margie Patel and Tijauni Carey
    Date: 5/03/2018
    Name of Program: Spam Master 3000

    This is the Spam Master 3000 program designed to detect spam e-mail
    in an folder full of e-mails, it will print out a UI that will show
    the name of the file(File), the actual class, and the probability
    of the emails that spam emails(Spam Probability).
 */

public class Main extends Application {
    private double hcg=0;
    private double scg=0;
    private double nt=0;
    private double nf=0;
    private double g=0;
    private Stage window;
    private BorderPane layout;
    private TableView<TestFile> table;
    private double accuracy;
    private double precision;

    @Override

    /*
        The start method is used to set up the UI
        @param primaryStage - it is set up to place the table,
        the label, and does the accuracy and precision of the
        detection
     */
    public void start(Stage mainStage) throws Exception {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("."));
        File mainDirectory = directoryChooser.showDialog(mainStage);

        mainStage.setTitle("Spam Master 3000");

        /* Creates the table (for the center of the UI) */
        table = new TableView<>();
        DataSource dataSource = new DataSource(mainDirectory);
        ObservableList<TestFile> mails=dataSource.getAllMail();
        table.setItems(mails);
        table.setEditable(true);

        /* Create the table's columns */
        TableColumn<TestFile, String> fileColumn = null;
        fileColumn = new TableColumn<>("File");
        fileColumn.setMinWidth(250);
        fileColumn.setCellValueFactory(new PropertyValueFactory<>("filename"));

        TableColumn<TestFile, String> classColumn = null;
        classColumn = new TableColumn<>("Actual Class");
        classColumn.setMinWidth(150);
        classColumn.setCellValueFactory(new PropertyValueFactory<>("actualClass"));

        TableColumn<TestFile, Double> spamColumn = null;
        spamColumn = new TableColumn<>("Spam Probability");
        spamColumn.setMinWidth(250);
        spamColumn.setCellValueFactory(new PropertyValueFactory<>("spamProbRounded"));

        table.getColumns().add(fileColumn);
        table.getColumns().add(classColumn);
        table.getColumns().add(spamColumn);

        GridPane displayArea = new GridPane();
        displayArea.setPadding(new Insets(10, 10, 10, 10));
        displayArea.setVgap(10);
        displayArea.setHgap(10);

        mails.forEach((mail)->{
            if (mail.getSpamProbability() >=0 && mail.getSpamProbability() <0.5 && mail.getActualClass().equalsIgnoreCase("ham"))
            {
                hcg +=1;
            }
            if (mail.getSpamProbability() >=0.5 && mail.getSpamProbability() <=1.0&& mail.getActualClass().equalsIgnoreCase("spam"))
            {
                scg +=1;
            }
            if (mail.getSpamProbability()>0.5 && mail.getActualClass().equalsIgnoreCase("spam"))
            {
                nt +=1;
            }
            if(mail.getActualClass().equalsIgnoreCase("spam"))
            {
                nf +=1;
            }
            g +=1;
        });

        accuracy = (scg + hcg)/g;
        precision = nt / (nf);
        Label accuracyLabel = new Label("Accuracy:");
        displayArea.add(accuracyLabel, 0, 0);
        TextField accuracyField = new TextField(accuracy+"");
        displayArea.add(accuracyField, 1, 0);
        accuracyField.setEditable(false);

        Label precisionLabel = new Label("Precision:");
        displayArea.add(precisionLabel, 0, 1);
        TextField precisionField = new TextField(String.valueOf(precision));
        displayArea.add(precisionField, 1, 1);
        precisionField.setEditable(false);

        layout = new BorderPane();
        layout.setCenter(table);
        layout.setBottom(displayArea);
        Scene scene = new Scene(layout, 650, 400);

        mainStage.setScene(scene);
        mainStage.show();
    }

    /*
        This start method is used to launch the program with the UI
        @param args - this are the arguements required to run or compile the program
     */
    public static void main(String[] args) {
        launch(args);
    }
}
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuApp extends Application {

    private TextArea textArea;
    private BorderPane root;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        //  main layout
        root = new BorderPane();
        root.setPadding(new Insets(10));
        
        // menu bar
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        
        // menu items
        MenuItem dateTimeItem = new MenuItem("Date & Time");
        MenuItem saveFileItem = new MenuItem("Save to File");
        MenuItem changeColorItem = new MenuItem("Change Color");
        MenuItem exitItem = new MenuItem("Exit");
        
        // add menu items to menu
        menu.getItems().addAll(dateTimeItem, saveFileItem, changeColorItem, exitItem);
        
        // add menu to menu bar
        menuBar.getMenus().add(menu);
        
        // text area
        textArea = new TextArea();
        textArea.setPromptText("Content will appear here...");
        textArea.setPrefRowCount(10);
        textArea.setWrapText(true);
        
        // container for the text area
        VBox textContainer = new VBox(textArea);
        textContainer.setPadding(new Insets(10));
        
        // Add to main layout
        root.setTop(menuBar);
        root.setCenter(textContainer);
        
        // set actions
        dateTimeItem.setOnAction(e -> showDateTime());
        saveFileItem.setOnAction(e -> saveToFile());
        changeColorItem.setOnAction(e -> changeBackgroundColor());
        exitItem.setOnAction(e -> exitApplication());
        
        // create scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
     // display current date and time
    private void showDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        textArea.setText("Current Date and Time: " + formattedDateTime);
    }
    
     // save to a file 
    private void saveToFile() {
        try (FileWriter writer = new FileWriter("log.txt")) {
            writer.write(textArea.getText());
            textArea.setText("File saved as log.txt");
        } catch (IOException e) {
            textArea.setText("Error saving file: " + e.getMessage());
        }
    }
     // change background color to  random shade of green
    private void changeBackgroundColor() {
        // generate random green color
        // red component 
        int red = random.nextInt(100);
        // green component 
        int green = 150 + random.nextInt(106); 
        // blue component 
        int blue = random.nextInt(100);
        
        // converting  RGB to JavaFX Color 
        Color randomGreen = Color.rgb(red, green, blue);
        
        // applying color to background
        root.setStyle("-fx-background-color: rgb(" + red + "," + green + "," + blue + ");");
        
        // display color values
        textArea.setText("Background changed to green: RGB(" + red + ", " + green + ", " + blue + ")");
    }
    
     // exit the application
    private void exitApplication() {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 

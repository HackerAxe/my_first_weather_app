package io.github.hackeraxe;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application{
    public static void main(String[] args){
        /**
         * The main class simply launches the application.
         */
        launch();
    }

    public void start(Stage primaryStage) throws Exception{
        WeatherView wv = new WeatherView();
        WeatherController wc = new WeatherController(wv);
        Scene sc = new Scene(wv.getRoot());
        primaryStage.setTitle("The Mentally Ill Pookie Weather App");
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
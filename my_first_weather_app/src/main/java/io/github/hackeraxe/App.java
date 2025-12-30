package io.github.hackeraxe;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class App extends Application{
    public static void main(String[] args){
        launch();
    }

    public static void displayWeather(Weather weather){
        System.out.println("Temperature: " + weather.getTemperature() +
        "\nWind Speed: " + weather.getWindspeed() + 
        "\nWeather Code: " + weather.getWeatherCode());
    }

    public void start(Stage primaryStage) throws Exception{
        Weather ourWeather = new Weather();

        Label tempLabel = new Label("Temperature: " + ourWeather.getTemperature());
        Label windspeedLabel = new Label("Wind Speed: " + ourWeather.getWindspeed());
        Label weatherCode = new Label("Weather Code: " + ourWeather.getWeatherCode());

        VBox root = new VBox(10, tempLabel, windspeedLabel, weatherCode);
        Scene sc = new Scene(root);
        primaryStage.setTitle("The Mentally Ill Pookie Weather App");
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
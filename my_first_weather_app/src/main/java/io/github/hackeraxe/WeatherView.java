package io.github.hackeraxe;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
public class WeatherView {
    Label tempLabel = new Label();
    Label windSpeedLabel = new Label();
    Label weatherCodeLabel = new Label();
    VBox root = new VBox();
    /**
     * Initialize the Weather UI
     */
    public WeatherView(){
        /**
         * add just adds one child, but addAll adds multiple after .getChildren().
         */
        root.getChildren().addAll(tempLabel, windSpeedLabel, weatherCodeLabel);
    } 

    /**
     * We need to return the layout so that this can be added to the scene in the launcer (App.java)
     * @return The layout
     */
    public VBox getRoot(){
        return this.root;
    }

    /**
     * Whenever the user presses update, we must update the data that is displayed. Remember, the 
     * CONTROLLER DECIDES what logic is displayed. The VIEW only displays it.
     * @param 
     */

    public void update(Weather weatherModel){

        // Use setText to set the text of a label.
        tempLabel.setText("Temperature: " + weatherModel.getTemperature());
        windSpeedLabel.setText("Wind Speed: " + weatherModel.getWindspeed());
        weatherCodeLabel.setText("Wind Code: " + weatherModel.getWeatherCode());
    }
}

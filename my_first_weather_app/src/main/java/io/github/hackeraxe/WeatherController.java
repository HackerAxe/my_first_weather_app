package io.github.hackeraxe;

public class WeatherController {
    private WeatherView weatherView;

    public WeatherController(WeatherView wv){
        this.weatherView = wv;

        //Intial load
        refresh();
        wv.getRefreshButton().setOnAction(e -> refresh());
    }

    /**
     * When the user presses the refresh button, this refresh logic is called, telling the
     * WeatherView class that it needs to update what it is displaying.
     */
    public void refresh(){
        Weather weatherModel = new Weather();
        weatherView.update(weatherModel);
        System.out.println("Refresh button pressed.");
    }
}

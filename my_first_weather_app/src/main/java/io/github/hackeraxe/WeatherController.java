package io.github.hackeraxe;

public class WeatherController {
    private WeatherView weatherView;
    public WeatherController(WeatherView wv){
        this.weatherView = wv;
    }

    public void refresh(){
        Weather weatherModel = new Weather();
        weatherView.update(weatherModel);
    }
}

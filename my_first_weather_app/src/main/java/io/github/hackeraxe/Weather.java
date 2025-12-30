package io.github.hackeraxe;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Weather {
    private double temperature = 0.0;
    private double windspeed = 0.0;
    private int weathercode = 0;

    public Weather(){
        setWeather();
    }

    /**
     * Retrieves weather data response from Open-Meteo API
     * @return The JSON in the form of a string
     */
    private String getWeatherJson(){
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://api.open-meteo.com/v1/forecast?latitude=40.44&longitude=-79.97&current_weather=true";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();
            return jsonString;
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
            return "ERR";
        }
    }

    /**
     * Parses the JSON String
     * @return A JsonObject that can extract the weather data, such as temp, windspeed, and weathercode
     */
    private JsonObject parseJson(){
        String jsonString = getWeatherJson();
        if(jsonString.compareTo("ERR") == 0){
                System.out.println("There was an error with parsing the JSON.");
                return null;
            }else{
                JsonObject root = JsonParser.parseString(jsonString).getAsJsonObject();
                JsonObject current = root.getAsJsonObject("current_weather");
                return current;   
            }  
    }

    /**
     * Sets the temperature, windspeed, and weathercode
     */
    private void setWeather(){
        JsonObject weather = parseJson();
        if (weather == null){
            System.out.println("Something went wrong with the json.");
        }else{
            temperature = weather.get("temperature").getAsDouble();
            windspeed = weather.get("windspeed").getAsDouble();
            weathercode = weather.get("weathercode").getAsInt();
        }
    }

    /**
     * temp getter
     * @return temperature as double
     */
    public double getTemperature(){
        return (temperature * 9.0/5.0) + 32.0;
    }

    /**
     * windspeed getter
     * @return wind speed as double
     */
    public double getWindspeed(){
        return windspeed;
    }

    /**
     * weathercode getter
     * @return weather code as int
     */
    public int getWeatherCode(){
        return weathercode;
    }
}

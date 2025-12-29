package io.github.hackeraxe;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Weather {
    double temperature = 0.0;
    double windspeed = 0.0;
    int weathercode = 0;

    public Weather(){
        setWeather();
    }
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

    private void setWeather(){
        JsonObject weather = parseJson();
        if (weather == null){
            System.out.println("Something went wrong with the json.");
            return;
        }else{
            temperature = weather.get("temperature").getAsDouble();
            windspeed = weather.get("windspeed").getAsDouble();
            weathercode = weather.get("weathercode").getAsInt();
        }
    }

    public double getTemperature(){
        return temperature;
    }

    public double getWindspeed(){
        return windspeed;
    }

    public int getWeatherCode(){
        return weathercode;
    }
}

package io.github.hackeraxe;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App{
    public static void main(String[] args){
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://api.open-meteo.com/v1/forecast?latitude=40.44&longitude=-79.97&current_weather=true";
        
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();
            JsonObject root = JsonParser.parseString(jsonString).getAsJsonObject();
            JsonObject current = root.getAsJsonObject("current_weather");

            double temperature = current.get("temperature").getAsDouble();
            double windspeed = current.get("windspeed").getAsDouble();
            int weathercode = current.get("weathercode").getAsInt();

            System.out.println("Temperature: " + temperature + "\nWind Speed: " + windspeed + "\nWeather Code: " + weathercode);
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
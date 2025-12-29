package io.github.hackeraxe;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*
notes:
    APIs work in the general same way. client manages the connection, the request is what we're wanting and where we're going to
    get the information, and the response is the internet call itself, and gives us the data we want.

    gson is a library that can parse jsons for us. we should know the structure of a json... but we shouldn't worry about
    HOW it parses it. (abstraction)

TO DO FOR TOMORROW:
    - split the methods via their tasks. One method to retrieve the json data, one method to parse it, and one method to 
    display the information

    - create junit tests for this application

    - apply CS1530 knowledge. think about what kind of design pattern we're using here. How could we write this as a uml? 
    what's the structure? How can we write about what we've learned in a way that can be shown to others?
*/
public class App{
    public static void main(String[] args){
        //sends requests, receive responses. manages the connection
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://api.open-meteo.com/v1/forecast?latitude=40.44&longitude=-79.97&current_weather=true";
        
        //the http request uses the url to create the destination with the uri, then build finalizes the request
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try{

            //the network call itself
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();

            //gson parses the json

            JsonObject root = JsonParser.parseString(jsonString).getAsJsonObject();
            JsonObject current = root.getAsJsonObject("current_weather");

            //Get the temp, windsped, and weathercode from the json object and split it into variables

            double temperature = current.get("temperature").getAsDouble();
            double windspeed = current.get("windspeed").getAsDouble();
            int weathercode = current.get("weathercode").getAsInt();

            System.out.println("Temperature: " + temperature + "\nWind Speed: " + windspeed + "\nWeather Code: " + weathercode);
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
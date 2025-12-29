package io.github.hackeraxe;



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
        Weather ourWeather = new Weather();
        displayWeather(ourWeather);
    }

    public static void displayWeather(Weather weather){
        System.out.println("Temperature: " + weather.getTemperature() +
        "\nWind Speed: " + weather.getWindspeed() + 
        "\nWeather Code: " + weather.getWeatherCode());
    }
}
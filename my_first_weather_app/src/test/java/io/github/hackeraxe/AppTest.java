package io.github.hackeraxe;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Test that a weather object is successfully created.
     */
    @Test
    public void testNewWeatherObject()
    {
        Weather myWeather = new Weather();
        assertNotNull(myWeather);
    }

    public void testGetWeather(){
        double testTemp, testWindSpeed;
        int testWeatherCode;
        Weather myWeather = new Weather();
        testTemp = myWeather.getTemperature();
        testWindSpeed = myWeather.getWindspeed();
        testWeatherCode = myWeather.getWeatherCode();

        /**
         * This test should pass if the data was properly fetched, and fail
         * if it was not (aka, the values remained at the default zeroed values.)
         */
        assertFalse(testTemp == 0.0 && testWindSpeed == 0.0 && testWeatherCode == 0);
    }
}

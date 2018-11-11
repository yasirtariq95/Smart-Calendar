import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;

public class TestClass {
    public static void main(String args[]) throws APIException {
        OWM owm = new OWM("4aabea27c4cde244047df5dac05c26e2");
        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("Atlanta");

        // checking data retrieval was successful or not
        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

            // checking if city name is available
            if (cwd.hasCityName()) {
                //printing city name from the retrieved data
                System.out.println("City: " + cwd.getCityName());
            }

            // checking if max. temp. and min. temp. is available
            if (cwd.hasMainData() && cwd.getMainData().hasTempMax() && cwd.getMainData().hasTempMin()) {
                // printing the max./min. temperature
                System.out.println("Temperature: " + cwd.getMainData().getTempMax() + "/" + cwd.getMainData().getTempMin() + "\'K");
            }
            if (cwd.hasRainData() == false)
                System.out.println("IT NOT RAINING");
        }
    }
}
/*
    public static void main(String[] args)
            throws APIException {

        // declaring object of "OWM" class
        OWM owm = new OWM("YOUR-API-KEY-HERE");

        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("London");

        // checking data retrieval was successful or not
        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

            // checking if city name is available
            if (cwd.hasCityName()) {
                //printing city name from the retrieved data
                System.out.println("City: " + cwd.getCityName());
            }

            // checking if max. temp. and min. temp. is available
            if (cwd.hasMainData() && cwd.getMainData().hasTempMax() && cwd.getMainData().hasTempMin()) {
                // printing the max./min. temperature
                System.out.println("Temperature: " + cwd.getMainData().getTempMax()
                        + "/" + cwd.getMainData().getTempMin() + "\'K");
            }
        }
    }

    OWM owm = new OWM("4aabea27c4cde244047df5dac05c26e2");
        HourlyWeatherForecast hwd = owm.hourlyWeatherForecastByCityName("London");

        System.out.println("City: " + hwd.getCityData().getName());

        for (WeatherData data: hwd.getDataList()) {
            System.out.println("Data datetime: " + data.getDateTime());
        }
    */
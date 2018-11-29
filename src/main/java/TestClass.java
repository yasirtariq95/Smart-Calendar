import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;
import org.json.*;


public class TestClass {
    public static void main(String args[]) throws APIException {
        OWM owm = new OWM("4aabea27c4cde244047df5dac05c26e2");
        // getting current weather data for the "London" city
        //CurrentWeather cwd = owm.currentWeatherByCityName("Atlanta");
        HourlyWeatherForecast hwd = owm.hourlyWeatherForecastByCityName("Atlanta");
        //System.out.println("City: " + hwd.getCityData().getName());

       // for (WeatherData data: hwd.getDataList()) {
            //System.out.println("Data datetime: " + data.getDateTime());
       //     System.out.println("Data WeatherList: " + data.getWeatherList());
        //}
        //https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
        System.out.println(hwd.toJsonPretty(hwd));
        JSONObject obj = new JSONObject(hwd.toJsonPretty(hwd));

        //System.out.println(hwf.getDataList());
        //System.out.println(hwf.toJson(hwf));
        //System.out.println(hwf.toJsonPretty(hwf));
        //System.out.println(dwf.getMessage());
        // checking data retrieval was successful or not
        //if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

            // checking if city name is available
            //if (cwd.hasCityName()) {
                //printing city name from the retrieved data
               // System.out.println("City: " + cwd.getCityName());
           // }

            // checking if max. temp. and min. temp. is available
            //if (cwd.hasMainData() && cwd.getMainData().hasTempMax() && cwd.getMainData().hasTempMin()) {
                // printing the max./min. temperature
            //    System.out.println("Temperature: " + cwd.getMainData().getTempMax() + "/" + cwd.getMainData().getTempMin() + "\'K");
            }
            //if (cwd.hasRainData() == false)
            //    System.out.println("IT NOT RAINING");
       // }
    }
//}
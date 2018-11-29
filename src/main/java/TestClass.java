import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;
import org.json.*;


public class TestClass {
    public static void main(String args[]) throws APIException {
        OWM owm = new OWM("4aabea27c4cde244047df5dac05c26e2");
        HourlyWeatherForecast hwd = owm.hourlyWeatherForecastByCityName("Atlanta");
        //System.out.println("City: " + hwd.getCityData().getName());

       // for (WeatherData data: hwd.getDataList()) {
            //System.out.println("Data datetime: " + data.getDateTime());
       //     System.out.println("Data WeatherList: " + data.getWeatherList());
        //}
        //https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
        //System.out.println(hwd.toJsonPretty(hwd));
        JSONObject obj = new JSONObject(hwd.toJsonPretty(hwd));
        System.out.println(obj);
        JSONArray arr = obj.getJSONArray("list");
        for (int i = 0; i < arr.length(); i++) {
            JSONArray arr2 = obj.getJSONArray("weather");
            String weather = arr2.getJSONObject(i).getString("main");
            System.out.println(weather);
        }
        //JSONArray arr = obj.getJSONArray("posts");
        //for (int i = 0; i < arr.length(); i++){
        //    String post_id = arr.getJSONObject(i).getString("post_id");
        //}

        //System.out.println(hwf.getDataList());
        //System.out.println(hwf.toJson(hwf));
        //System.out.println(hwf.toJsonPretty(hwf));
            }
    }
//}
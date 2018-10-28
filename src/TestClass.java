import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
//import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;

public class TestClass {
	public static void main(String args[]) throws APIException {
	    OWM owm = new OWM("4aabea27c4cde244047df5dac05c26e2");
	    HourlyWeatherForecast hwd = owm.hourlyWeatherForecastByCityName("London");

	    System.out.println("City: " + hwd.getCityData().getName());

	    for (WeatherData data: hwd.getDataList()) {
	      System.out.println("Data datetime: " + data.getDateTime());
	    }
	  }
}
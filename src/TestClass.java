import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

public class TestClass {
	public static void main(String[] args) {
		System.out.println("FUCK");
		throws APIException {

	        // declaring object of "OWM" class
	        OWM owm = new OWM("4aabea27c4cde244047df5dac05c26e2");

	        // getting current weather data for the "London" city
	        CurrentWeather cwd = owm.currentWeatherByCityName("London");

	        //printing city name from the retrieved data
	        System.out.println("City: " + cwd.getCityName());

	        // printing the max./min. temperature
	        System.out.println("Temperature: " + cwd.getMainData().getTempMax() + "/" + cwd.getMainData().getTempMin() + "\'K");
	    }
	}
}

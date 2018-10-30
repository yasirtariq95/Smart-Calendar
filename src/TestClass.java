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
/*
https://stackoverflow.com/questions/43425367/mapdb-classnotfoundexception-kotlin-jvm-internal-intrinsics#44734211
https://maven.apache.org/plugins/maven-assembly-plugin/
https://maven.apache.org/plugins/index.html
https://stackoverflow.com/questions/6079253/running-maven-exec-plugin-inside-eclipse#6083254
https://bitbucket.org/aksinghnet/owm-japis/src
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/index.html
https://kotlinlang.org/api/latest/jvm/stdlib/index.html
https://discuss.kotlinlang.org/t/kotlin-jar-being-called-by-java-application-kotlin-jvm-internal-intrinsics/9054
*/
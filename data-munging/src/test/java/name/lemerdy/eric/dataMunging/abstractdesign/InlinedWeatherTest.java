package name.lemerdy.eric.dataMunging.abstractdesign;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class InlinedWeatherTest {

    @Test
    public void acceptance() throws IOException {
        URL weatherFile = getResource("weather.dat");

        Integer minTemperatureSpreadDay = InlinedWeather.minTemperatureSpreadDay(weatherFile);

        assertThat(minTemperatureSpreadDay).isEqualTo(14);
    }
}
package name.lemerdy.eric.dataMunging.abstractdesign;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;

public class InlinedWeatherTest {

    @Test
    public void acceptance() throws IOException {
        URL weatherFile = getResource("weather.dat");

        Optional<Integer> minTemperatureSpreadDay = InlinedWeather.minTemperatureSpreadDay(weatherFile);

        assertThat(minTemperatureSpreadDay).isPresent().hasValue(14);
    }

    @Test
    public void with_empty_file() throws IOException {
        URL footballFile = getResource("empty.dat");

        Optional<Integer> minTemperatureSpreadDay = InlinedWeather.minTemperatureSpreadDay(footballFile);

        assertThat(minTemperatureSpreadDay).isEmpty();
    }
}
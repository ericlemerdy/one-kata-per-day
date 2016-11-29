package name.lemerdy.eric.dataMunging.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.io.Resources.getResource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class SmallestTemperatureSpreadTest {

    @Mock
    private WeatherFileReader weatherFileReader;

    @InjectMocks
    private SmallestTemperatureSpread smallestTemperatureSpread;

    @Test
    public void should_find_day_of_the_smallest_temperature_in_extremum_value() throws IOException {
        List<TemperatureExtremum> extrema = newArrayList(
                new TemperatureExtremum(1, 88, 59),
                new TemperatureExtremum(2, 79, 53));
        doReturn(extrema).when(weatherFileReader).readFile();

        Integer minTemperaturesSpread = smallestTemperatureSpread.minTemperatureSpreadDay();

        assertThat(minTemperaturesSpread).isEqualTo(2);
    }

    @Test
    public void acceptance() throws IOException {
        URL weatherFile = getResource("weather.dat");
        WeatherFileLineProcessor weatherFileLineProcessor = new WeatherFileLineProcessor();
        WeatherFileReader weatherFileReader = new WeatherFileReader(weatherFile, weatherFileLineProcessor);
        SmallestTemperatureSpread smallestTemperatureSpread = new SmallestTemperatureSpread(weatherFileReader);

        Integer minTemperatureSpreadDay = smallestTemperatureSpread.minTemperatureSpreadDay();

        assertThat(minTemperatureSpreadDay).isEqualTo(14);
    }
}